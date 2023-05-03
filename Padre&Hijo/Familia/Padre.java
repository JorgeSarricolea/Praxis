/* Definir una clase llamada Padre, cuyos atributos sean: número de tarjeta, name, hours
trabajadas a la semana(vector de 5 enteros), pago por hora por cada día(vector de 5 flotantes),
hours extra trabajadas y pago por hours extra. Realizar los incisos siguientes utilizando un
método para cada uno: a) Lectura, que devuelva un arreglo de objetos implícitamente y tenga
un argumento entero; b) Proceso, que devuelva un vector de 2 flotantes implícitamente, y un
vector de 2 flotantes explícitamente; c) Imprime, que deberá mostrar en pantalla los resultados
obtenidos en el inciso b. */

package Familia;

public abstract class Padre {

    // atributos sean: número de tarjeta, name, hours, hours trabajadas a la
    // semana(vector de 5 enteros), pago por hora por cada día(vector de 5
    // flotantes), hours extra trabajadas y pago por hours extra.
    protected int numeroTarjeta;
    protected String name;
    protected int hours;
    protected int[] workedHours = new int[5];
    protected float[] paymentByHour = new float[5];
    protected int extraHours;
    protected float paymentByHourExtra;

    // constructor
    public Padre(int numeroTarjeta, String name, int hours, int[] workedHours, float[] paymentByHour, int extraHours,
            float paymentByHourExtra) {
        this.numeroTarjeta = numeroTarjeta;
        this.name = name;
        this.hours = hours;
        this.workedHours = workedHours;
        this.paymentByHour = paymentByHour;
        this.extraHours = extraHours;
        this.paymentByHourExtra = paymentByHourExtra;
    }

    // a) Lectura, que devuelva un arreglo de objetos implícitamente y tenga un
    // argumento entero
    public abstract void lectura(int n);

    // b) Proceso, que devuelva un vector de 2 flotantes implícitamente, y unvector
    // de 2 flotantes explícitamente;
    public abstract float[] proceso(float[] vector);

    // ; c) Imprime, que deberá mostrar en pantalla los resultados obtenidos en el
    // inciso b
    public abstract void imprime(float[] vector);
}