/* Declarar un arreglo de objetos String, cuyo contenido sean las cadenas: “Hola mundo”,
“Programación”, “Estudiantes” y “Flojos”. Realizar: a) ordenar ascendentemente cada cadena
considerando las mayúsculas y minúsculas, b) ordenar descendentemente cada cadena sin importar
mayúsculas y minúsculas, c) determinar cuál es la cadena más grande y cuál es la más pequeña, d)
imprimir los resultados. */

import java.util.Arrays;

public class stringObjects {
    public static void main(String[] args) {
        String[] cadenas = {"Hola mundo", "Programación", "Estudiantes", "Flojos"};

        // Ordenar ascendentemente cada cadena considerando mayúsculas y minúsculas
        Arrays.sort(cadenas);

        System.out.println("Cadenas ordenadas ascendentemente: " + Arrays.toString(cadenas));

        // Ordenar descendentemente cada cadena sin importar mayúsculas y minúsculas
        Arrays.sort(cadenas, (a, b) -> b.compareToIgnoreCase(a));

        System.out.println("Cadenas ordenadas descendentemente: " + Arrays.toString(cadenas));

        // Determinar la cadena más grande y la más pequeña
        String cadenaMasGrande = "", cadenaMasPequena = cadenas[0];
        for (String cadena : cadenas) {
            if (cadena.length() > cadenaMasGrande.length()) {
                cadenaMasGrande = cadena;
            }
            if (cadena.length() < cadenaMasPequena.length()) {
                cadenaMasPequena = cadena;
            }
        }

        System.out.println("Cadena más grande: " + cadenaMasGrande);
        System.out.println("Cadena más pequeña: " + cadenaMasPequena);
    }
}
