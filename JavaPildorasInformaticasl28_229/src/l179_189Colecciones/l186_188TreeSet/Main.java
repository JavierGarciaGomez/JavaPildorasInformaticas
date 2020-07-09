package l179_189Colecciones.l186_188TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 186
        TreeSet<String> sortPeople = new TreeSet<>();
        sortPeople.add("Sandra");
        sortPeople.add("Amanda");
        sortPeople.add("Diana");

        // Los imprime en orden alfabético

        // Creo una clase artículs con interfaz comparable con base en el número de artículo y me los imprime en orden

        System.out.println(sortPeople);

        Articulo art1 = new Articulo(1,"zanahoria1");
        Articulo art3 = new Articulo(3,"sandía3");
        Articulo art2 = new Articulo(2,"lechuga2");
        Articulo art4 = new Articulo(4,"manzana4");
        Articulo art5 = new Articulo(5,"brócoli5");

        TreeSet<Articulo> articulos = new TreeSet<>();
        articulos.add(art4);
        articulos.add(art2);
        articulos.add(art3);
        articulos.add(art1);
        articulos.add(art5);

        for(Articulo art:articulos){
            System.out.println(art.getDesc());
        }

        // 187 Interfaz Comparator
        //Articulo comparadorArticulos = new Articulo();
        System.out.println("\nAhora ordenaré alfabéticamente");

        // Primero lo hice con un método de artículo, pero ya luego se hizo con clase abstracta
//        TreeSet<Articulo> articulosAlfabético = new TreeSet<>(new Articulo());
//        articulosAlfabético.addAll(articulos);
//
//        for(Articulo art:articulosAlfabético){
//            System.out.println(art.getDesc());
//        }

        TreeSet<Articulo> articulosAlfabético = new TreeSet<>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {
                return o1.getDesc().compareTo(o2.getDesc()); // CompareTo compara los Strings alfabéticamente
            }
        });
        articulosAlfabético.addAll(articulos);

        for(Articulo art:articulosAlfabético){
            System.out.println(art.getDesc());
        }

    }
}

class Articulo implements Comparable<Articulo> {
    private int num;
    private String desc;

    public Articulo(int num, String desc) {
        this.num = num;
        this.desc = desc;
    }

    public Articulo() {

    }

    public String getDesc() {
        return desc;
    }

    @Override
    public int compareTo(Articulo o) {
        return num-o.num; // con esto se ordena por el número de artículo
    }

    //187
//    @Override
//    public int compare(Articulo o1, Articulo o2) {
//        return o1.getDesc().compareTo(o2.getDesc()); // CompareTo compara los Strings alfabéticamente
//    }
}
