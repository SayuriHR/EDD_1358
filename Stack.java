
package Ejerc;

import java.util.ArrayList;

/**
 *
 * @author SAYURI HERNANDEZ
 */
public class Stack<T> {
 private final ArrayList<T> datos = new ArrayList();
    private T tope, base;
   
    public boolean isEmpty(){
        return datos.isEmpty();
    }
    
    public int length(){
        return datos.size();
    }
    
    public T pop(){
        T salida = tope;
        datos.remove(tope);
        if (this.isEmpty()) {
            tope = null;
            base = null;
        }else{
        tope = datos.get(this.length()-1);
        }
        return salida;
    }
    
    public T peek(){
        return tope;
    }
    
    public void push(T data){
        datos.add(data);
        if (this.length() == 1) {
            base = datos.get(0);
        }
        tope = datos.get(this.length()-1);
    }

    @Override
    public String toString() {
        String salida = "";
        for (int i = this.length()-1; i >= 0; i--) {
            salida += datos.get(i).toString() + "\n";
        }
        return salida;
    }
    
    public String toStringReverse() {
        String salida = "";
        for (int i = 0; i < this.length(); i++) {
            salida += datos.get(i).toString() + "\n";
        }
        return salida;
    }
    
    public T getBase(){
        return base;
    }
    
    public static void main(String[] args) {
        Stack pila = new Stack();
        pila.push(106); // se anexa al final de lista 
        pila.push(88);
        pila.push(77);
        pila.push(64);
        pila.push(43);
        System.out.println(pila);
        System.out.println(pila.peek()); // consulta el elemnto del tope sin sacarlo  
        System.out.println(pila);
    }
}
