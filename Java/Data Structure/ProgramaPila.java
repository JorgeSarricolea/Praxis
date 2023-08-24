import java.util.Scanner;

public class ProgramaPila {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pila pila = new Pila();

        boolean salir = false;
        while (!salir) {
            System.out.println("\nPROGRAMA DE PILA");
            System.out.println("1. Agregar un elemento");
            System.out.println("2. Eliminar un elemento");
            System.out.println("3. Ver el elemento del top de la pila");
            System.out.println("4. Ver el estado completo de la pila");
            System.out.println("5. Salir");
            System.out.print("\n¿Qué deseas hacer? ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el elemento que desea agregar: ");
                    int elemento = scanner.nextInt();
                    pila.push(elemento);
                    break;
                case 2:
                    int elementoQuitado = pila.pop();
                    if (elementoQuitado != -1) {
                        System.out.println("\nSe ha eliminado el elemento " + elementoQuitado + " de la pila.");
                    }
                    break;
                case 3:
                    int top = pila.peek();
                    if (top != -1) {
                        System.out.println("\nEl elemento del top de la pila es " + top);
                    }
                    break;
                case 4:
                    System.out.println("\nEstado completo de la pila:\n");
                    pila.mostrarEstadoCompleto();
                    break;
                case 5:
                    salir = true;
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nLa opción ingresada no es válida. Por favor intenta de nuevo.");
                    break;
            }
        scanner.close();
        }
    }
}

class Pila {
    private int capacidad;
    private int[] pila;
    private int tope;

    public Pila() {
        capacidad = 10;
        pila = new int[capacidad];
        tope = -1;
    }

    public void push(int elemento) {
        if (tope == capacidad - 1) {
            System.out.println("\nNo se puede agregar el elemento porque la pila está llena.");
        } else {
            tope++;
            pila[tope] = elemento;
            System.out.println("\nSe ha agregado el elemento " + elemento + " a la pila.");
        }
    }

    public int pop() {
        if (tope == -1) {
            System.out.println("\nNo se puede eliminar ningún elemento porque la pila está vacía.");
            return -1;
        } else {
            int elementoQuitado = pila[tope];
            tope--;
            return elementoQuitado;
        }
    }

    public int peek() {
        if (tope == -1) {
            System.out.println("\nNo se puede ver ningún elemento porque la pila está vacía.");
            return -1;
        } else {
            return pila[tope];
        }
    }

    public void mostrarEstadoCompleto() {
        if (tope == -1) {
            System.out.println("\nLa pila está vacía.");
        } else {
            for (int i = tope; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
    }
}