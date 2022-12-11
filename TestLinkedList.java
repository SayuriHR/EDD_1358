
package Ejerc;

import java.util.LinkedList;

/**
 *
 * @author DENISSE HERNANDEZ
 */
public class TestLinkedList {
     public static void main(String[] args) {
        LinkedList lista = new LinkedList();

            lista.addFirst("CocaCola"); // al inico de la lista 
            lista.addLast("Jarrito"); // al final 
            lista.addLast("Manzanita");
            lista.addLast("Pepsi");
            lista.addLast("Seven");
            System.out.println(lista);

           
            System.out.printf("Lista: ", lista.size());
           
            System.out.println(lista.get(2)); // el get nos va a regresar el elemanto
            System.out.println(lista.getFirst());  // el inicio 
            System.out.println(lista.getLast()); //final
            
            //set(int indice, Object elemento) cambia el elemento ubicado en el indice indicado
            System.out.printf("Refresco numero 1:", lista.get(3));
            lista.set(3, "squirt");
            System.out.println(lista.get(3));
            
            lista.addFirst("Pepsi");
            lista.addLast("CocaCola");
            System.out.println(lista);
           lista.removeLastOccurrence("Jarrito"); //elimina la ultima 
           lista.removeFirstOccurrence("Manzanita"); // elimina la primera 
            System.out.println(lista);
            
    }
}
