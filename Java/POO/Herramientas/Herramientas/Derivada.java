package Herramientas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Elaborar la clase Derivada, que heredará la clase Base y que tendrá como atributos los
siguientes: studentLastName del alumno, fecha de ingreso, semestre cursado. Esta clase no tendrá main. */

public class Derivada extends Base {

    private String studentLastName;
    private Date admissionDate;
    private int semester;

    public Derivada() {
    }

    // Getters and Setters
    public String getstudentLastName() {
        return studentLastName;
    }

    public void setstudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getsemester() {
        return semester;
    }

    public void setsemester(int semester) {
        this.semester = semester;
    }

    // Clase Derivada
    public Derivada(String matricula, float[] calificaciones, int[] creditos, String studentName,
            String carreerName, Date egressDate, String studentLastName, Date admissionDate,
            int semester) {
        super(matricula, calificaciones, creditos, studentName, carreerName, egressDate);
        this.studentLastName = studentLastName;
        this.admissionDate = admissionDate;
        this.semester = semester;
    }

    public void leer() {
        Teclado teclado = new Teclado();
        System.out.print("Apellido del alumno: ");
        this.studentLastName = teclado.leeString();

        boolean fechaValida;
        do {
            System.out.print("Fecha de ingreso (dd/mm/yyyy): ");
            try {
                this.admissionDate = new SimpleDateFormat("dd/mm/yyyy").parse(teclado.leeString());
                fechaValida = true;
            } catch (ParseException e) {
                System.out.println("¡ERROR! La fecha ingresada no cumple con el formato dd/mm/yyyy");
                fechaValida = false;
            }
        } while (!fechaValida);
        System.out.print("Semestre cursado: ");
        this.semester = teclado.leeInt();
    }

    public Date getadmissionDate() {
        return admissionDate;
    }

    public void setadmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public int[] process() {
        Base[] array = super.leer(1);
        return super.studentsByCarreer(array);
    }

    public void desplegar(int[] studentsByCarreer, float[] resultsProcess) {
        super.desplegar((int) resultsProcess[2], (int) resultsProcess[3],
                resultsProcess[0], resultsProcess[1]);
        System.out.println("La cantidad de alumnos de la carrera Sistemas es: " + studentsByCarreer[0]);
        System.out.println("La cantidad de alumnos de la carrera Administracion es: " + studentsByCarreer[1]);
    }

    public void egresados(String carrera) {
        Base[] array = super.leer(1);
        for (int i = 0; i < array.length; i++) {
            // Verify that the student is enrolled in a degree
            if (array[i].getcarreerName().equalsIgnoreCase(carrera)) {
                // Verify if the student is already graduated or not
                if (array[i].getegressDate().before(new Date())) {
                    System.out.println("\n El alumno ");
                    System.out.println(array[i].getstudentName() + " ha egresado.");
                } else {
                    System.out.println("\n El alumno ");
                    System.out.println(array[i].getstudentName() + " no ha egresado.");
                }
            }
        }
    }

    // Despliega los resultados
    public void resultados(int cantidadCalificacionesAprobadas, int cantidadCalificacionesReprobadas,
            float mayorCalificacion, float promedioCalificaciones, int cantidadAlumnosSistemas,
            int cantidadAlumnosAdministracion) {
        super.desplegar(cantidadCalificacionesAprobadas, cantidadCalificacionesReprobadas,
                mayorCalificacion, promedioCalificaciones);
        System.out.println("La cantidad de alumnos de sistemas es: " + cantidadAlumnosSistemas);
        System.out.println("La cantidad de alumnos de administración es: " + cantidadAlumnosAdministracion);
    }
}