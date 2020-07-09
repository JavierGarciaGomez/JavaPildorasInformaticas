package l028_035POO;

public class MainCoche28_32 {
    public static void main(String[] args) {
        Coche28_32 coche = new Coche28_32();
        // L31 Paso de parametros
        coche.setColor("azul");
        System.out.println(coche.toString());
        coche.setClimatizador(true);
        System.out.println(coche.toString());
        System.out.println("El precio final del coche es: "+coche.getPrecio());



    }
}
