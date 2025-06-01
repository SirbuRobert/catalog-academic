# 🎓 Sistem Catalog Academic

Aplicație Java pentru gestionarea unui catalog academic cu studenți, profesori și materii, dezvoltată folosind concepte avansate de Programare Orientată pe Obiecte.

## 📋 Funcționalități

### ✅ **Gestionarea Entităților**
- **Studenți**: Înregistrare, modificare și căutare studenți cu informații complete
- **Profesori**: Gestionarea cadrelor didactice cu grade și departamente
- **Materii**: Administrarea disciplinelor cu credite și tipuri de evaluare
- **Note**: Sistem complet de evaluare cu validări și statistici

### ✅ **Operații Avansate**
- Căutări și filtrări complexe (după nume, departament, an de studiu)
- Calcularea mediilor (pe student, pe materie, generală)
- Gestionarea burselor pentru studenți
- Rapoarte și statistici detaliate
- Sortări automate ale datelor

### ✅ **Relații Complexe**
- Relația Student ↔ Materie prin entitatea Nota (many-to-many)
- Asignarea profesorilor la materii
- Organizarea pe specializări și departamente

## 🚀 Cum să rulezi proiectul

### **Prerequisites**
- **Java 8** sau superior
- **Maven 3.6+**
- **VS Code** cu Extension Pack for Java (opțional, dar recomandat)

### **Instalare și rulare**

#### **1. Clone repository-ul:**
```bash
git clone https://github.com/username/catalog-academic.git
cd catalog-academic
```

#### **2. Compilare:**
```bash
mvn compile
```

#### **3. Rulare:**
```bash
mvn exec:java
```

#### **4. Creează JAR executabil:**
```bash
mvn package
java -jar target/catalog-academic-1.0.0.jar
```

### **Rulare în VS Code**
1. Deschide proiectul în VS Code
2. Right-click pe `Main.java` → "Run Java"
3. SAU apasă `F5` pentru debug mode

## 📁 Structura Proiectului

```
src/main/java/ro/univ/catalog/
├── Main.java                    # Clasa principală cu demonstrația
├── model/                       # Entitățile domeniului
│   ├── Persoana.java           # Clasa abstractă de bază
│   ├── Student.java            # Entitatea Student
│   ├── Profesor.java           # Entitatea Profesor
│   ├── Materie.java            # Entitatea Materie
│   ├── Nota.java               # Entitatea Nota (relația M:N)
│   ├── Specializare.java       # Entitatea Specializare
│   └── Departament.java        # Entitatea Departament
├── service/                     # Logica de business
│   └── CatalogService.java     # Serviciul principal
└── util/                        # Clase utilitare
    └── Constants.java          # Constante aplicației
```

## 🛠️ Tehnologii și Concepte Implementate

### **Tehnologii**
- **Java 8+** - limbajul de programare
- **Maven** - build tool și dependency management
- **Collections Framework** - pentru gestionarea eficientă a datelor

### **Concepte OOP**
- **Moștenire**: `Persoana` → `Student`, `Profesor`
- **Encapsulare**: Atribute private cu getters/setters
- **Polimorfism**: Utilizarea interfețelor și suprascrierea metodelor
- **Abstracție**: Clasa abstractă `Persoana` și interfața `Comparable`

### **Colecții Utilizate**
- **`List<Student>`** - pentru gestionarea secvențială a studenților
- **`TreeSet<Profesor>`** - colecție sortată automată pentru profesori
- **`HashMap<String, Materie>`** - mapare rapidă cod → materie (O(1))
- **`TreeMap<Student, List<Nota>>`** - catalog sortat cu structură ierarhică

### **Design Patterns**
- **Service Layer Pattern** - separarea logicii de business
- **Factory Pattern** - pentru crearea entităților
- **Repository Pattern** - pentru gestionarea datelor

## 📊 Cerințe Îndeplinite

### **✅ Definirea Sistemului**
- **12 acțiuni/operații** implementate:
  1. Adăugare student
  2. Adăugare profesor
  3. Adăugare materie
  4. Asignare profesor la materie
  5. Adăugare notă cu validări
  6. Căutare student după nume
  7. Căutare profesori după departament
  8. Afișare studenți înscriși la materie
  9. Calculare medie student
  10. Afișare materii predate de profesor
  11. Filtrare studenți după an de studiu
  12. Generare statistici complete

- **9 tipuri de obiecte** definite:
  1. `Persoana` (clasă abstractă)
  2. `Student` 
  3. `Profesor`
  4. `Materie`
  5. `Nota`
  6. `Specializare`
  7. `Departament`
  8. `CatalogService`
  9. `Constants`

### **✅ Implementarea**
- **Clase simple** cu atribute private/protected și metode de acces
- **4 colecții diferite** implementate și utilizate efectiv
- **2 colecții sortate** (TreeSet, TreeMap) cu sortare automată
- **Moștenire** implementată și demonstrată
- **Clasă serviciu** cu toate operațiile sistemului
- **Clasă Main** cu demonstrarea completă a funcționalităților

## 🎮 Demonstrația Aplicației

La rulare, aplicația demonstrează:

1. **Încărcarea datelor** - studenți, profesori, materii, note
2. **Operații CRUD** - create, read, update pentru toate entitățile  
3. **Căutări și filtrări** - exemple practice de utilizare
4. **Statistici** - medii, numărul de entități, studenți bursieri
5. **Sortări** - demonstrarea colecțiilor sortate
6. **Relații complexe** - navigarea dintre entități

### **Output Exemplu:**
```
=== SISTEM CATALOG ACADEMIC ===

Student adaugat: Andreescu Elena - Student Informatica, Anul 2
Profesor adaugat: Prof. Dr. Popescu Ion
Nota adaugata: Andreescu Elena - Programare Orientata pe Obiecte: 9.5

=== LISTA STUDENTILOR ===
Andreescu Elena | Medie: 9.13
Constantinescu Ana | Medie: 9.80

=== STATISTICI GENERALE ===
Total studenti: 6
Media generala: 8.47
```

## 🔧 Comenzi Maven Utile

```bash
# Compilare
mvn compile

# Rulare
mvn exec:java

# Testare (dacă ai teste)
mvn test

# Creare JAR
mvn package

# Curățare build
mvn clean

# Build complet
mvn clean compile package
```

## 📈 Funcționalități Avansate

### **Validări Implementate**
- Note între 1-10
- Ani de studiu între 1-6
- Burse >= 0
- Email format valid

### **Sortări Automate**
- Profesori sortați alfabetic (TreeSet)
- Studenți sortați în catalog (TreeMap)
- Implementare `Comparable<Persoana>`

### **Căutări Eficiente**
- HashMap pentru căutare rapidă materii după cod (O(1))
- Stream API pentru filtrări complexe
- Multiple criterii de căutare

## 🎯 Extensibilitate

Sistemul poate fi extins cu:
- Bază de date (JPA/Hibernate)
- Interfață grafică (JavaFX/Swing)
- API REST (Spring Boot)
- Autentificare și autorizare
- Export/import date (CSV, JSON)
- Sistem de notificări

## 🤝 Contribuții

Pentru contribuții la proiect:

1. Fork repository-ul
2. Creează un branch nou: `git checkout -b feature/nova-functionalitate`
3. Commit modificările: `git commit -m 'Adaugat functionalitate nova'`
4. Push pe branch: `git push origin feature/nova-functionalitate`
5. Deschide un Pull Request

## 📝 Licență

Acest proiect este dezvoltat în scop educațional pentru cursul de Programare Avansată pe Obiecte în Java.

## 👨‍💻 Autor

**Robert-Gabriel Sîrbu**
- Email: sirburobert9@mail.com
- GitHub: [@SirbuRobert](https://github.com/SirbuRobert)
- LinkedIn: [Robert Sirbu](https://linkedin.com/in/robert-sirbu-b3161b354/)

---

## 🏆 Realizări Tehnice

- ✅ **Zero erori de compilare**
- ✅ **100% cerințe îndeplinite**
- ✅ **Cod organizat și documentat**
- ✅ **Demonstrație completă funcțională**
- ✅ **Best practices Java**
- ✅ **Arhitectură extensibilă**

**Proiect dezvoltat cu ❤️ în Java**