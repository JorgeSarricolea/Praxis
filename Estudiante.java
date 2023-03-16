import java.util.Scanner;

public class Estudiante {
    private String matricula;
    private String nombre;
    private int semestre;
    private String[] materias = new String[5];
    private int[][] calificaciones = new int[5][10];
    private String fechaIngreso;
    private int creditosCursados;
    private int creditosPorCursar;

    public Estudiante(String matricula, String nombre, int semestre, String[] materias,
                      int[][] calificaciones, String fechaIngreso, int creditosCursados, int creditosPorCursar) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.semestre = semestre;
        this.materias = materias;
        this.calificaciones = calificaciones;
        this.fechaIngreso = fechaIngreso;
        this.creditosCursados = creditosCursados;
        this.creditosPorCursar = creditosPorCursar;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String[] getMaterias() {
        return materias;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    public int[][] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(int[][] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getCreditosCursados() {
        return creditosCursados;
    }

    public void setCreditosCursados(int creditosCursados) {
        this.creditosCursados = creditosCursados;
    }

    public int getCreditosPorCursar() {
        return creditosPorCursar;
    }

    public void setCreditosPorCursar(int creditosPorCursar) {
        this.creditosPorCursar = creditosPorCursar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos los datos para un estudiante y creamos un objeto de la clase
        System.out.println("Ingrese la matrícula del estudiante:");
        String matricula = sc.nextLine();

        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el semestre del estudiante:");
        int semestre = sc.nextInt();
        sc.nextLine(); // consumimos el salto de línea

        String[] materias = new String[5];
        int[][] calificaciones = new int[5][10];

        for (int i = 0; i < materias.length; i++) {
            System.out.println("Ingrese el nombre de la materia " + (i+1) + ":");
            materias[i] = sc.nextLine();

            System.out.println("Ingrese las calificaciones de la materia " + materias[i] + ":");
            for (int j = 0; j < calificaciones[i].length; j++) {
            System.out.println("Unidad " + (j+1));
            calificaciones[i][j] = sc.nextInt();
            }
            sc.nextLine(); // consumimos el salto de línea
        }

        System.out.println("Ingrese la fecha de ingreso del estudiante:");
  String fechaIngreso = sc.nextLine();

  System.out.println("Ingrese la cantidad de créditos cursados por el estudiante:");
  int creditosCursados = sc.nextInt();

  System.out.println("Ingrese la cantidad de créditos por cursar del estudiante:");
  int creditosPorCursar = sc.nextInt();

  Estudiante estudiante = new Estudiante(matricula, nombre, semestre, materias, calificaciones, fechaIngreso, creditosCursados, creditosPorCursar);

  // Creamos un arreglo de objetos de la clase Estudiante
  Estudiante[] estudiantes = new Estudiante[3];

  // Pedimos los datos para cada estudiante y los agregamos al arreglo de objetos
  for (int i = 0; i < estudiantes.length; i++) {
      System.out.println("Ingrese los datos para el estudiante " + (i+1) + ":");

      System.out.println("Ingrese la matrícula del estudiante:");
      matricula = sc.nextLine();

      System.out.println("Ingrese el nombre del estudiante:");
      nombre = sc.nextLine();

      System.out.println("Ingrese el semestre del estudiante:");
      semestre = sc.nextInt();
      sc.nextLine(); // consumimos el salto de línea

      materias = new String[5];
      calificaciones = new int[5][10];

      for (int j = 0; j < materias.length; j++) {
          System.out.println("Ingrese el nombre de la materia " + (j+1) + ":");
          materias[j] = sc.nextLine();

          System.out.println("Ingrese las calificaciones de la materia " + materias[j] + ":");
          for (int k = 0; k < calificaciones[j].length; k++) {
              calificaciones[j][k] = sc.nextInt();
          }
          sc.nextLine(); // consumimos el salto de línea
      }

      System.out.println("Ingrese la fecha de ingreso del estudiante:");
      fechaIngreso = sc.nextLine();

      System.out.println("Ingrese la cantidad de créditos cursados por el estudiante:");
      creditosCursados = sc.nextInt();

      System.out.println("Ingrese la cantidad de créditos por cursar del estudiante:");
      creditosPorCursar = sc.nextInt();
      sc.nextLine(); // consumimos el salto de línea

      estudiantes[i] = new Estudiante(matricula, nombre, semestre, materias, calificaciones,fechaIngreso, creditosCursados, creditosPorCursar);}
    
      // Imprimimos los datos de los estudiantes
  for (int i = 0; i < estudiantes.length; i++) {
    System.out.println("Datos del estudiante " + (i+1) + ":");
    System.out.println("Matrícula: " + estudiantes[i].getMatricula());
    System.out.println("Nombre: " + estudiantes[i].getNombre());
    System.out.println("Semestre: " + estudiantes[i].getSemestre());
    System.out.println("Materias:");
    for (int j = 0; j < estudiantes[i].getMaterias().length; j++) {
        System.out.print("\t" + estudiantes[i].getMaterias()[j] + ": ");
        for (int k =  0; k < estudiantes[i].getCalificaciones()[j].length; k++) {
            System.out.print(estudiantes[i].getCalificaciones()[j][k] + " ");
        }
        System.out.println();
    }
    System.out.println("Fecha de ingreso: " + estudiantes[i].getFechaIngreso());
    System.out.println("Créditos cursados: " + estudiantes[i].getCreditosCursados());
    System.out.println("Créditos por cursar: " + estudiantes[i].getCreditosPorCursar());
    System.out.println();
}
}
    
}


