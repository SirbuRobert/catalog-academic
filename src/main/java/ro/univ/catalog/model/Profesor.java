package ro.univ.catalog.model;

/**
 * Clasa care reprezinta un profesor din sistem
 * Mosteneste din Persoana si adauga atribute specifice profesorului
 */
public class Profesor extends Persoana {
    private Departament departament;
    private String grad;
    private double salariu;
    
    public Profesor(String nume, String prenume, String CNP, String email, 
                    Departament departament, String grad, double salariu) {
        super(nume, prenume, CNP, email);
        this.departament = departament;
        this.grad = grad;
        this.salariu = salariu;
    }
    
    // Getters si Setters
    public Departament getDepartament() { 
        return departament; 
    }
    
    public void setDepartament(Departament departament) { 
        this.departament = departament; 
    }
    
    public String getGrad() { 
        return grad; 
    }
    
    public void setGrad(String grad) { 
        this.grad = grad; 
    }
    
    public double getSalariu() { 
        return salariu; 
    }
    
    public void setSalariu(double salariu) { 
        if (salariu > 0) {
            this.salariu = salariu; 
        }
    }
    
    @Override
    public String toString() {
        return grad + " " + super.toString() + " - " + departament.getNume();
    }
}