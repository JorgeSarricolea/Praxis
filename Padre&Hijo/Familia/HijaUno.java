/* Elabora una clase llamada HijaUno, que heredará la clase Padre, y
tendrá como atributos: departament, bonds, e taxes. Resolver los incisos siguientes cada
uno con un método: a) Lectura, que debe devolver un arreglo de objetos que considere los
atributos de la clase Padre; b) Proceso, que deberá determinar el pago neto como el producto de
los cinco pagos por hora y las hours trabajadas a la semana por el empleado, el average de
pago por hora en los cinco días trabajados, el mayor pago de los cinco días y el minor pago de
los cinco días; c) realPayment, que deberá realizar la suma de bonds al pago neto, y al resultado,
disminuirle los taxes; d) desplegar el resultado del inciso c. Esta clase no tendrá main. */

package Familia;

public class HijaUno extends Padre {
    // Tendrá como atributos: departament, bonds, e taxes
    private String departament;
    private float bonds;
    private float taxes;

    // Constructor
    public HijaUno(int cardNumber, String name, int hours, int[] workedHours, float[] paymentByHour, int extraHours,
            float paymentByHourExtra, String departament, float bonds, float taxes) {
        super(cardNumber, name, hours, workedHours, paymentByHour, extraHours, paymentByHourExtra);
        this.departament = departament;
        this.bonds = bonds;
        this.taxes = taxes;
    }

    // a) Lectura, que debe leer y devolver un arreglo de objetos que considere los
    // atributos de la clase Padre
    @Override
    public void lectura(int n) {
        System.out.println("Lectura de datos del empleado " + n);
        System.out.println("Numero de tarjeta: " + this.cardNumber);
        System.out.println("Nonbre: " + this.name);
        System.out.println("Hora: " + this.hours);
        System.out.println("Horas trabajadas a la semana: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Dia " + (i + 1) + ": " + this.workedHours[i]);
        }
        System.out.println("Pago por hora por cada dia: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Dia " + (i + 1) + ": " + this.paymentByHour[i]);
        }
        System.out.println("Horas extra trabajadas: " + this.extraHours);
        System.out.println("Pago por horas extra: " + this.paymentByHourExtra);
        System.out.println("Departamento: " + this.departament);
        System.out.println("Bonos: " + this.bonds);
        System.out.println("Impuestos: " + this.taxes);
    }

    // b) Proceso, que deberá determinar el pago neto como el producto de los cinco
    // pagos por hora y las hours trabajadas a la semana por el empleado, el
    // average de pago por hora en los cinco días trabajados, el mayor pago de los
    // cinco días y el minor pago de los cinco días;
    @Override
    public float[] proceso(float[] vector) {
        float[] finalVector = new float[4];
        float netPay = 0;
        float average = 0;
        float mayor = 0;
        float minor = 0;
        for (int i = 0; i < 5; i++) {
            netPay += this.workedHours[i] * this.paymentByHour[i];
            average += this.paymentByHour[i];
            if (this.paymentByHour[i] > mayor) {
                mayor = this.paymentByHour[i];
            }
            if (this.paymentByHour[i] < minor) {
                minor = this.paymentByHour[i];
            }
        }
        finalVector[0] = netPay;
        finalVector[1] = average / 5;
        finalVector[2] = mayor;
        finalVector[3] = minor;
        return finalVector;
    }

    // c) realPayment, que deberá realizar la suma de bonds al pago neto, y al
    // resultado,disminuirle los taxes;
    public float realPayment(float[] vector) {
        float realPayment = vector[0] + this.bonds - this.taxes;
        return realPayment;
    }

    // d) desplegar el resultado del inciso c.
    @Override
    public void imprime(float[] vector) {
        System.out.println("Pago neto: " + vector[0]);
        System.out.println("Promedio de pago por hora: " + vector[1]);
        System.out.println("Mayor pago de los cinco dias: " + vector[2]);
        System.out.println("Menor pago de los cinco dias: " + vector[3]);
        System.out.println("Pago real: " + this.realPayment(vector));
    }
}