import java.util.Scanner;

public class ex3 {
    
    int numerador, denominador; 
    public ex3(){

    }
    public ex3(int numerador, int denominador){

        this.numerador=numerador;
        this.denominador=denominador;
    }
    public ex3 SumarFraccion (ex3 uno, ex3 dos){

        ex3 suma=new ex3();
        suma.numerador=(uno.numerador*dos.denominador)+(dos.numerador*uno.denominador);
        suma.denominador=(uno.denominador*dos.denominador);
        return(suma);
    }

    public static void main(String[] xx) {

        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Ingrese la cantidad de fracciones: ");
            int n = sc.nextInt();
            if (n > 0) {

            ex3[] fracciones = new ex3[n]; // arreglo para almacenar las fracciones

            // solicitar los valores de cada fracción
            for (int i = 0; i < n; i++) {
                System.out.println("\n-------------------------------------\n");
                System.out.println("Ingrese los valores de la fracción " + (i+1) + ":");
                System.out.print("Numerador: ");
                int numerador = sc.nextInt();
                System.out.print("Denominador: ");
                int denominador = sc.nextInt();
                
                fracciones[i] = new ex3(numerador, denominador); // crear objeto fracción y almacenarlo en el arreglo
            }
            
            // sumar las fracciones
            ex3 resultado = fracciones[0];
            for (int i = 1; i < n; i++) {
                resultado = resultado.SumarFraccion(fracciones[i], resultado);
            }
            // mostrar el resultado
            System.out.println("\n-------------------------------------\n");
            System.out.println("El resultado es:\n");
            System.out.print(resultado.numerador); 
            System.out.print("\n--\n");
            System.out.print( resultado.denominador + "\n");

            
            }else{
                System.out.println("¡ERROR!\nNo se permiten números negativos o '0' para esta solicitud.");
            }

            break;
        }while(true);
    }
}
