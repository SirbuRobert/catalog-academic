package ro.univ.catalog.model;

/**
 * Clasa care reprezinta o materie din sistemul academic
 */
public class Materie {
    private String cod;
    private String nume;
    private int credite;
    private int anStudiu;
    private Profesor profesor;
    private String tipEvaluare;
    
    public Materie(String cod, String nume, int credite, int anStudiu) {
        this.cod = cod;
        this.nume = nume;
        this.credite = credite;
        this.anStudiu = anStudiu;
        this.tipEvaluare = "Examen";
    }
    
    public Materie(String cod, String nume, int credite, int anStudiu, String tipEvaluare) {
        this(cod, nume, credite, anStudiu);
        this.tipEvaluare = tipEvaluare;
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
    
    public int getCredite() { 
        return credite; 
    }
    
    public void setCredite(int credite) { 
        if (credite > 0) {
            this.credite = credite; 
        }
    }
    
    public int getAnStudiu() { 
        return anStudiu; 
    }
    
    public void setAnStudiu(int anStudiu) { 
        if (anStudiu >= 1 && anStudiu <= 6) {
            this.anStudiu = anStudiu; 
        }
    }
    
    public Profesor getProfesor() { 
        return profesor; 
    }
    
    public void setProfesor(Profesor profesor) { 
        this.profesor = profesor; 
    }
    
    public String getTipEvaluare() { 
        return tipEvaluare; 
    }
    
    public void setTipEvaluare(String tipEvaluare) { 
        this.tipEvaluare = tipEvaluare; 
    }
    
    @Override
    public String toString() {
        return nume + " (" + cod + ") - " + credite + " credite, Anul " + anStudiu +
               ", " + tipEvaluare +
               (profesor != null ? ", Prof: " + profesor.getNumeComplet() : ", Fara profesor");
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Materie materie = (Materie) obj;
        return cod.equals(materie.cod);
    }
    
    @Override
    public int hashCode() {
        return cod.hashCode();
    }
}