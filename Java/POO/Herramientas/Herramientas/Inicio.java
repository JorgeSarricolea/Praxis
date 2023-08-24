package Herramientas;

/* Se necesitan los siguientes métodos para la clase Inicio: a) Leer, que devuelva un arreglo de
objetos de la clase base, de manera explícita, y que tenga como argumento un valor entero, b)
Procesar, que devuelva un vector de 2 enteros de forma explícita y un vector de 2 flotantes de
forma implícita, y c) Desplegar, que no devuelva respuesta, y que tenga como argumentos 2
enteros y dos flotantes. */

public abstract class Inicio {
    public interface Leer {
        public Base[] leer(int n);
    }

    public abstract class Procesar {
        public abstract int[] passingFailing_scores();

        public abstract float[] average_higherScore();
    }

    public abstract void desplegar(int passingScores, int failingScores, float higherScore, float averageScores);
}