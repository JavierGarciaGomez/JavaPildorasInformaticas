package l142_151ExcepcionesDebugg;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main144 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner entrada=new Scanner (System.in);

        int decision=entrada.nextInt();

        if (decision==1){
            pedirDatos();
        }else{
            System.out.println("Adios");
            System.exit(0);
        }
        entrada.close();
    }

    // Capturando un throw
    static void pedirDatos() throws InputMismatchException {
        try {
            Scanner entrada=new Scanner(System.in);

            System.out.println("Introduce tu nombre, por favor");
            String nombre_usuario=entrada.nextLine();

            System.out.println("Introduce edad, por favor");
            /* Si en vez de introducir un número se introduce un texto,
             * se genera la excepción InputMismatchException
             */
            int edad=entrada.nextInt();

            System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad+1) + " años");

            entrada.close();

            /* tratamiento de la excepción con el catch
             * Alternativamente se puede poner que capture una excepción más genérica como:
             * catch(Exception e)
             */

        } catch(InputMismatchException e) {
            System.out.println("Qué demonios introdujiste");
            e.printStackTrace();
        }
        System.out.println("Hemos terminado");
    }
}
