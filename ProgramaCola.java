import java.util.Scanner;

public class ProgramaCola {
    private int[] elementos;
    private int tamaño;
    private int inicio;
    private int fin;

    public ProgramaCola(int capacidad) {
        this.elementos = new int[capacidad];
        this.tamaño = 0;
        this.inicio = 0;
        this.fin = -1;
    }

    public void encolar(int elemento) {
        if (estaLlena()) {
            System.out.print("-------------------------------\n");
            System.out.println("La cola está llena, no se puede agregar ningún elemento.");
            return;
        }
        fin = (fin + 1) % elementos.length;
        elementos[fin] = elemento;
        tamaño++;
        System.out.print("-------------------------------\n");
        System.out.println("Se ha agregado el elemento " + elemento + " a la cola.");
    }

    public int desencolar() {
        if (estaVacia()) {
            System.out.print("-------------------------------\n");
            System.out.println("La cola está vacía, no se puede remover ningún elemento.");
            return -1;
        }
        int elementoRemovido = elementos[inicio];
        inicio = (inicio + 1) % elementos.length;
        tamaño--;
        System.out.print("-------------------------------\n");
        System.out.println("Se ha removido el elemento " + elementoRemovido + " de la cola.");
        return elementoRemovido;
    }

    public int obtenerPrimero() {
        if (estaVacia()) {
            System.out.print("-------------------------------\n");
            System.out.println("La cola está vacía, no se puede obtener ningún elemento.");
            return -1;
        }
        return elementos[inicio];
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == elementos.length;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.print("Estado actual de la cola: ");
        for (int i = 0; i < tamaño; i++) {
            int indice = (inicio + i) % elementos.length;
            System.out.print(elementos[indice] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPROGRAMA DE COLA SIMPLE");
        System.out.print("Ingrese la capacidad de la cola: ");
        int capacidad = sc.nextInt();
        ProgramaCola cola = new ProgramaCola(capacidad);
        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Encolar un elemento");
            System.out.println("2. Desencolar un elemento");
            System.out.println("3. Obtener el primer elemento");
            System.out.println("4. Mostrar estado actual de la cola");
            System.out.println("5. Salir del programa");
            System.out.print("\nSeleccione una opción: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("-------------------------------\n");
                    System.out.print("Ingrese el elemento a encolar: ");
                    int elemento = sc.nextInt();
                    cola.encolar(elemento);
                    break;
                case 2:
                    cola.desencolar();
                    break;
                case 3:
                    int primero = cola.obtenerPrimero();
                    System.out.print("-------------------------------\n");
                    System.out.println("El primer elemento es: " + primero);
                    break;
                case 4:
                    cola.mostrarCola();
                    break;
                case 5:
                    System.out.print("-------------------------------\n");
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;
                default:
                    System.out.print("-------------------------------\n");
                    System.out.println("Opción inválida, por favor seleccione una opción válida.");

            }
        }
    }
}