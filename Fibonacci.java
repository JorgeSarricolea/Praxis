/* La serie de Fibonacci empieza con los términos 0 y 1, y tiene la propiedad de que cada término
sucesivo es la suma de los dos términos anteriores (Ej. 0,1,1,2,3,5,8,13,…. ). Calcular: a) el enésimo
término, introduciendo el valor de n para calcularlo, b) cuál es el número más grande que se puede
calcular. */

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el valor de n para calcular el enésimo término: ");
        int n = scanner.nextInt();

        int a = 0, b = 1, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        System.out.println("El enésimo término de la serie de Fibonacci es: " + c);
        scanner.close();
    }
}

