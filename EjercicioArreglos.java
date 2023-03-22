import java.util.Scanner;

public class EjercicioArreglos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("Ingrese el tamaño del arreglo: ");
        n = sc.nextInt();

        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el número #" + (i + 1) + ": ");
            arreglo[i] = sc.nextInt();
        }

        // Ordenar ascendentemente
        int[] ascendente = arreglo.clone();
        for (int i = 0; i < ascendente.length; i++) {
            for (int j = i + 1; j < ascendente.length; j++) {
                if (ascendente[j] < ascendente[i]) {
                    int temp = ascendente[i];
                    ascendente[i] = ascendente[j];
                    ascendente[j] = temp;
                }
            }
        }

        // Ordenar descendentemente
        int[] descendente = arreglo.clone();
        for (int i = 0; i < descendente.length; i++) {
            for (int j = i + 1; j < descendente.length; j++) {
                if (descendente[j] > descendente[i]) {
                    int temp = descendente[i];
                    descendente[i] = descendente[j];
                    descendente[j] = temp;
                }
            }
        }

        // Almacenar los números pares
        int[] pares = new int[n];
        int contadorPares = 0;
        for (int i = 0; i < n; i++) {
            if (arreglo[i] % 2 == 0) {
                pares[contadorPares] = arreglo[i];
                contadorPares++;
            }
        }

        // Almacenar los números impares
        int[] impares = new int[n];
        int contadorImpares = 0;
        for (int i = 0; i < n; i++) {
            if (arreglo[i] % 2 != 0) {
                impares[contadorImpares] = arreglo[i];
                contadorImpares++;
            }
        }

        // Desplegar resultados
        System.out.println("Números ingresados: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();

        System.out.println("Números ordenados ascendentemente: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ascendente[i] + " ");
        }
        System.out.println();

        System.out.println("Números ordenados descendentemente: ");
        for (int i = 0; i < n; i++) {
            System.out.print(descendente[i] + " ");
        }
        System.out.println();

        System.out.println("Números pares: ");
        for (int i = 0; i < contadorPares; i++) {
            System.out.print(pares[i] + " ");
        }
        System.out.println();

        System.out.println("Números impares: ");
        for (int i = 0; i < contadorImpares; i++) {
            System.out.print(impares[i] + " ");
        }
        System.out.println();
    }
}
