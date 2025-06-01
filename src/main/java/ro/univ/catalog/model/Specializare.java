package ro.univ.catalog.model;

/**
 * Clasa care reprezinta o specializare din cadrul unei facultati
 */
public class Specializare {
    private String cod;
    private String nume;
    private String facultate;
    private int durata;
    private int locuri;
    
    public Specializare(String cod, String nume, String facultate, int durata) {
        this.cod = cod;
        this.nume = nume;
        this.facultate = facultate;
        this.durata = durata;
        this.locuri = 100; // default
    }
    
    public Specializare(String cod, String nume, String facultate, int durata, int locuri) {
        this(cod, nume, facultate, durata);
        this.locuri = locuri;
    }
    
    // Getters si Setters
    public String getCod() { 
        return cod; 
    }
    
    public void setCod(String cod) { 
        this.cod = cod; 
    }
    
    public String getNume() { 
        return nume; 
    }
    
    public void setNume(String nume) { 
        this.nume = nume; 
    }
    
    public String getFacultate() { 
        return facultate; 
    }
    
    public void setFacultate(String facultate) { 
        this.facultate = facultate; 
    }
    
    public int getDurata() { 
        return durata; 
    }
    
    public void setDurata(int durata) { 
        if (durata > 0) {
            this.durata = durata; 
        }
    }
    
    public int getLocuri() { 
        return locuri; 
    }
    
    public void setLocuri(int locuri) { 
        if (locuri > 0) {
            this.locuri = locuri; 
        }
    }
    
    @Override
    public String toString() {
        return nume + " (" + cod + ") - " + facultate + ", " + durata + 
               (durata == 1 ? " an" : " ani") + ", " + locuri + " locuri";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Specializare that = (Specializare) obj;
        return cod.equals(that.cod);
    }
    
    @Override
    public int hashCode() {
        return cod.hashCode();
    }
}