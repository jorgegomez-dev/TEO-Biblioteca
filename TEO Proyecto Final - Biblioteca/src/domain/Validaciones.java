package domain;

import java.util.Scanner;

/* 1. En esta clase colocamos los metodos de validacion de entradas (finalmente solo fue para evitar que el usuario 
      dejase campos vacios de Strings (para evitar que se creen objetos instanciados con campos sin completar). 
      Los posibles errores por causa de ingreso de textos en campos reservados para numeros, los controlamos con estructuras
      try / catch atrapando sobre todo los errores de NumberFormatException, directamente en Main.
*/

public class Validaciones {

    Scanner in = new Scanner(System.in);
    
    public Validaciones() {
    }
    
    //1. Metodo para validar entradas de texto y que no queden vacias a la hora de crear nuevas Instancias de Clases
    public String validarTexto(String texto){
        
        while(texto.isEmpty()){
            System.out.println("El campo no puede quedar vacio");
            System.out.println("Ingrese texto: ");
            texto = in.nextLine();
        }
        return texto;
    }
    
    //2. Metodo para generar una pausa en el programa, que permita leer los resultados en pantalla antes de volver al menu
    public void pausa (){
        System.out.println("Presione la tecla Enter para continuar...");
        in.nextLine();
    }
}
