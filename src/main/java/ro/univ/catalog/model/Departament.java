package ro.univ.catalog.model;

/**
 * Clasa care reprezinta un departament dintr-o facultate
 */
public class Departament {
    private String cod;
    private String nume;
    private String facultate;
    private String sef;
    
    public Departament(String cod, String nume, String facultate) {
        this.cod = cod;
        this.nume = nume;
        this.facultate = facultate;
        this.sef = "";
    }
    
    public Departament(String cod, String nume, String facultate, String sef) {
        this(cod, nume, facultate);
        this.sef = sef;
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
    
    public String getSef() { 
        return sef; 
    }
    
    public void setSef(String sef) { 
        this.sef = sef; 
    }
    
    @Override
    public String toString() {
        return nume + " (" + cod + ") - " + facultate +
               (sef.isEmpty() ? "" : ", Sef: " + sef);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Departament that = (Departament) obj;
        return cod.equals(that.cod);
    }
    
    @Override
    public int hashCode() {
        return cod.hashCode();
    }
}