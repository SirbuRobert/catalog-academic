package ro.univ.catalog.model;

/**
 * Clasa abstracta de baza pentru toate persoanele din sistem
 * Implementeaza Comparable pentru sortarea automata
 * 
 * @author Numele Tau
 * @version 1.0
 */
public abstract class Persoana implements Comparable<Persoana> {
    protected String nume;
    protected String prenume;
    protected String CNP;
    protected String email;
    
    public Persoana(String nume, String prenume, String CNP, String email) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.email = email;
    }
    
    // Getters si Setters
    public String getNume() { 
        return nume; 
    }
    
    public void setNume(String nume) { 
        this.nume = nume; 
    }
    
    public String getPrenume() { 
        return prenume; 
    }
    
    public void setPrenume(String prenume) { 
        this.prenume = prenume; 
    }
    
    public String getCNP() { 
        return CNP; 
    }
    
    public void setCNP(String CNP) { 
        this.CNP = CNP; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public String getNumeComplet() {
        return nume + " " + prenume;
    }
    
    @Override
    public int compareTo(Persoana o) {
        return this.getNumeComplet().compareTo(o.getNumeComplet());
    }
    
    @Override
    public String toString() {
        return getNumeComplet() + " (" + email + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persoana persoana = (Persoana) obj;
        return CNP.equals(persoana.CNP);
    }
    
    @Override
    public int hashCode() {
        return CNP.hashCode();
    }
}