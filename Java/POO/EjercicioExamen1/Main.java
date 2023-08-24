// Main para ejecutar los métodos de A y de B

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ejecuta los métodos de A
        System.out.println("Ejercicio 1");
        System.out.print("Introduzca la clave: ");
        int clave = scanner.nextInt();
        A[] objetosA = A.procesaruno(clave);
        String[] vectorCadenas = new String[10];
        boolean resultado = A.procesardos(objetosA, vectorCadenas);
        System.out.println("El resultado del procesamiento es: " + resultado);
        System.out.print("Introduzca el valor del argumento: ");
        float argumento = scanner.nextFloat();
        A.procesartres(argumento);

        // Ejecuta los métodos de B
        System.out.println("Ejercicio 2");
        System.out.print("Introduzca la cantidad de objetos: ");
        int n = scanner.nextInt();
        B[] objetosB = B.procesarcuatro(n);
        int[] vectorEnteros = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Introduzca el valor del entero " + (i + 1) + ": ");
            vectorEnteros[i] = scanner.nextInt();
        }
        float promedio = B.procesarcinco(objetosB, vectorEnteros);
        System.out.println("El promedio de precios de los artículos 'libreta' es: " + promedio);
        System.out.print("Introduzca el valor del primer argumento: ");
        int argumentoInt = scanner.nextInt();
        System.out.print("Introduzca el valor del segundo argumento: ");
        float argumentoFloat = scanner.nextFloat();
        B.procesarseis(argumentoInt, argumentoFloat);
    }
}

// Integrantes Equipo 9
// Martínez Echavarría, Bryan Eduardo
// Sarricolea Veyro, Jorge
