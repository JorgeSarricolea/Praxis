/* Elabora una clase que genere un arreglo multidimensional, y que obtenga: a) la suma de la
diagonal principal, b) el promedio de los elementos que están arriba de la diagonal principal, c) el
promedio de los elementos que están abajo de la diagonal principal. */

import java.util.Random;

public class MutidimensionArray {

    private int[][] arreglo;
    private int filas;
    private int columnas;

    public MutidimensionArray(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        arreglo = new int[filas][columnas];
        llenarArreglo();
    }

    private void llenarArreglo() {
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                arreglo[i][j] = random.nextInt(10) + 1;
            }
        }
    }

    public void mostrarArreglo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(arreglo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumaDiagonalPrincipal() {
        int suma = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == j) {
                    suma += arreglo[i][j];
                }
            }
        }
        return suma;
    }

    public double promedioArribaDiagonal() {
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = i + 1; j < columnas; j++) {
                suma += arreglo[i][j];
                contador++;
            }
        }
        return suma / contador;
    }

    public double promedioAbajoDiagonal() {
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < i; j++) {
                suma += arreglo[i][j];
                contador++;
            }
        }
        return suma / contador;
    }

    public static void main(String[] args) {
        MutidimensionArray arreglo = new MutidimensionArray(5, 5);
        arreglo.mostrarArreglo();
        System.out.println("La suma de la diagonal principal es: " + arreglo.sumaDiagonalPrincipal());
        System.out.println("El promedio de los elementos arriba de la diagonal principal es: " + arreglo.promedioArribaDiagonal());
        System.out.println("El promedio de los elementos abajo de la diagonal principal es: " + arreglo.promedioAbajoDiagonal());
    }
}
