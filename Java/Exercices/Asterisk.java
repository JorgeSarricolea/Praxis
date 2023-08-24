/* - Elabora una clase que generará un arreglo bidimensional, el cual contendrá asteriscos de la
siguiente forma: la primera fila tendrá un solo asterisco situado en la posición central, según la
segunda dimensión de la matriz. Cada nueva fila contendrá dos asteriscos más y también se
encontrarán centrados según la segunda dimensión. La última fila deberá estar llena de asteriscos. */

public class Asterisk {
    private int filas;
    private int columnas;

    public Asterisk(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public void imprimir() {
        char[][] matriz = generarMatriz();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char[][] generarMatriz() {
        char[][] matriz = new char[filas][columnas];
        int numAsteriscos = 1;
        int inicio = columnas / 2;
        for (int i = 0; i < filas; i++) {
            int posicion = inicio - numAsteriscos / 2;
            for (int j = 0; j < numAsteriscos; j++) {
                matriz[i][posicion] = '*';
                posicion++;
            }
            numAsteriscos += 2;
        }
        return matriz;
    }

    public static void main(String[] args) {
        Asterisk a = new Asterisk(10, 21);
        a.imprimir();
    }
}
