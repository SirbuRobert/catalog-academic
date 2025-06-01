package ro.univ.catalog.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clasa care reprezinta o nota obtinuta de un student la o materie
 * Implementeaza relatia many-to-many dintre Student si Materie
 */
public class Nota {
    private Student student;
    private Materie materie;
    private double valoare;
    private LocalDate dataExamen;
    private String tipEvaluare;
    private String observatii;
    
    public Nota(Student student, Materie materie, double valoare, LocalDate dataExamen, String tipEvaluare) {
        this.student = student;
        this.materie = materie;
        setValoare(valoare);
        this.dataExamen = dataExamen;
        this.tipEvaluare = tipEvaluare;
        this.observatii = "";
    }
    
    public Nota(Student student, Materie materie, double valoare, String tipEvaluare) {
        this(student, materie, valoare, LocalDate.now(), tipEvaluare);
    }
    
    // Getters si Setters
    public Student getStudent() { 
        return student; 
    }
    
    public void setStudent(Student student) { 
        this.student = student; 
    }
    
    public Materie getMaterie() { 
        return materie; 
    }
    
    public void setMaterie(Materie materie) { 
        this.materie = materie; 
    }
    
    public double getValoare() { 
        return valoare; 
    }
    
    public void setValoare(double valoare) {
        if (valoare >= 1.0 && valoare <= 10.0) {
            this.valoare = valoare;
        } else {
            throw new IllegalArgumentException("Nota trebuie sa fie intre 1 si 10!");
        }
    }
    
    public LocalDate getDataExamen() { 
        return dataExamen; 
    }
    
    public void setDataExamen(LocalDate dataExamen) { 
        this.dataExamen = dataExamen; 
    }
    
    public String getTipEvaluare() { 
        return tipEvaluare; 
    }
    
    public void setTipEvaluare(String tipEvaluare) { 
        this.tipEvaluare = tipEvaluare; 
    }
    
    public String getObservatii() { 
        return observatii; 
    }
    
    public void setObservatii(String observatii) { 
        this.observatii = observatii; 
    }
    
    public boolean estePromovata() {
        return valoare >= 5.0;
    }
    
    public String getDataFormatata() {
        return dataExamen.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
    @Override
    public String toString() {
        return student.getNumeComplet() + " - " + materie.getNume() + 
               ": " + valoare + " (" + tipEvaluare + ", " + getDataFormatata() + ")" +
               (estePromovata() ? " " : " ");
    }
}