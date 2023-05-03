// This is a little project in my POO Subject, it's contains the main class "UsaDerivada" and the "Herramientas" package

import Herramientas.Derivada;
import Herramientas.Base;
import Herramientas.Teclado;

public class UsaDerivada {
    public static void main(String[] args) {
        Derivada derivada = new Derivada();
        Teclado kb = new Teclado();

        // Leer la cantidad de alumnos a evaluar
        System.out.print("Ingrese la cantidad de alumnos a evaluar: ");
        int n = kb.leeInt();

        // Leer datos de los alumnos
        Base[] array = derivada.leer(n);

        // Leer datos adicionales (apellido, fecha de ingreso y semestre cursado) de
        // cada alumno
        Derivada[] extraStudents = new Derivada[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nIngrese los datos adicionales del alumno " + (i + 1) + ":");
            extraStudents[i] = new Derivada();
            extraStudents[i].leer();
        }

        // Procesar datos
        int[] studentsByCarreer = derivada.studentsByCarreer(array);
        Base.Process Process = derivada.new Process();
        float[] resultsProcess = Process.higherScoreAverage(array);

        // Egresados de una carreer específica (Tiene que ingresar el nombre de la
        // carrera para validar la informacion)
        System.out.print("\nIngrese la carrera para verificar egresados: ");
        String carreer = kb.leeString();
        derivada.egresados(carreer);

        // Imprimir datos de cada estudiante al finalizar
        System.out.println("\n______________________________");
        System.out.println("\nDatos de los estudiantes:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nAlumno " + (i + 1) + ":");
            System.out.println("Nombre: " + array[i].getstudentName());
            System.out.println("Apellido: " + extraStudents[i].getstudentLastName());
            System.out.println("Carrera: " + array[i].getcarreerName());
            System.out.println("Fecha de ingreso: " + extraStudents[i].getadmissionDate());
            System.out.println("Semestre cursado: " + extraStudents[i].getsemester());
            int countCredits = 0;
            float[] scores = array[i].getscores();
            int[] credits = array[i].getcredits();
            for (int j = 0; j < scores.length; j++) {
                countCredits += credits[j];
            }
            System.out.println("La suma de créditos totales es de " + countCredits);
        }
        // Desplegar resultados generales al final
        System.out.println("\nResultados generales:");
        derivada.desplegar(studentsByCarreer, resultsProcess);
    }
}