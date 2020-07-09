package l179_189Colecciones.l179_183HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Antonio Banderas", "00001", 200000);
        Cliente cliente2 = new Cliente("Rafael Nadal", "00002", 250000);
        Cliente cliente3 = new Cliente("Penelope Cruz", "00003", 300000);
        Cliente cliente4 = new Cliente("Meryl Streep", "00004", 400000);
        // No lo agrega, porque tiene la misma cuenta
        Cliente cliente5 = new Cliente("Antonio Banderas", "00001", 200000);

        Set <Cliente> clientes = new HashSet<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);

        for (Cliente c:clientes) {
            System.out.println(c.toString());
        }

        //181
        Libro libro1 = new Libro("Programación en Java", "Juan", "25");
        Libro libro2 = new Libro("Programación en Java", "Juan", "25");

        if (libro1.equals(libro2)) System.out.println("Es el mismo libro");

        System.out.println(libro1.hashCode());
        System.out.println(libro2.hashCode());


        // 183
        Iterator<Cliente> it=clientes.iterator();
        while(it.hasNext()) {
            String nombreCliente=it.next().getNombre();
            System.out.println(nombreCliente);
        }

        // Remove con iterador
        System.out.println("\nVoy a remover a Meryl Streep");
        it=clientes.iterator();
        while(it.hasNext()) {
            String nombreCliente=it.next().getNombre();
            if (nombreCliente.equals("Meryl Streep")){
                it.remove();
            }
        }

        it=clientes.iterator();
        while(it.hasNext()) {
            String nombreCliente=it.next().getNombre();
            System.out.println(nombreCliente);
        }


    }
}
