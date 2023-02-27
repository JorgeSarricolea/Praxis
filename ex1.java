import java.util.Scanner;

/*
 * Elaborar una clase llamada "práctica", que realice lo siguiente: debo
 * ingresar 5000 datos numéricos, determinar cuántos son positivos, cuántos son
 * negativos y cuántos son ceros. Así mismo, determinar el promedio de todos los
 * números. Debe usarse un método para cada cálculo y desplegar las respuestas
 * en otro método. Nota; En este caso, la lectura de los números se harán en el
 * main.
 */

 public class Practica {
    private int[] numeros;

    public Practica(int[] numeros) {
        this.numeros = numeros;
    }

    public int contarPositivos() {
        int contador = 0;
        for (int num : numeros) {
            if (num > 0) {
                contador++;
            }
        }
        return contador;
    }

    public int contarNegativos() {
        int contador = 0;
        for (int num : numeros) {
            if (num < 0) {
                contador++;
            }
        }
        return contador;
    }

    public int contarCeros() {
        int contador = 0;
        for (int num : numeros) {
            if (num == 0) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    public void mostrarResultados() {
        System.out.println("Cantidad de números positivos: " + contarPositivos());
        System.out.println("Cantidad de números negativos: " + contarNegativos());
        System.out.println("Cantidad de ceros: " + contarCeros());
        System.out.println("Promedio de todos los números: " + calcularPromedio());
    }

public static void main(String[] args) {
    int size = 5000;
    int[] numeros = new int[size];
    // Aquí debes llenar el arreglo con los datos que ingreses por teclado
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < numeros.length; i++) {
        System.out.print("Ingrese el número " + (i+1) + ": ");
        numeros[i] = sc.nextInt();
    }

    Practica practica = new Practica(numeros);
    practica.mostrarResultados();
    sc.close();
    }
}