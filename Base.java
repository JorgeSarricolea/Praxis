/*  Se necesitan los siguientes métodos para la clase Inicio:
a) Leer, que devuelva un arreglo de objetos de la clase base, de manera explícita, y que tenga como argumento un valor entero,
b) Procesar, que devuelva un vector de 2 enteros de forma explícita y un vector de 2 flotantes de forma implícita, y
c) Desplegar, que no devuelva respuesta, y que tenga como argumentos 2 enteros y dos flotantes.

Elaborar la clase Base, cuyos atributos serán: matrícula, vector de N calificaciones, vector de N créditos, nombre del alumno, nombre de la carrera, fecha de posible egreso.

Realizar con un método cada inciso:
a) Lectura de los atributos de la clase, devolviendo un arreglo de objetos, utilizando scanner para ello;
b) Cálculo de la mayor calificación, el promedio de calificaciones, la cantidad de calificaciones aprobadas y la cantidad de calificaciones reprobadas;
c) Mostrar en pantalla los resultados del inciso b; d) Cantidad de alumnos de la carrera de “sistemas” o de “administración”;
e) Egresados, tipo vacío y argumento cadena;
f) Resultados, tipo vacío y 2 argumentos enteros. Esta clase no tendrá main.

Elaborar la clase Derivada, que heredará la clase Base y que tendrá como atributos los siguientes: Apellido del alumno, fecha de ingreso, semestre cursado. Esta clase no tendrá main.
Elabora la clase UsaDerivada, esta clase tendrá main y deberá llamar y desplegar los resultados obtenidos y completar lo que haga falta de las clases anteriores.
Las primeras tres clases deberán formar parte de un paquete llamado Herramientas, así como la clase scanner y ser usadas en la clase UsaDerivada. */

import java.util.Scanner;

public class Base {
    private String matricula;
    private String nombreAlumno;
    private String nombreCarrera;
    private String fechaEgreso;
    private double[] calificaciones;
    private int[] creditos;

    public Base() {
        calificaciones = new double[10];
        creditos = new int[10];
    }

    public Base(String matricula, String nombreAlumno, String nombreCarrera, String fechaEgreso,
            double[] calificaciones, int[] creditos) {
        this.matricula = matricula;
        this.nombreAlumno = nombreAlumno;
        this.nombreCarrera = nombreCarrera;
        this.fechaEgreso = fechaEgreso;
        this.calificaciones = calificaciones;
        this.creditos = creditos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public int[] getCreditos() {
        return creditos;
    }

    public void setCreditos(int[] creditos) {
        this.creditos = creditos;
    }

    // Lectura de los atributos de la clase, devolviendo un arreglo de objetos,
    // utilizando scanner para ello
    public static Base[] leer(int n) {
        Scanner scanner = new Scanner(System.in);
        Base[] arreglo = new Base[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la matrícula del alumno #" + (i + 1) + ": ");
            String matricula = scanner.nextLine();
            System.out.print("Ingrese el nombre del alumno #" + (i + 1) + ": ");
            String nombreAlumno = scanner.nextLine();
            System.out.print("Ingrese el nombre de la carrera del alumno #" + (i + 1) + ": ");
            String nombreCarrera = scanner.nextLine();
            System.out.print("Ingrese la fecha de posible egreso del alumno #" + (i + 1) + ": ");
            String fechaEgreso = scanner.nextLine();
            double[] calificaciones = new double[10];
            int[] creditos = new int[10];
            for (int j = 0; j < 10; j++) {
                System.out.print("Ingrese la calificación #" + (j + 1) + " del alumno #" + (i + 1) + ": ");
                calificaciones[j] = scanner.nextDouble();
                System.out.print("Ingrese los créditos de la materia #" + (j + 1) + " del alumno #" + (i + 1) + ": ");
                creditos[j] = scanner.nextInt();
                scanner.nextLine();
            }
            arreglo[i] = new Base(matricula, nombreAlumno, nombreCarrera, fechaEgreso, calificaciones, creditos);
        }
        return arreglo;
    }

    // Cálculo de la mayor calificación, el promedio de calificaciones, la cantidad
    // de calificaciones aprobadas y la cantidad de calificaciones reprobadas
    public double[] procesar() {
        double[] resultados = new double[4];
        double mayorCalificacion = 0;
        double promedioCalificaciones = 0;
        int aprobadas = 0;
        int reprobadas = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i] > mayorCalificacion) {
                mayorCalificacion = calificaciones[i];
            }
            promedioCalificaciones += calificaciones[i];
            if (calificaciones[i] >= 6) {
                aprobadas++;
            } else {
                reprobadas++;
            }
        }
        promedioCalificaciones /= calificaciones.length;
        resultados[0] = mayorCalificacion;
        resultados[1] = promedioCalificaciones;
        resultados[2] = aprobadas;
        resultados[3] = reprobadas;
        return resultados;
    }

    public void desplegar(int a, int b, float c, float d) {
        System.out.println("Mayor calificación: " + procesar()[0]);
        System.out.println("Promedio de calificaciones: " + procesar()[1]);
        System.out.println("Cantidad de calificaciones aprobadas: " + (int) procesar()[2]);
        System.out.println("Cantidad de calificaciones reprobadas: " + (int) procesar()[3]);
        System.out.println("Cantidad de alumnos de la carrera de sistemas o administración: " + a);
        System.out.println("Fecha de posible egreso: " + fechaEgreso);
        System.out.println("Resultado 1: " + a + " - " + b);
        System.out.println("Resultado 2: " + c + " - " + d);
    }

    // Cantidad de alumnos de la carrera de “sistemas” o de “administración”; e)
    // Egresados, tipo vacío y argumento cadena; f) Resultados, tipo vacío y 2
    // argumentos enteros
    public int cantidadAlumnos(String carrera) {
        int cantidad = 0;
        for (Base base : leer(2)) {
            if (base.nombreCarrera.equals(carrera)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void egresados(String nombreCarrera) {
        for (Base base : leer(2)) {
            if (base.nombreCarrera.equals(nombreCarrera)) {
                System.out.println(base.nombreAlumno + " egresará en " + base.fechaEgreso);
            }
        }
    }
}

// Elaborar la clase Derivada, que heredará la clase Base y que tendrá como
// atributos los siguientes: Apellido del alumno, fecha de ingreso, semestre
// cursado. Esta clase no tendrá main.
class Derivada extends Base {
    private String apellidoAlumno;
    private String fechaIngreso;
    private int semestreCursado;

    public Derivada(String matricula, String nombreAlumno, String nombreCarrera, String fechaEgreso,
            double[] calificaciones, int[] creditos, String apellidoAlumno, String fechaIngreso, int semestreCursado) {
        super(matricula, nombreAlumno, nombreCarrera, fechaEgreso, calificaciones, creditos);
        this.apellidoAlumno = apellidoAlumno;
        this.fechaIngreso = fechaIngreso;
        this.semestreCursado = semestreCursado;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getSemestreCursado() {
        return semestreCursado;
    }

    public void setSemestreCursado(int semestreCursado) {
        this.semestreCursado = semestreCursado;
    }
}

// Elabora la clase UsaDerivada, esta clase tendrá main y deberá llamar y
// desplegar los resultados obtenidos y completar lo que haga falta de las
// clases anteriores.
class UsaDerivada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Base[] arreglo = Base.leer(2);
        Base objeto1 = arreglo[0];
        Base objeto2 = arreglo[1];

        System.out.print("Ingrese el nombre de la carrera para obtener la cantidad de alumnos: ");
        String carrera = scanner.nextLine();
        int cantidadAlumnos = objeto1.cantidadAlumnos(carrera) + objeto2.cantidadAlumnos(carrera);
        System.out.println("Cantidad de alumnos de la carrera " + carrera + ": " + cantidadAlumnos);

        System.out.println("Egresados de la carrera Sistemas:");
        objeto1.egresados("Sistemas");
        objeto2.egresados("Sistemas");

        System.out.println("Egresados de la carrera Administración:");
        objeto1.egresados("Administración");
        objeto2.egresados("Administración");

        System.out.println("Desplegando resultados:");
        objeto1.desplegar(cantidadAlumnos, 7, 8.5f, 9.2f);
    }
}
