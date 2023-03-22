/* Se proporcionan N nombres que se encuentran cada uno en un arreglo de objetos String. Se
desea: a) imprimir el nombre en mayúsculas, b) imprimir el nombre en minúsculas, c) cambiar las
vocales de cada nombre por “X”, d) cambiar los espacios en blanco por “+”, e) imprimir cada una de
las respuestas halladas. */

import java.util.Arrays;

public class namesVocalsX {

    public static void main(String[] args) {

        // Vector predefinido con nombres 
        String[] nombres = {"Juan Carlos", "Ana Gabriela", "Jorge", "María", "Pedro"};

        // Imprimir vector de nombres 
        System.out.println("Nombres ingresados:\n");
        Arrays.stream(nombres)
            .forEach(System.out::println);
        System.out.println();

        // Imprimir nombres en mayúsculas
        System.out.println("Nombres en mayúsculas:\n");
        Arrays.stream(nombres)
              .map(String::toUpperCase)
              .forEach(System.out::println);
        System.out.println();

        // Imprimir nombres en minúsculas
        System.out.println("Nombres en minúsculas:\n");
        Arrays.stream(nombres)
              .map(String::toLowerCase)
              .forEach(System.out::println);
        System.out.println();

        // Cambiar vocales por "X"
        System.out.println("Nombres con vocales cambiadas por \"X\":\n");
        Arrays.stream(nombres)
              .map(nombre -> nombre.replaceAll("[aeiouAEIOU]", "X"))
              .forEach(System.out::println);
        System.out.println();

        // Cambiar espacios por "+"
        System.out.println("Nombres con espacios cambiados por \"+\":\n");
        Arrays.stream(nombres)
              .map(nombre -> nombre.replaceAll("\\s", "+"))
              .forEach(System.out::println);
        System.out.println();

    }
}
