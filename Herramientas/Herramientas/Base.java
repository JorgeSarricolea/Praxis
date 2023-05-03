package Herramientas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Elaborar la clase Base, cuyos atributos serán: matrícula, vector de N
scores, vector de N créditos, nombre del alumno, nombre de la carreer, fecha de posible
egreso. Realizar con un método cada inciso: a) Lectura de los atributos de la clase, devolviendo
un array de objetos, utilizando teclado para ello; b) Cálculo de la mayor calificación, el
promedio de scores, la cantidad de scores aprobadas y la cantidad de
scores reprobadas; c) Mostrar en pantalla los resultados del inciso b; d) Cantidad de
alumnos de la carreer de “sistemas” o de “administración”; e) Egresados, tipo vacío y
argumento cadena; f) Resultados, tipo vacío y 2 argumentos enteros. */

public class Base extends Inicio {
    private String tuition;
    private float[] scores;
    private int[] credits;
    private String studentName;

    // Geters and Setters
    public float[] getscores() {
        return scores;
    }

    public void setscores(float[] scores) {
        this.scores = scores;
    }

    private String carreerName;
    private Date egressDate;

    public String getcarreerName() {
        return carreerName;
    }

    public void setcarreerName(String carreerName) {
        this.carreerName = carreerName;
    }

    public int[] getcredits() {
        return credits;
    }

    public void setcredits(int[] credits) {
        this.credits = credits;
    }

    public Base() {
    }

    public Base(String tuition, float[] scores, int[] credits, String studentName, String carreerName,
            Date egressDate) {
        this.tuition = tuition;
        this.scores = scores;
        this.credits = credits;
        this.studentName = studentName;
        this.carreerName = carreerName;
        this.egressDate = egressDate;
    }

    // a) Lectura de los atributos de la clase, devolviendo un array de objetos,
    // utilizando teclado para ello;
    public static Base[] leer(int n) {
        Teclado kb = new Teclado();
        Base[] array = new Base[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");
            System.out.print("Matricula: ");
            String tuition = kb.leeString();
            System.out.print("Nombre del alumno: ");
            String studentName = kb.leeString();
            System.out.print("Nombre de la carrera: ");
            String carreerName = kb.leeString();

            // Tenemos que validar si la fecha de ingreso y egreso son alidas
            Date egressDate = null;
            boolean validDate;
            do {
                System.out.print("Fecha de egreso o posible egreso (dd/mm/yyyy): ");
                validDate = true;
                try {
                    egressDate = new SimpleDateFormat("dd/mm/yyyy").parse(kb.leeString());
                } catch (ParseException e) {
                    System.out.println(
                            "Error: La fecha ingresada no cumple con el formato dd/mm/yyyy. Por favor, intente de nuevo.");
                    validDate = false;
                }
            } while (!validDate);
            System.out.print("Ingrese la cantidad de materias a registrar: ");
            int subjectsNumber = kb.leeInt();
            float[] scores = new float[subjectsNumber];
            int[] credits = new int[subjectsNumber];
            for (int j = 0; j < subjectsNumber; j++) {
                System.out.println("Ingrese los datos de la materia " + (j + 1) + ":");
                System.out.print("Calificacion: ");
                scores[j] = kb.leeFloat();
                System.out.print("Creditos: ");
                credits[j] = kb.leeInt();
            }
            array[i] = new Base(tuition, scores, credits, studentName, carreerName, egressDate);
        }
        return array;
    }

    /*
     * b) Cálculo de la mayor calificación, el promedio de scores, la
     * cantidad de scores aprobadas y la cantidad de scores
     * reprobadas
     */
    public class Process {
        public float[] higherScoreAverage(Base[] array) {
            float higherScore = Float.MIN_VALUE;
            float sumScores = 0.0f;
            int passingScores = 0;
            int failingScores = 0;
            int subjectsNumber = array[0].scores.length;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < subjectsNumber; j++) {
                    if (array[i].scores[j] > higherScore) {
                        higherScore = array[i].scores[j];
                    }
                    sumScores += array[i].scores[j];
                    if (array[i].scores[j] >= 6.0f) {
                        passingScores++;
                    } else {
                        failingScores++;
                    }
                }
            }
            float averageScores = sumScores / (array.length * subjectsNumber);
            float[] results = { higherScore, averageScores, passingScores,
                    failingScores };
            return results;
        }
    }

    // El Override permite sobreescribir un método
    @Override
    public void desplegar(int passingScores, int failingScores,
            float higherScore, float averageScores) {
        System.out.println("La cantidad de materias aprobadas es: " + passingScores);
        System.out.println("La cantidad de materias reprobadas es : " + failingScores);
        System.out.println("La mayor calificacion es: " + higherScore);
        System.out.println("El promedio de las calificaciones es: " + averageScores);
    }

    // Geters and setters
    public String getstudentName() {
        return studentName;
    }

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getegressDate() {
        return egressDate;
    }

    public void setegressDate(Date egressDate) {
        this.egressDate = egressDate;
    }

    // d) Cantidad de alumnos de la carreer de “sistemas” o de “administración”
    public static int[] studentsByCarreer(Base[] array) {
        int sistemasCount = 0;
        int administracionCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getcarreerName().equalsIgnoreCase("sistemas")) {
                sistemasCount++;
            } else if (array[i].getcarreerName().equalsIgnoreCase("administracion")) {
                administracionCount++;
            }
        }

        int[] result = { sistemasCount, administracionCount };
        return result;
    }

    // e) Egresados, tipo vacío y argumento cadena
    public interface Egresados {
        void egresados(String carreer);

    }

    // f) Resultados, tipo vacío y 2 argumentos enteros
    public interface Resultados {
        void resultados(int uno, int dos);
    }
}