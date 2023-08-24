import java.util.Scanner;

public class EXU2EQ92SA {
    private int matricula;
    private String nombre;
    private String carrera;
    private String materia;
    private int[] calificaciones;

    // Constructor con this
    public EXU2EQ92SA(int matricula, String nombre, String carrera, String materia, int[] calificaciones) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.materia = materia;
        this.calificaciones = calificaciones;
    }

    // Método para leer los atributos de la clase
    public static EXU2EQ92SA[] leerAlumnos() {
        Scanner scanner = new Scanner(System.in);
        int n = 2;
        EXU2EQ92SA[] alumnos = new EXU2EQ92SA[n];

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Alumno #" + (i + 1));
            System.out.print("Matrícula: ");
            int matricula = scanner.nextInt();
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Carrera: ");
            String carrera = scanner.next();
            System.out.print("Materia: ");
            String materia = scanner.next();
            int[] calificaciones = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Calificación #" + (j + 1) + ": ");
                calificaciones[j] = scanner.nextInt();
            }
            alumnos[i] = new EXU2EQ92SA(matricula, nombre, carrera, materia, calificaciones);
        }
        scanner.close();
        return alumnos;
    }

    // Método para determinar el promedio, la mayor y la menor calificación de cada alumno
    public void calcularResultados() {
        int suma = 0;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i];
            if (calificaciones[i] > mayor) {
                mayor = calificaciones[i];
            }
            if (calificaciones[i] < menor) {
                menor = calificaciones[i];
            }
        }
        double promedio = (double) suma / calificaciones.length;
        System.out.println();
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Carrera: " + carrera);
        System.out.println("Materia: " + materia);
        System.out.println("Promedio: " + promedio);
        System.out.println("Mayor calificación: " + mayor);
        System.out.println("Menor calificación: " + menor);
        System.out.println();
    }

    public static void main(String[] args) {
        EXU2EQ92SA[] alumnos = EXU2EQ92SA.leerAlumnos();
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i].calcularResultados();
        }
    }
}

/*
    Equipo 9
    Martinez Echavarría, Bryan Eduardo
    Sarricolea Veyro, Jorge
 */