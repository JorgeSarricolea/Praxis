/* Elabora una clase A, cuyos atributos serán clave (como entero), precios
(vector flotante con 7 datos), que tendrá los siguientes métodos: a)
procesaruno, con un argumento entero, para realizar la lectura de los
atributos de la clase (DEBE DEVOLVERSE UN ARREGLO DE OBJETOS DE LA CLASE
explícitamente), b) procesardos, que tendrá como argumentos un arreglo de
objetos de la clase, y un vector de cadenas. y devolverá un booleano, c)
procesartres, que tendrá un argumento flotante y devolverá un nulo. */

import java.util.Scanner;

public class A {
    // Atributos
    protected int clave;
    protected float[] precios;

    // Constructor por defecto
    public A() {
        this.clave = 0;
        this.precios = new float[7];
    }

    // Constructor con parámetros
    public A(int clave, float[] precios) {
        this.clave = clave;
        this.precios = precios;
    }

    // Métodos para obtener y establecer la clave
    public int getClave() {
        return this.clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    // Métodos para obtener y establecer los precios
    public float[] getPrecios() {
        return this.precios;
    }

    public void setPrecios(float[] precios) {
        this.precios = precios;
    }

    // Método para procesaruno
    public static A[] procesaruno(int clave) {
        Scanner scanner = new Scanner(System.in);
        float[] precios = new float[7];
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Introduzca el precio " + (i + 1) + ": ");
            precios[i] = scanner.nextFloat();
        }
        return new A[] { new A(clave, precios) };
    }

    // Método para procesardos
    public static boolean procesardos(A[] objetos, String[] vectorCadenas) {
        // Aquí se implementa la lógica del método procesardos
        return true;
    }

    // Método para procesar tres
    public static void procesartres(float argumento) {
        // Aquí se implementa la lógica del método procesartres
    }
}

// Integrantes Equipo 9
// Martínez Echavarría, Bryan Eduardo
// Sarricolea Veyro, Jorge