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

        ex3 primera=new ex3();
        ex3 segunda=new ex3(5,7);
        ex3 resultado=new ex3();
        
        System.out.print("Ingrese el numerador: ");
        primera.numerador = sc.nextInt();
        System.out.print("Ingrese el denominador: ");
        primera.denominador = sc.nextInt();
        resultado=segunda.SumarFraccion(primera, segunda);
        System.out.println("Resultado de la fracción: " + resultado.numerador + "/" + resultado.denominador);
    }
}