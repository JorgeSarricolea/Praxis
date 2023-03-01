/*
 * Se proporcionan los N nombres de alumnos de una Universidad, así como el
 * nombre de sus carreras, el semestre cursado y su promedio general hasta el
 * momento. Se desea:
 * a) Capturar los datos de cada alumno
 * b) Determinar cuános son de Sistemas, cuántos de Administración y cuántos de Civíl
 * c) Determinar el número de vocáles del nombre de cada alumno
 * d) Desplegar los resultados hallados
 */

import java.util.Scanner;

public class ex2 {

    static int n;
    static String[] nombres;
    static int[] carreras;
    static int[] semestres;
    static double[] promedios;

    public static void main(String[] args) {

        // Capturar los datos de cada alumno
        capturarDatos();

        // Determinar cuántos son de Sistemas, cuántos de Administración y cuántos de Civil
        int sistemas = contarAlumnosPorCarrera(1);
        int administracion = contarAlumnosPorCarrera(2);
        int civil = contarAlumnosPorCarrera(3);

        System.out.println("\n-------------------------------------\n");
        System.out.println("Número de alumnos por carrera:\n");
        System.out.println("Alumnos de Sistemas: " + sistemas);
        System.out.println("Alumnos de Administracion: " + administracion);
        System.out.println("Alumnos de Civil: " + civil);

        // Determinar el número de vocales del nombre de cada alumno
        int[] vocales = contarVocalesPorNombre();

        // Desplegar los resultados hallados
        System.out.println("\n-------------------------------------\n");
        System.out.println("Resultados:\n");
        for (int i = 0; i < n; i++) {
            System.out.println("Nombre: " + nombres[i]);

            if(carreras[i] == 1){
                System.out.println("Carrera: Sistemas");
            }
            if(carreras[i] == 2){
                System.out.println("Carrera: Administración");
            }
            if(carreras[i] == 3){
                System.out.println("Carrera: Civíl");
            }
            System.out.println("Semestre: " + semestres[i]);
            System.out.println("Promedio: " + promedios[i]);
            System.out.println("Vocales en el nombre: " + vocales[i]);
            System.out.println();
        }

    }

    public static void capturarDatos() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de alumnos a registrar: ");
        n = sc.nextInt();

        nombres = new String[n];
        carreras = new int[n];
        semestres = new int[n];
        promedios = new double[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nombre: ");
                nombres[i] = sc.next();
                if (nombres[i].matches("[a-zA-Z ]+")) {
                    break;
                }else{
                    System.out.println("¡ERROR!\nLa entrada no es una cadena válida. Intente nuevamente.");
                }
            } while (true);
            do{
                System.out.println("Selecciona una de las opciones escribiéndo el número:\n1. Sistemas\n2. Administración\n3. Civil");
                System.out.print("Carrera: ");
                carreras[i] = sc.nextInt();
                if(carreras[i] < 1 || carreras[i] > 3){
                    System.out.println("\n¡ERROR!");
                }
            }while(carreras[i] < 1 || carreras[i] > 3);
            do{
                System.out.print("Semestre: ");
                semestres[i] = sc.nextInt();
                if(semestres[i] < 1 || semestres[i] > 12){
                    System.out.println("\n¡ERROR!\nSemestre no válido.");
                }
            }while(semestres[i] < 1 || semestres[i] > 12);
            do{
                System.out.print("Promedio: ");
                promedios[i] = sc.nextDouble();
                if(promedios[i] < 0 || promedios[i] > 100){
                    System.out.println("\n¡ERROR!\nPromedio no válido.");
                }
            }while(promedios[i] < 0 || promedios[i] > 100);
        }
    }

    public static int contarAlumnosPorCarrera(int carrera) {
        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (carreras[i] == carrera) {
                contador++;
            }
        }
        return contador;
    }

    public static int[] contarVocalesPorNombre() {
        int[] vocales = new int[n];
        for (int i = 0; i < n; i++) {
            String nombre = nombres[i].toLowerCase();
            int contador = 0;
            for (int j = 0; j < nombre.length(); j++) {
                char letra = nombre.charAt(j);
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    contador++;
                }
            }
            vocales[i] = contador;
        }
        return vocales;
    }

}