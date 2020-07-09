package l179_189Colecciones.l184LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> personas = new LinkedList<>();
        personas.add("Pepe");
        personas.add("Sandra");
        personas.add("Ana");

        ListIterator<String> it = personas.listIterator();
        it.next();
        for(String persona: personas){
            System.out.println(persona);
        }

        // 185
        LinkedList<String> paises = new LinkedList<>();
        paises.add("España");
        paises.add("Colombia");
        paises.add("México");
        paises.add("Perú");

        LinkedList<String> capitales = new LinkedList<>();
        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("Ciudad de México");
        capitales.add("Lima");

        ListIterator<String> itPaises = paises.listIterator();
        ListIterator<String> itCapitales = capitales.listIterator();

        // while para agregar cada capital al array de países
        while(itCapitales.hasNext()){
            if(itPaises.hasNext()){
                itPaises.next();
            }
            itPaises.add(itCapitales.next());
        }

        System.out.println(paises);

        // Reiniciar iterador y eliminar los pares
        itCapitales=capitales.listIterator();
        while(itCapitales.hasNext()){ // hay una posición siguiente // segunda vuelta:
            itCapitales.next(); // si es así, muévete a la 1 // muévete a la 3
            if(itCapitales.hasNext()){ // ¿hay más?
                itCapitales.next(); // si es así, muévete a la 2 // muévete a la 4
                itCapitales.remove(); // elimina la 2 // elíminala
            }
        }

        // RemoveAll
        paises.removeAll(capitales);
        System.out.println(paises);

    }
}
