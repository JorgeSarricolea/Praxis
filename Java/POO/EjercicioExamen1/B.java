/* Elabora la clase B. que heredará y/o implementará la clase A, y que tendrá
como atributos cantidades (vector entero de 10 datos), nombre (vector de 10
cadenas), impuestos (vector flotante de 10 datos). Usando un método para cada
inciso: a) procesarcuatro, con un argumento entero. para realizar la lectura
de los atributos de la clase (DEBE DEVOLVERSE UN ARREGLO DE OBJETOS DE LA
CLASE explícitamente), b) procesarcinco, con un argumento arreglo de objetos
de la clase un vector de enteros, devolverá un flotante y determinará cuántos
artículos son “libretas” y el promedio de los precios, c) procesarseis, con
un argumento entero y uno flotante, para imprimir los resultados del inciso
a. Suponer N objetos de la clase. */

import java.util.Scanner;

public class B extends A {
    // Atributos
    private int[] cantidades;
    private String[] nombres;
    private float[] impuestos;

    // Constructor por defecto
    public B() {
        super();
        this.cantidades = new int[10];
        this.nombres = new String[10];
        this.impuestos = new float[10];
    }

    // Constructor con parámetros
    public B(int[] cantidades, int clave, float[] precios, String[] nombres, float[] impuestos) {
        super(clave, precios);
        this.cantidades = cantidades;
        this.nombres = nombres;
        this.impuestos = impuestos;
    }

    // Método para obtener el arreglo de nombres
    public String[] getNombres() {
        return this.nombres;
    }

    // Método para procesarcuatro
    public static B[] procesarcuatro(int n) {
        Scanner scanner = new Scanner(System.in);
        B[] objetos = new B[n];
        for (int i = 0; i < n; i++) {
            // Pedir la clave y los precios
            System.out.print("Introduzca la clave del objeto " + (i + 1) + ": ");
            int clave = scanner.nextInt();
            float[] precios = new float[7];
            for (int j = 0; j < precios.length; j++) {
                System.out.print("Introduzca el precio " + (j + 1) + " del objeto " + (i + 1) + ": ");
                precios[j] = scanner.nextFloat();
            }

            // Pedir las cantidades, nombres y los impuestos
            int[] cantidades = new int[10];
            String[] nombres = new String[10];
            float[] impuestos = new float[10];
            for (int j = 0; j < nombres.length; j++) {
                System.out.print("Introduzca las cantidades a solicitar del objeto " + (i + 1) + ": ");
                cantidades[j] = scanner.nextInt();
                System.out.print("Introduzca el nombre " + (j + 1) + " del objeto " + (i + 1) + ": ");
                nombres[j] = scanner.next();
                System.out.print("Introduzca el impuesto " + (j + 1) + " del objeto " + (i + 1) + ": ");
                impuestos[j] = scanner.nextFloat();
            }

            // Crear el objeto B con los datos ingresados
            objetos[i] = new B(cantidades, clave, precios, nombres, impuestos);
        }
        return objetos;
    }

    // Método para procesarcinco
    public static float procesarcinco(B[] objetos, int[] vectorEnteros) {
        int contadorLibretas = 0;
        float sumaPrecios = 0;

        // Determina cuántos artículos son "libreta"
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i].nombres[vectorEnteros[i]] == "libreta") {
                contadorLibretas++;
                // Promedio de los precios
                sumaPrecios += objetos[i].precios[vectorEnteros[i]];
            }
        }
        float promedio = contadorLibretas > 0 ? sumaPrecios / contadorLibretas : 0;
        return promedio;
    }

    // Método para procesarseis
    public static void procesarseis(int argumentoInt, float argumentoFloat) {
        B[] objetos = procesarcuatro(argumentoInt);
        for (int i = 0; i < objetos.length; i++) {
            System.out.println("Objeto " + (i + 1) + ": ");
            System.out.println(" - Clave: " + objetos[i].clave);
            System.out.println(" - Precios: ");
            for (int j = 0; j < objetos[i].precios.length; j++) {
                System.out.println("   * Precio " + (j + 1) + ": " + objetos[i].precios[j]);
            }
            System.out.println(" - Cantidades: ");
            for (int j = 0; j < objetos[i].cantidades.length; j++) {
                System.out.println("   * Cantidad " + (j + 1) + ": " + objetos[i].cantidades[j]);
            }
            System.out.println(" - Nombres: ");
            for (int j = 0; j < objetos[i].nombres.length; j++) {
                System.out.println("   * Nombre " + (j + 1) + ": " + objetos[i].nombres[j]);
            }
            System.out.println(" - Impuestos: ");
            for (int j = 0; j < objetos[i].impuestos.length; j++) {
                System.out.println("   * Impuesto " + (j + 1) + ": " + objetos[i].impuestos[j]);
            }
        }
    }
}

// Integrantes Equipo 9
// Martínez Echavarría, Bryan Eduardo
// Sarricolea Veyro, Jorge