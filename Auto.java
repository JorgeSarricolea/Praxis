import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

// NOTA: El archivo solo va a solicitar un arreglo de objetos, se puede modificar en la línea 263

/* Elabora una clase llamada Auto, cuyos atributos son: tipo de auto(cadena),
    número de puertas(entero), número de cilindros(entero), modelo(cadena),
    tamaño(1-compacto, 2-mediano, 3-grande, 4-de lujo), precio(flotante),
    impuestos(flotante), y precio neto(flotante). */

public class Auto {
    private String tipo;
    private int numeroPuertas;
    private int numeroCilindros;
    private String modelo;
    private int tamaño;
    private float precio;
    private float impuestos;
    private float precioNeto;

    // Constructor
    public Auto(String tipo, int numeroPuertas, int numeroCilindros, String modelo, int tamaño, float precio) {
        this.tipo = tipo;
        this.numeroPuertas = numeroPuertas;
        this.numeroCilindros = numeroCilindros;
        this.modelo = modelo;
        this.tamaño = tamaño;
        this.precio = precio;
        calcularImpuestos();
        calcularPrecioNeto();
    }

    // Leer N objetos de la clase Auto y guardarlos en un arreglo
    public static Auto[] leerAutos(int N) {
        Auto[] autos = new Auto[N];
        Scanner scanner = new Scanner(System.in);

        /*
         * a) leer los N objetos de la clase con todos sus atributos, y guardarlos en un
         * arreglo de objetos que se devolverá explícitamente.
         */

        for (int i = 0; i < N; i++) {
            System.out.println("Ingrese los datos del auto " + (i + 1) + ":");
            // Validación para el tipo
            String tipo;
            while (true) {
                System.out.print("Tipo: ");
                tipo = scanner.nextLine();
                if (!tipo.isEmpty()) {
                    break; // Si el tipo no está vacío, es válido
                }
                System.out.println("Error: El tipo no puede estar vacío.");
            }
            // Validación del número de puertas
            int numeroPuertas;
            while (true) {
                try {
                    System.out.print("Número de puertas: ");
                    numeroPuertas = scanner.nextInt();
                    if (numeroPuertas <= 0) {
                        throw new IllegalArgumentException("El número de puertas debe ser mayor que cero.");
                    }
                    break; // Si no se produce una excepción, el número de puertas es válido
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número entero para el número de puertas.");
                    scanner.nextLine(); // Limpia el búfer del escáner
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            // Validación del número de cilíndros
            int numeroCilindros;
            while (true) {
                try {
                    System.out.print("Número de cilindros: ");
                    numeroCilindros = scanner.nextInt();
                    if (numeroCilindros <= 0) {
                        throw new IllegalArgumentException("El número de cilindros debe ser mayor que cero.");
                    }
                    break; // Si no se produce una excepción, el número de cilindros es válido
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número entero para el número de cilindros.");
                    scanner.nextLine(); // Limpia el búfer del escáner
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            // Validación del modelo
            String modelo;
            while (true) {
                try {
                    scanner.nextLine(); // Limpia el búfer del escáner
                    System.out.print("Modelo: ");
                    modelo = scanner.nextLine();
                    if (modelo.isEmpty()) {
                        throw new IllegalArgumentException("El modelo no puede estar vacío.");
                    }
                    break; // Si no se produce una excepción, el modelo es válido
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            // Validación del tamaño
            int tamaño;
            while (true) {
                try {
                    System.out.print("Tamaño (1-compacto, 2-mediano, 3-grande, 4-de lujo): ");
                    tamaño = scanner.nextInt();
                    if (tamaño < 1 || tamaño > 4) {
                        throw new IllegalArgumentException("El tamaño debe estar entre 1 y 4.");
                    }
                    break; // Si no se produce una excepción, el tamaño es válido
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número entero para el tamaño.");
                    scanner.nextLine(); // Limpia el búfer del escáner
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            // Validación del precio
            float precio;
            while (true) {
                try {
                    System.out.print("Precio: ");
                    precio = scanner.nextFloat();
                    if (precio <= 0) {
                        throw new IllegalArgumentException("El precio debe ser mayor que cero.");
                    }
                    break; // Si no se produce una excepción, el precio es válido
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número válido para el precio.");
                    scanner.nextLine(); // Limpia el búfer del escáner
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            scanner.nextLine(); // Limpiar el búfer después de leer flotantes

            autos[i] = new Auto(tipo, numeroPuertas, numeroCilindros, modelo, tamaño, precio);
            System.out.println("Auto " + (i + 1) + " agregado correctamente.");
            System.out.println();
        }
        scanner.close();
        return autos;
    }

    /*
     * Métodos para calcular impuestos y precio neto, los impuestos se calculan
     * automáticamente, no es necesario solicitarlo al usuario
     */
    private void calcularImpuestos() {
        if (tamaño == 1) {
            impuestos = precio * 0.05f;
        } else if (tamaño == 2) {
            impuestos = precio * 0.08f;
        } else if (tamaño == 3) {
            impuestos = precio * 0.1f;
        } else if (tamaño == 4) {
            impuestos = precio * 0.15f;
        } else {
            impuestos = 0;
        }
    }

    private void calcularPrecioNeto() {
        precioNeto = precio + impuestos;
    }

    // Getters y setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroCilindros() {
        return numeroCilindros;
    }

    public void setNumeroCilindros(int numeroCilindros) {
        this.numeroCilindros = numeroCilindros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
        calcularImpuestos();
        calcularPrecioNeto();
    }

    public float getImpuestos() {
        return impuestos;
    }

    public float getPrecioNeto() {
        return precioNeto;
    }

    /*
     * c) determinar el precio mayor, el precio menor, la cantidad de autos de cada
     * tamaño y el promedio de impuestos.
     */
    public static float getPrecioMayor(Auto[] autos) {
        float precioMayor = Float.MIN_VALUE;
        for (Auto auto : autos) {
            if (auto.getPrecio() > precioMayor) {
                precioMayor = auto.getPrecio();
            }
        }
        return precioMayor;
    }

    public static float getPrecioMenor(Auto[] autos) {
        float precioMenor = Float.MAX_VALUE;
        for (Auto auto : autos) {
            if (auto.getPrecio() < precioMenor) {
                precioMenor = auto.getPrecio();
            }
        }
        return precioMenor;
    }

    public static int getCantidadAutosPorTamaño(Auto[] autos, int tamaño) {
        int cantidad = 0;
        for (Auto auto : autos) {
            if (auto.getTamaño() == tamaño) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public static float getPromedioImpuestos(Auto[] autos) {
        float sumaImpuestos = 0;
        for (Auto auto : autos) {
            sumaImpuestos += auto.getImpuestos();
        }
        return sumaImpuestos / autos.length;
    }

    /*
     * b) generar un archivo binario llamado Agencia, que deberá almacenar todos
     * los datos del arreglo de objetos. Debe usarse un argumento RamdomAccessFile.
     */
    public static void generarArchivoBinario(Auto[] autos, String nombreArchivo) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw");

            // Escribir la cantidad de autos en el archivo
            archivo.writeInt(autos.length);

            // Escribir los datos de cada auto en el archivo
            for (Auto auto : autos) {
                // Escribir los atributos del auto en el archivo
                escribirCadena(archivo, auto.getTipo());
                archivo.writeInt(auto.getNumeroPuertas());
                archivo.writeInt(auto.getNumeroCilindros());
                escribirCadena(archivo, auto.getModelo());
                archivo.writeInt(auto.getTamaño());
                archivo.writeFloat(auto.getPrecio());
                archivo.writeFloat(auto.getImpuestos());
                archivo.writeFloat(auto.getPrecioNeto());
            }

            archivo.close();
            System.out.println("Archivo generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    private static void escribirCadena(RandomAccessFile archivo, String cadena) throws IOException {
        byte[] bytes = cadena.getBytes("UTF-8");
        archivo.writeInt(bytes.length);
        archivo.write(bytes);
    }

    /*
     * d) genera un archivo de texto llamado Cálculos, que contenga los resultados
     * del inciso c).
     */
    public static void generarArchivoCalculos(Auto[] autos, String nombreArchivo) {
        try {
            FileWriter archivo = new FileWriter(nombreArchivo);
            PrintWriter escritor = new PrintWriter(archivo);

            float precioMayor = getPrecioMayor(autos);
            float precioMenor = getPrecioMenor(autos);
            int cantidadCompactos = getCantidadAutosPorTamaño(autos, 1);
            int cantidadMedianos = getCantidadAutosPorTamaño(autos, 2);
            int cantidadGrandes = getCantidadAutosPorTamaño(autos, 3);
            int cantidadDeLujo = getCantidadAutosPorTamaño(autos, 4);
            float promedioImpuestos = getPromedioImpuestos(autos);

            escritor.println("Precio mayor: " + precioMayor);
            escritor.println("Precio menor: " + precioMenor);
            escritor.println("Cantidad de autos compactos: " + cantidadCompactos);
            escritor.println("Cantidad de autos medianos: " + cantidadMedianos);
            escritor.println("Cantidad de autos grandes: " + cantidadGrandes);
            escritor.println("Cantidad de autos de lujo: " + cantidadDeLujo);
            escritor.println("Promedio de impuestos: " + promedioImpuestos);

            escritor.close();
            System.out.println("Archivo de cálculos generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo de cálculos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Auto[] autos = Auto.leerAutos(1);

        // Generar archivo binario
        generarArchivoBinario(autos, "Agencia.bin");

        // Generar archivo de cálculos
        generarArchivoCalculos(autos, "Cálculos.txt");
    }
}