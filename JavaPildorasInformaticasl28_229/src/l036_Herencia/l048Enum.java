package l036_Herencia;

import java.util.Scanner;

public class l048Enum {
    public static void main(String[] args){

        Talla l=Talla.grande;
        Talla s=Talla.pequeño;
        Talla m=Talla.mini;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe una talla:");
        String entrada=scanner.next().toUpperCase();
        TallaConstructor tallaConstructor = Enum.valueOf(TallaConstructor.class, entrada);
        System.out.println("Talla"+tallaConstructor);
        System.out.println("Abreviatura"+tallaConstructor.getAbreviatura());
    }

    enum Talla{mini, pequeño, mediano, grande}

    enum TallaConstructor {
        MINI("S"), Mediano("M"), Grande("L");
        private String abreviatura;

        private TallaConstructor(String abreviatura){
            this.abreviatura=abreviatura;
        }

        public String getAbreviatura(){
            return abreviatura;
        }



    }

}
