import java.util.Scanner;

public class IncrementalRow {
   public static void main(String[] args) {

      // Pedir el número inicial
      Scanner scanner = new Scanner(System.in);
      System.out.print("Introduzca el número inicial: ");
      int numInicial = scanner.nextInt();

      // Crear la matriz de 4x4
      int[][] matriz = new int[4][4];

      // Rellenar la matriz con el incremento por fila
      for (int fila = 0; fila < matriz.length; fila++) {
         for (int columna = 0; columna < matriz[fila].length; columna++) {
            matriz[fila][columna] = numInicial++;
         }
      }

      // Imprimir la matriz
      for (int fila = 0; fila < matriz.length; fila++) {
         for (int columna = 0; columna < matriz[fila].length; columna++) {
            System.out.print(matriz[fila][columna] + "\t");
         }
         System.out.println();
      }
      scanner.close();
   }
}