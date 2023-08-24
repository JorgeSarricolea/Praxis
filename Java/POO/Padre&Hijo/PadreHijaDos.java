// This is a little project in my POO Subject, it's contains the main class "PadreHijaDos" and the "Familia" package.

import Familia.*;
// Elabora la clase PadreHijaDos, que heredará la clase HijaUno, y deberá completar los métodosque hagan falta y proporcionar los resultados en pantalla

public class PadreHijaDos extends HijaUno {
    // Constructor
    public PadreHijaDos(int cardNumber, String name, int hours, int[] workedHours, float[] paymentByHour,
            int extraHours, float paymentByHourExtra, String departament, float bonds, float taxes) {
        super(cardNumber, name, hours, workedHours, paymentByHour, extraHours, paymentByHourExtra, departament,
                bonds, taxes);
    }

    public static void main(String[] args) {
        // Crear objeto de la clase kb
        Teclado kb = new Teclado();

        System.out.println("Captura la cantidad de empleados a procesar: ");
        int n = kb.leeInt();
        for (int j = 0; j < n; j++) {
            // Pedir los datos del primer empleado
            System.out.println("Datos del empleado: " + (j + 1));
            System.out.println("Numero de tarjeta: ");
            int cardNumber = kb.leeInt();
            System.out.println("Nombre: ");
            String name = kb.leeString();
            System.out.println("Horas: ");
            int hours = kb.leeInt();
            int[] workedHours = new int[5];
            float[] paymentByHour = new float[5];
            System.out.println("Horas trabajadas a la semana: ");
            for (int i = 0; i < 5; i++) {
                System.out.println("Dia " + (i + 1) + ": ");
                workedHours[i] = kb.leeInt();
                System.out.println("Pago por hora para el dia " + (i + 1) + ": ");
                paymentByHour[i] = kb.leeFloat();
            }
            System.out.println(" ");
            System.out.println("Horas extra trabajadas: ");
            int extraHours = kb.leeInt();
            System.out.println("Pago por horas extra: ");
            float paymentByHourExtra = kb.leeFloat();
            System.out.println("Departamento: ");
            String departament = kb.leeString();
            System.out.println("Bonos: ");
            float bonds = kb.leeFloat();
            System.out.println("Impuestos: ");
            float taxes = kb.leeFloat();
            System.out.println(" ");

            // Crear objeto de la clase HijaUno con los datos del primer empleado
            HijaUno employee1 = new HijaUno(cardNumber, name, hours, workedHours, paymentByHour, extraHours,
                    paymentByHourExtra, departament, bonds, taxes);

            // Mostrar los datos del primer empleado
            employee1.lectura(n);

            // Obtener y mostrar los resultados del primer empleado
            float[] finalVector = employee1.proceso(null);
            employee1.imprime(finalVector);
        }
    }
}