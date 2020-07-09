package l142_151ExcepcionesDebugg;

import javax.swing.*;

public class Main147 {

    public static void main(String[] args) {
        String elMail= JOptionPane.showInputDialog("Introduce tu mail");

        // Si nuestra excepción no hereda de Exception o IOException no requiere Try/catch
        try {
            examinaMail(elMail);
        } catch (LongitudMailErronea longitudMailErronea) {
            System.out.println("Longitud errónea");
        }
    }

    static void examinaMail (String elMail) throws LongitudMailErronea {
        int arroba=0;
        boolean punto=false;
        if(elMail.length()<=3) {

            //Con esto se obtiene un error definido por el mismo usuario aunque no tenga qeu ver.
			/*
			 *  Versión larga
			 * ArrayIndexOutOfBoundsException e=new ArrayIndexOutOfBoundsException();
			throw e;
			 */

            //Versión simplificada
            throw new LongitudMailErronea("La longitud es errónea");
        }

        else {
            for(int i=0; i<elMail.length();i++) {
                if(elMail.charAt(i)=='@') arroba++;
                if(elMail.charAt(i)=='.') punto=true;
            }
            if (arroba==1 && punto==true) System.out.println("El mail es correcto");
            else System.out.println("El mail es incorrecto");
        }
    }
}

class LongitudMailErronea extends Exception{
    public LongitudMailErronea(){}
    public LongitudMailErronea(String msjError){
        super(msjError);
    }

}