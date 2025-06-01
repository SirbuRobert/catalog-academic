package ro.univ.catalog.util;

/**
 * Constante utilizate in aplicatie
 */
public class Constants {
    // Constante pentru note
    public static final double MIN_NOTA = 1.0;
    public static final double MAX_NOTA = 10.0;
    public static final double NOTA_TRECERE = 5.0;
    
    // Tipuri de evaluare
    public static final String[] TIPURI_EVALUARE = {
        "Examen", "Colocviu", "Test", "Proiect", "Referat", "Laborator", "Seminar"
    };
    
    // Grade didactice
    public static final String[] GRADE_DIDACTICE = {
        "Asist.", "Lect. Dr.", "Conf. Dr.", "Prof. Dr."
    };
    
    // Ani de studiu
    public static final int MIN_AN_STUDIU = 1;
    public static final int MAX_AN_STUDIU = 6;
    
    // Burse
    public static final double BURSA_MINIMA = 0.0;
    public static final double BURSA_MEDIE = 850.0;
    public static final double BURSA_MERIT = 1200.0;
    public static final double BURSA_SOCIALA = 650.0;
    
    // Mesaje
    public static final String MSG_STUDENT_ADAUGAT = " Student adaugat cu succes!";
    public static final String MSG_PROFESOR_ADAUGAT = " Profesor adaugat cu succes!";
    public static final String MSG_MATERIE_ADAUGATA = " Materie adaugata cu succes!";
    public static final String MSG_NOTA_ADAUGATA = " Nota adaugata cu succes!";
    
    public static final String MSG_ERROR_STUDENT_NULL = " Studentul nu poate fi null!";
    public static final String MSG_ERROR_NOTA_INVALIDA = " Nota trebuie sa fie intre 1 si 10!";
    public static final String MSG_ERROR_AN_INVALID = " Anul de studiu trebuie sa fie intre 1 si 6!";
    
    // Constructor privat pentru a preveni instantierea
    private Constants() {
        throw new UnsupportedOperationException("Clasa Constants nu poate fi instantiata!");
    }
    
    /**
     * Verifica daca nota este valida
     */
    public static boolean isNotaValida(double nota) {
        return nota >= MIN_NOTA && nota <= MAX_NOTA;
    }
    
    /**
     * Verifica daca nota este de trecere
     */
    public static boolean isNotaDeTrecere(double nota) {
        return nota >= NOTA_TRECERE;
    }
    
    /**
     * Verifica daca anul de studiu este valid
     */
    public static boolean isAnStudiuValid(int an) {
        return an >= MIN_AN_STUDIU && an <= MAX_AN_STUDIU;
    }
}
