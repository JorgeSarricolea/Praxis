import java.util.*;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        do {
            System.out.print("Ingrese la cantidad de números a generar (mayor a 0): ");
            n = sc.nextInt();
            if (n <= 0){
                System.out.print("Valor no permitido\n");
            }
        } while (n <= 0);

        Set<Integer> numerosUnicos = new HashSet<>();
        int i = 0;
        while (i < n) {
            System.out.print("Ingrese un número entre 10 y 100 inclusive: ");
            int numero = sc.nextInt();
            if (numero >= 10 && numero <= 100 && !numerosUnicos.contains(numero)) {
                numerosUnicos.add(numero);
                i++;
            } else {
                System.out.println("El número no es válido o ya ha sido ingresado.");
            }
        }
        System.out.println("Los números únicos son: " + numerosUnicos);
        sc.close();
    }
}
