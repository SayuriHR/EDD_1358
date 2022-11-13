
package Ejerc;

import java.util.ArrayList;

/**
 *
 * @author SAYURI HERNANDEZ 
 */
public class ColasADT<T> {
    private final ArrayList<T> college;
    private int size;
    
    //ALMACENA DATOS 
    public ColasADT() {
        college = new ArrayList();
    }
    //¿ESTA VACIA?
    public boolean isEmpty() {
        return size == 0;
    }
    // SIRVE PARA SABER EL TAMAÑO DE LA COLA 
    public int size(){
        return size;
    }
    // INGRESA UN ELEMENTO AL FINAL
    public void enqueue(T element){
        college.add(size++, element);
    }
    //Saca el elemento que se encuentra el frente de la estructura.
    public T dequeue(){
        T out = null;
        if (!this.isEmpty()) {
            out = college.remove(0);
            size--;
        }
       return out;
    }

    @Override
    public String toString() {
        String out = "";
        if (!this.isEmpty()) {
          out = college.stream().map(element -> ","+ element).reduce(out, String::concat);
        return "{" + out.substring(1) + "}";  
        }
        return "{" + out+ "}";
    }
    
    public static void main(String[] args) {
        ColasADT ejemplo = new ColasADT();
        ejemplo.enqueue("MANZANA");
        ejemplo.enqueue("SANDIA");
        ejemplo.enqueue("NARANJA");
        ejemplo.enqueue("MANGO");

        System.out.println(ejemplo.toString());
        System.out.println(ejemplo.dequeue());
        System.out.println(ejemplo.toString());
        System.out.println(ejemplo.dequeue());
        System.out.println(ejemplo.toString());
        System.out.println(ejemplo.dequeue());
        System.out.println(ejemplo.toString());
        System.out.println(ejemplo.size());
    }  
}
