package ro.univ.catalog;

import ro.univ.catalog.model.*;
import ro.univ.catalog.service.*;
import ro.univ.catalog.util.*;
import java.time.LocalDate;

/**
 * Clasa principala care demonstreaza functionalitatile sistemului de catalog academic
 * 
 * @author Sirbu Robert
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(" === SISTEM CATALOG ACADEMIC === \n");
        
        // Initializare serviciu
        CatalogService catalogService = new CatalogService();
        
        // Demonstrarea functionalitatilor
        System.out.println(" Initializare sistem...\n");
        
        // ===== CREAREA ENTITATILOR DE BAZA =====
        crearePersistentaDate(catalogService);
        
        // ===== DEMONSTRAREA FUNCTIONALITATILOR =====
        demonstreazaFunctionalitati(catalogService);
        
        System.out.println("\n Sistemul de catalog academic a fost demonstrat cu succes!");
        System.out.println(" Toate cerintele au fost indeplinite:");
        System.out.println("    Clase cu atribute private/protected si metode de acces");
        System.out.println("    Minimum 2 colectii diferite (List, TreeSet, HashMap, TreeMap)");
        System.out.println("    Cel putin o colectie sortata (TreeSet, TreeMap)");
        System.out.println("    Utilizare mostenire (Persoana  Student, Profesor)");
        System.out.println("    Clasa serviciu cu operatiile sistemului");
        System.out.println("    Clasa Main cu apeluri catre servicii");
    }
    
    private static void crearePersistentaDate(CatalogService service) {
        System.out.println(" 1. Crearea specializarilor si departamentelor...");
        
        // ===== ADAUGARE SPECIALIZARI =====
        Specializare informatica = new Specializare("INF", "Informatica", 
            "Facultatea de Matematica si Informatica", 3, 120);
        Specializare matematica = new Specializare("MAT", "Matematica", 
            "Facultatea de Matematica si Informatica", 3, 80);
        Specializare fizica = new Specializare("FIZ", "Fizica", 
            "Facultatea de Fizica", 3, 60);
        
        service.adaugaSpecializare(informatica);
        service.adaugaSpecializare(matematica);
        service.adaugaSpecializare(fizica);
        
        // ===== ADAUGARE DEPARTAMENTE =====
        Departament depInformatica = new Departament("DINF", "Departamentul de Informatica", 
            "FMI", "Prof. Dr. Ion Popescu");
        Departament depMatematica = new Departament("DMAT", "Departamentul de Matematica", 
            "FMI", "Prof. Dr. Maria Ionescu");
        Departament depFizica = new Departament("DFIZ", "Departamentul de Fizica", 
            "Facultatea de Fizica", "Prof. Dr. Andrei Georgescu");
        
        service.adaugaDepartament(depInformatica);
        service.adaugaDepartament(depMatematica);
        service.adaugaDepartament(depFizica);
        
        System.out.println("\n 2. Adaugarea profesorilor...");
        
        // ===== ADAUGARE PROFESORI =====
        Profesor prof1 = new Profesor("Popescu", "Ion", "1234567890123", 
            "ion.popescu@univ.ro", depInformatica, "Prof. Dr.", 8500.0);
        Profesor prof2 = new Profesor("Ionescu", "Maria", "2345678901234", 
            "maria.ionescu@univ.ro", depMatematica, "Conf. Dr.", 7200.0);
        Profesor prof3 = new Profesor("Georgescu", "Andrei", "3456789012345", 
            "andrei.georgescu@univ.ro", depInformatica, "Lect. Dr.", 6500.0);
        Profesor prof4 = new Profesor("Vasilescu", "Elena", "4567890123456", 
            "elena.vasilescu@univ.ro", depFizica, "Prof. Dr.", 8800.0);
        
        service.adaugaProfesor(prof1);
        service.adaugaProfesor(prof2);
        service.adaugaProfesor(prof3);
        service.adaugaProfesor(prof4);
        
        System.out.println("\n 3. Adaugarea materiilor...");
        
        // ===== ADAUGARE MATERII =====
        Materie poo = new Materie("POO", "Programare Orientata pe Obiecte", 6, 2, "Examen");
        Materie algoritmica = new Materie("ALG", "Algoritmica Grafurilor", 5, 3, "Proiect");
        Materie analiza = new Materie("AM", "Analiza Matematica", 8, 1, "Examen");
        Materie algebra = new Materie("ALG_LIN", "Algebra Liniara", 6, 1, "Colocviu");
        Materie fizica1 = new Materie("FIZ1", "Fizica Generala I", 7, 1, "Examen");
        Materie bazeDeDDate = new Materie("BD", "Baze de Date", 5, 2, "Proiect");
        
        service.adaugaMaterie(poo);
        service.adaugaMaterie(algoritmica);
        service.adaugaMaterie(analiza);
        service.adaugaMaterie(algebra);
        service.adaugaMaterie(fizica1);
        service.adaugaMaterie(bazeDeDDate);
        
        // ===== ASIGNARE PROFESORI LA MATERII =====
        service.asigneazaProfesorLaMaterie("POO", prof1);
        service.asigneazaProfesorLaMaterie("ALG", prof3);
        service.asigneazaProfesorLaMaterie("AM", prof2);
        service.asigneazaProfesorLaMaterie("ALG_LIN", prof2);
        service.asigneazaProfesorLaMaterie("FIZ1", prof4);
        service.asigneazaProfesorLaMaterie("BD", prof1);
        
        System.out.println("\n 4. Adaugarea studentilor...");
        
        // ===== ADAUGARE STUDENTI =====
        Student stud1 = new Student("Andreescu", "Elena", "5678901234567", 
            "elena.andreescu@student.univ.ro", "2024001", 2, informatica);
        Student stud2 = new Student("Marinescu", "Bogdan", "6789012345678", 
            "bogdan.marinescu@student.univ.ro", "2024002", 1, informatica);
        Student stud3 = new Student("Constantinescu", "Ana", "7890123456789", 
            "ana.constantinescu@student.univ.ro", "2024003", 3, informatica);
        Student stud4 = new Student("Vasilescu", "Mihai", "8901234567890", 
            "mihai.vasilescu@student.univ.ro", "2024004", 1, matematica);
        Student stud5 = new Student("Popescu", "Diana", "9012345678901", 
            "diana.popescu@student.univ.ro", "2024005", 2, fizica);
        Student stud6 = new Student("Radu", "Alexandru", "0123456789012", 
            "alex.radu@student.univ.ro", "2024006", 1, informatica);
        
        // Setare burse
        stud1.setBursa(Constants.BURSA_MEDIE);
        stud3.setBursa(Constants.BURSA_MERIT);
        stud5.setBursa(Constants.BURSA_SOCIALA);
        
        service.adaugaStudent(stud1);
        service.adaugaStudent(stud2);
        service.adaugaStudent(stud3);
        service.adaugaStudent(stud4);
        service.adaugaStudent(stud5);
        service.adaugaStudent(stud6);
        
        System.out.println("\n 5. Adaugarea notelor...");
        
        // ===== ADAUGARE NOTE =====
        // Note pentru Elena (stud1)
        service.adaugaNota("2024001", "POO", 9.5, LocalDate.of(2024, 1, 15), "Examen");
        service.adaugaNota("2024001", "ALG", 8.7, LocalDate.of(2024, 1, 20), "Proiect");
        service.adaugaNota("2024001", "BD", 9.2, LocalDate.of(2024, 1, 25), "Proiect");
        
        // Note pentru Bogdan (stud2)
        service.adaugaNota("2024002", "AM", 7.2, LocalDate.of(2024, 1, 18), "Examen");
        service.adaugaNota("2024002", "ALG_LIN", 8.0, LocalDate.of(2024, 1, 22), "Colocviu");
        
        // Note pentru Ana (stud3)
        service.adaugaNota("2024003", "POO", 10.0, LocalDate.of(2024, 1, 15), "Examen");
        service.adaugaNota("2024003", "ALG", 9.8, LocalDate.of(2024, 1, 20), "Proiect");
        service.adaugaNota("2024003", "BD", 9.6, LocalDate.of(2024, 1, 25), "Proiect");
        
        // Note pentru Mihai (stud4)
        service.adaugaNota("2024004", "AM", 6.5, LocalDate.of(2024, 1, 18), "Examen");
        service.adaugaNota("2024004", "ALG_LIN", 7.8, LocalDate.of(2024, 1, 22), "Colocviu");
        
        // Note pentru Diana (stud5)
        service.adaugaNota("2024005", "FIZ1", 8.5, LocalDate.of(2024, 1, 20), "Examen");
        service.adaugaNota("2024005", "AM", 7.9, LocalDate.of(2024, 1, 18), "Examen");
        
        // Note pentru Alexandru (stud6)
        service.adaugaNota("2024006", "AM", 9.1, LocalDate.of(2024, 1, 18), "Examen");
        service.adaugaNota("2024006", "ALG_LIN", 8.8, LocalDate.of(2024, 1, 22), "Colocviu");
        
        System.out.println("\n Datele au fost incarcate cu succes!\n");
    }
    
    private static void demonstreazaFunctionalitati(CatalogService service) {
        System.out.println("============================================================");
        System.out.println(" DEMONSTRAREA FUNCTIONALITATILOR SISTEMULUI");
        System.out.println("============================================================");
        
        // ===== AFISARE LISTE COMPLETE =====
        service.afiseazaToatiStudentii();
        service.afiseazaToatiProfesorii();
        service.afiseazaToateMateriiile();
        
        // ===== CAUTARI SI FILTRARI =====
        System.out.println("\n===  CAUTARI SI FILTRARI ===");
        
        // Cautare student dupa nume
        Student studentCautat = service.cautaStudentDupaNumeComplet("Andreescu Elena");
        if (studentCautat != null) {
            System.out.println(" Student gasit: " + studentCautat);
            System.out.println(" Media studentului: " + 
                String.format("%.2f", service.calculeazaMedieStudent(studentCautat)));
        }
        
        // Profesori din departament
        System.out.println("\n Profesori din Departamentul de Informatica:");
        service.getProfesoriDupaDepartament("Departamentul de Informatica")
                .forEach(p -> System.out.println("   " + p));
        
        // Studenti inscrisi la POO
        System.out.println("\n Studenti inscrisi la POO:");
        service.getStudentiInscrisaLaMaterie("POO")
                .forEach(s -> System.out.println("   " + s.getNumeComplet()));
        
        // Studenti bursieri
        System.out.println("\n Studenti bursieri:");
        service.getStudentiBursieri()
                .forEach(s -> System.out.println("   " + s.getNumeComplet() + 
                    " - " + s.getBursa() + " RON"));
        
        // Materii predate de prof
        Profesor prof1 = service.getProfesori().first(); // Primul profesor sortat
        System.out.println("\n Materii predate de " + prof1.getNumeComplet() + ":");
        service.getMateriiProfesor(prof1)
                .forEach(m -> System.out.println("   " + m.getNume()));
        
        // Studenti din anul 1
        System.out.println("\n Studenti din anul 1:");
        service.getStudentiDupaAn(1)
                .forEach(s -> System.out.println("   " + s.getNumeComplet() + 
                    " (" + s.getSpecializare().getNume() + ")"));
        
        // ===== STATISTICI =====
        service.afiseazaStatisticiGenerale();
        
        // ===== CATALOGUL COMPLET =====
        service.afiseazaCatalog();
        
        // ===== DEMONSTRAREA COLECTIILOR =====
        System.out.println("\n===  DEMONSTRAREA COLECTIILOR UTILIZATE ===");
        System.out.println("1.  List<Student> studenti - pentru gestionarea studentilor");
        System.out.println("    Permite duplicate, mentine ordinea insertiei");
        System.out.println("    Total studenti: " + service.getStudenti().size());
        
        System.out.println("\n2.  TreeSet<Profesor> profesori - colectie sortata pentru profesori");
        System.out.println("    Sortare automata dupa nume (compareTo din Persoana)");
        System.out.println("    Nu permite duplicate");
        System.out.println("    Primul profesor alfabetic: " + service.getProfesori().first().getNumeComplet());
        System.out.println("    Ultimul profesor alfabetic: " + service.getProfesori().last().getNumeComplet());
        
        System.out.println("\n3.  HashMap<String, Materie> materii - mapare rapida cod->materie");
        System.out.println("    Acces O(1) pentru cautare dupa cod");
        System.out.println("    Codurile materiilor: " + service.getMaterii().keySet());
        
        System.out.println("\n4.  TreeMap<Student, List<Nota>> catalog - catalog sortat");
        System.out.println("    Sortare automata dupa studenti (compareTo din Persoana)");
        System.out.println("    Structura ierarhica pentru note");
        System.out.println("    Relatia many-to-many Student  Materie prin entitatea Nota");
        
        // ===== DEMONSTRAREA MOSTENIRII =====
        System.out.println("\n===  DEMONSTRAREA MOSTENIRII ===");
        System.out.println(" Clasa abstracta Persoana - baza pentru Student si Profesor");
        System.out.println(" Student extends Persoana - mosteneste toate atributele si metodele");
        System.out.println(" Profesor extends Persoana - mosteneste toate atributele si metodele");
        System.out.println(" Implementare Comparable<Persoana> pentru sortare automata");
        System.out.println(" Polimorfism: referinte de tip Persoana pot indica obiecte Student/Profesor");
        
        // Demonstratie polimorfism
        System.out.println("\n Demonstratie polimorfism:");
        service.getStudenti().stream().limit(2).forEach(student -> {
            Persoana p = student; // Polimorfism
            System.out.println("   " + p.getClass().getSimpleName() + ": " + p.getNumeComplet());
        });
    }
}