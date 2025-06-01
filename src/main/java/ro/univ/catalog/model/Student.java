package ro.univ.catalog.model;

/**
 * Clasa care reprezinta un student din sistem
 * Mosteneste din Persoana si adauga atribute specifice studentului
 */
public class Student extends Persoana {
    private String nrMatricol;
    private int anStudiu;
    private Specializare specializare;
    private double bursa;
    
    public Student(String nume, String prenume, String CNP, String email, 
                   String nrMatricol, int anStudiu, Specializare specializare) {
        super(nume, prenume, CNP, email);
        this.nrMatricol = nrMatricol;
        this.anStudiu = anStudiu;
        this.specializare = specializare;
        this.bursa = 0.0;
    }
    
    // Getters si Setters
    public String getNrMatricol() { 
        return nrMatricol; 
    }
    
    public void setNrMatricol(String nrMatricol) { 
        this.nrMatricol = nrMatricol; 
    }
    
    public int getAnStudiu() { 
        return anStudiu; 
    }
    
    public void setAnStudiu(int anStudiu) { 
        if (anStudiu >= 1 && anStudiu <= 6) {
            this.anStudiu = anStudiu; 
        }
    }
    
    public Specializare getSpecializare() { 
        return specializare; 
    }
    
    public void setSpecializare(Specializare specializare) { 
        this.specializare = specializare; 
    }
    
    public double getBursa() { 
        return bursa; 
    }
    
    public void setBursa(double bursa) { 
        if (bursa >= 0) {
            this.bursa = bursa; 
        }
    }
    
    public boolean areBursa() {
        return bursa > 0;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Student " + specializare.getNume() + 
               ", Anul " + anStudiu + " (Nr. " + nrMatricol + 
               (areBursa() ? ", Bursa: " + bursa + " RON" : "") + ")";
    }
}