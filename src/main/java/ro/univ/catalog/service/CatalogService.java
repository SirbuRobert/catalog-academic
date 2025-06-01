package ro.univ.catalog.service;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import ro.univ.catalog.model.*;

/**
 * Serviciul principal pentru gestionarea catalogului academic
 * Contine toate operatiile de business si gestionarea colectiilor
 */
public class CatalogService {
    // Colectii pentru gestionarea entitatilor
    private List<Student> studenti;                    // Lista pentru studenti
    private TreeSet<Profesor> profesori;               // Set sortat pentru profesori
    private HashMap<String, Materie> materii;          // Map pentru materii (cod -> materie)
    private TreeMap<Student, List<Nota>> catalog;      // Map sortat pentru catalog (student -> note)
    private List<Specializare> specializari;
    private List<Departament> departamente;
    
    public CatalogService() {
        this.studenti = new ArrayList<>();
        this.profesori = new TreeSet<>();
        this.materii = new HashMap<>();
        this.catalog = new TreeMap<>();
        this.specializari = new ArrayList<>();
        this.departamente = new ArrayList<>();
    }
    
    // ===== OPERATII PENTRU STUDENTI =====
    public void adaugaStudent(Student student) {
        if (student != null && !studenti.contains(student)) {
            studenti.add(student);
            catalog.put(student, new ArrayList<>());
            System.out.println(" Student adaugat: " + student);
        } else {
            System.out.println(" Studentul exista deja sau este null!");
        }
    }
    
    public Student cautaStudentDupaNumeComplet(String numeComplet) {
        for (Student student : studenti) {
            if (student.getNumeComplet().equalsIgnoreCase(numeComplet)) {
                return student;
            }
        }
        return null;
    }
    
    public Student cautaStudentDupaMatricol(String nrMatricol) {
        for (Student student : studenti) {
            if (student.getNrMatricol().equals(nrMatricol)) {
                return student;
            }
        }
        return null;
    }
    
    public List<Student> getStudentiDupaAn(int an) {
        return studenti.stream()
                .filter(s -> s.getAnStudiu() == an)
                .collect(Collectors.toList());
    }
    
    public List<Student> getStudentiDinSpecializare(Specializare specializare) {
        return studenti.stream()
                .filter(s -> s.getSpecializare().equals(specializare))
                .collect(Collectors.toList());
    }
    
    public List<Student> getStudentiBursieri() {
        return studenti.stream()
                .filter(Student::areBursa)
                .collect(Collectors.toList());
    }
    
    // ===== OPERATII PENTRU PROFESORI =====
    public void adaugaProfesor(Profesor profesor) {
        if (profesor != null) {
            profesori.add(profesor);
            System.out.println(" Profesor adaugat: " + profesor);
        }
    }
    
    public List<Profesor> getProfesoriDupaDepartament(String numeDepartament) {
        return profesori.stream()
                .filter(p -> p.getDepartament().getNume().equalsIgnoreCase(numeDepartament))
                .collect(Collectors.toList());
    }
    
    public List<Profesor> getProfesoriDupaGrad(String grad) {
        return profesori.stream()
                .filter(p -> p.getGrad().equalsIgnoreCase(grad))
                .collect(Collectors.toList());
    }
    
    // ===== OPERATII PENTRU MATERII =====
    public void adaugaMaterie(Materie materie) {
        if (materie != null && !materii.containsKey(materie.getCod())) {
            materii.put(materie.getCod(), materie);
            System.out.println(" Materie adaugata: " + materie);
        } else {
            System.out.println(" Materia exista deja sau este null!");
        }
    }
    
    public void asigneazaProfesorLaMaterie(String codMaterie, Profesor profesor) {
        Materie materie = materii.get(codMaterie);
        if (materie != null && profesor != null) {
            materie.setProfesor(profesor);
            System.out.println(" Profesor " + profesor.getNumeComplet() + 
                             " asignat la materia " + materie.getNume());
        } else {
            System.out.println(" Materia sau profesorul nu exista!");
        }
    }
    
    public List<Materie> getMateriiProfesor(Profesor profesor) {
        return materii.values().stream()
                .filter(m -> m.getProfesor() != null && m.getProfesor().equals(profesor))
                .collect(Collectors.toList());
    }
    
    public List<Materie> getMateriiDupaAn(int an) {
        return materii.values().stream()
                .filter(m -> m.getAnStudiu() == an)
                .collect(Collectors.toList());
    }
    
    // ===== OPERATII PENTRU NOTE =====
    public void adaugaNota(String nrMatricol, String codMaterie, double valoare, 
                          String tipEvaluare) {
        Student student = cautaStudentDupaMatricol(nrMatricol);
        Materie materie = materii.get(codMaterie);
        
        if (student != null && materie != null) {
            try {
                Nota nota = new Nota(student, materie, valoare, tipEvaluare);
                catalog.get(student).add(nota);
                System.out.println(" Nota adaugata: " + nota);
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        } else {
            System.out.println(" Studentul sau materia nu exista!");
        }
    }
    
    public void adaugaNota(String nrMatricol, String codMaterie, double valoare, 
                          LocalDate dataExamen, String tipEvaluare) {
        Student student = cautaStudentDupaMatricol(nrMatricol);
        Materie materie = materii.get(codMaterie);
        
        if (student != null && materie != null) {
            try {
                Nota nota = new Nota(student, materie, valoare, dataExamen, tipEvaluare);
                catalog.get(student).add(nota);
                System.out.println(" Nota adaugata: " + nota);
            } catch (IllegalArgumentException e) {
                System.out.println(" " + e.getMessage());
            }
        } else {
            System.out.println(" Studentul sau materia nu exista!");
        }
    }
    
    public double calculeazaMedieStudent(Student student) {
        List<Nota> noteStudent = catalog.get(student);
        if (noteStudent == null || noteStudent.isEmpty()) {
            return 0.0;
        }
        
        return noteStudent.stream()
                .mapToDouble(Nota::getValoare)
                .average()
                .orElse(0.0);
    }
    
    public double calculeazaMedieStudentLaMaterie(Student student, Materie materie) {
        List<Nota> noteStudent = catalog.get(student);
        if (noteStudent == null || noteStudent.isEmpty()) {
            return 0.0;
        }
        
        return noteStudent.stream()
                .filter(n -> n.getMaterie().equals(materie))
                .mapToDouble(Nota::getValoare)
                .average()
                .orElse(0.0);
    }
    
    public List<Student> getStudentiInscrisaLaMaterie(String codMaterie) {
        return catalog.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .anyMatch(n -> n.getMaterie().getCod().equals(codMaterie)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    public List<Student> getStudentiPromovatiLaMaterie(String codMaterie) {
        return catalog.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .anyMatch(n -> n.getMaterie().getCod().equals(codMaterie) && n.estePromovata()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    // ===== OPERATII PENTRU SPECIALIZARI SI DEPARTAMENTE =====
    public void adaugaSpecializare(Specializare specializare) {
        if (specializare != null && !specializari.contains(specializare)) {
            specializari.add(specializare);
            System.out.println(" Specializare adaugata: " + specializare);
        }
    }
    
    public void adaugaDepartament(Departament departament) {
        if (departament != null && !departamente.contains(departament)) {
            departamente.add(departament);
            System.out.println(" Departament adaugat: " + departament);
        }
    }
    
    // ===== OPERATII DE STATISTICI =====
    public void afiseazaStatisticiGenerale() {
        System.out.println("==================================================");
        System.out.println(" STATISTICI GENERALE");
        System.out.println("==================================================");
        System.out.println(" Total studenti: " + studenti.size());
        System.out.println(" Total profesori: " + profesori.size());
        System.out.println(" Total materii: " + materii.size());
        System.out.println(" Total specializari: " + specializari.size());
        System.out.println(" Total departamente: " + departamente.size());
        
        long totalNote = catalog.values().stream().mapToLong(List::size).sum();
        System.out.println(" Total note: " + totalNote);
        
        long studentiBursieri = studenti.stream().mapToLong(s -> s.areBursa() ? 1 : 0).sum();
        System.out.println(" Studenti bursieri: " + studentiBursieri);
        
        if (!studenti.isEmpty()) {
            double medieGenerala = studenti.stream()
                    .mapToDouble(this::calculeazaMedieStudent)
                    .filter(medie -> medie > 0)
                    .average()
                    .orElse(0.0);
            System.out.println(" Media generala: " + String.format("%.2f", medieGenerala));
        }
    }

    // ===== OPERATII DE AFISARE =====
    public void afiseazaToatiStudentii() {
        System.out.println("\n===  LISTA STUDENTILOR ===");
        if (studenti.isEmpty()) {
            System.out.println("Nu exista studenti inregistrati.");
            return;
        }
        
        studenti.forEach(student -> {
            double medie = calculeazaMedieStudent(student);
            System.out.println(student + " | Medie: " + 
                             String.format("%.2f", medie));
        });
    }
    
    public void afiseazaToatiProfesorii() {
        System.out.println("\n===  LISTA PROFESORILOR (sortata) ===");
        if (profesori.isEmpty()) {
            System.out.println("Nu exista profesori inregistrati.");
            return;
        }
        
        profesori.forEach(System.out::println);
    }
    
    public void afiseazaToateMateriiile() {
        System.out.println("\n===  LISTA MATERIILOR ===");
        if (materii.isEmpty()) {
            System.out.println("Nu exista materii inregistrate.");
            return;
        }
        
        materii.values().forEach(System.out::println);
    }
    
    public void afiseazaCatalog() {
        System.out.println("\n===  CATALOGUL COMPLET ===");
        if (catalog.isEmpty()) {
            System.out.println("Catalogul este gol.");
            return;
        }
        
        catalog.entrySet().forEach(entry -> {
            Student student = entry.getKey();
            List<Nota> note = entry.getValue();
            
            System.out.println("\n Student: " + student.getNumeComplet() + 
                             " (" + student.getNrMatricol() + ")");
            
            if (note.isEmpty()) {
                System.out.println("   Nicio nota inregistrata");
            } else {
                note.forEach(nota -> 
                    System.out.println("   " + nota.getMaterie().getNume() + 
                                     ": " + nota.getValoare() + " (" + nota.getTipEvaluare() + 
                                     ", " + nota.getDataFormatata() + ")"));
                System.out.println("   Medie: " + String.format("%.2f", calculeazaMedieStudent(student)));
            }
        });
    }
    
    // ===== GETTERS PENTRU COLECTII =====
    public List<Student> getStudenti() { return new ArrayList<>(studenti); }
    public TreeSet<Profesor> getProfesori() { return new TreeSet<>(profesori); }
    public HashMap<String, Materie> getMaterii() { return new HashMap<>(materii); }
    public List<Specializare> getSpecializari() { return new ArrayList<>(specializari); }
    public List<Departament> getDepartamente() { return new ArrayList<>(departamente); }
    
    // ===== OPERATII DE CAUTARE AVANSATA =====
    public List<Student> cautaStudentiDupaNume(String nume) {
        return studenti.stream()
                .filter(s -> s.getNume().toLowerCase().contains(nume.toLowerCase()) ||
                            s.getPrenume().toLowerCase().contains(nume.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    public List<Materie> cautaMaterii(String text) {
        return materii.values().stream()
                .filter(m -> m.getNume().toLowerCase().contains(text.toLowerCase()) ||
                            m.getCod().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }
}