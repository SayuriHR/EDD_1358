
package Ejerc;

import java.util.HashMap;

/**
 *
 * @author SAYURI HERNANDEZ
 */
public class ColasDePrioridadAcostada <T>{
    private final HashMap<Integer, ColasADT<T>> collection; 
    private int NumeroDeElementos;
    private int Prioridad;
    
    public ColasDePrioridadAcostada(int levels) {
        collection = new HashMap(levels);
        for (int key = 0; key < levels; key++) {
            collection.put(key, new ColasADT());
        }
    }
    //¿Esta vacia?
    public boolean isEmpty(){
        return NumeroDeElementos == 0;
    }
    
    //Regresa el número de elementos en la cola con prioridad acotada.
    public int length(){
        return NumeroDeElementos;
    }
    //Ingresa un elemento según su prioridad
    public void enqueue(int priority, T element){
        collection.get(priority).enqueue(element);
        NumeroDeElementos++;
    }
    //Saca el elemento que se encuentra con mayor prioridad.
    public T dequeue(){
        T out = null;
        if (!this.isEmpty()) {
            this.checarPrioridad();
            out = collection.get(Prioridad).dequeue();
            NumeroDeElementos--;
        }
        return out;
    }
    //Revisa los niveles que tienen mayor prioridad
    private void checarPrioridad(){
        if (this.collection.get(this.Prioridad).isEmpty() && NumeroDeElementos > 0) {
            this.Prioridad++;
        }
    }
    public static void main(String[] args) {
        ColasDePrioridadAcostada<String> cola = new ColasDePrioridadAcostada(7);
        cola.enqueue(4, "Maestre");
        cola.enqueue(2, "Niños");
        cola.enqueue(4, "Mecanico");
        cola.enqueue(3, "Hombres");
        cola.enqueue(4, "Vigia");
        cola.enqueue(5, "Capitan");
        cola.enqueue(4, "Timonel");
        cola.enqueue(3, "Mujeres");
        cola.enqueue(2, "3ra edad");
        cola.enqueue(1, "Niñas");
        
        while(!cola.isEmpty()){
            System.out.printf("%s estan en el barco %n", cola.dequeue());
        }
    }

}
