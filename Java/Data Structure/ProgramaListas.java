import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFront(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addRear(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFront() {
        if (isEmpty()) {
            System.out.print("-------------------------------\n");
            System.out.println("La lista está vacía");
        } else {
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
        }
    }

    public void removeRear() {
        if (isEmpty()) {
            System.out.print("-------------------------------\n");
            System.out.println("La lista está vacía");
        } else {
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("-------------------------------\n");
            System.out.println("La lista está vacía");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class ProgramaListas {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Añadir elemento al frente");
            System.out.println("2. Añadir elemento al final");
            System.out.println("3. Remover elemento del frente");
            System.out.println("4. Remover elemento del final");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("-------------------------------\n");
                    System.out.print("Ingrese el elemento a añadir al frente: ");
                    int data1 = sc.nextInt();
                    list.addFront(data1);
                    break;
                case 2:
                    System.out.print("-------------------------------\n");
                    System.out.print("Ingrese el elemento a añadir al final: ");
                    int data2 = sc.nextInt();
                    list.addRear(data2);
                    break;
                case 3:
                    list.removeFront();
                    break;
                case 4:
                    list.removeRear();
                    break;
                case 5:
                    System.out.print("-------------------------------\n");
                    System.out.print("Estado actual de la lista: ");
                    list.display();
                    break;
                case 6:
                    System.out.print("-------------------------------\n");
                    System.out.println("Saliendo...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.print("-------------------------------\n");
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}