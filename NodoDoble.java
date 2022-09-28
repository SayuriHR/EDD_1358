
package Ejerc;

/**
 *
 * @author DENISSE HERNANDEZ
 */
public class NodoDoble<T> {
    private T dato; 
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;
    
    //Almacena un valor dato 
    public NodoDoble(T dato) {
        this.siguiente = null;
        this.anterior = null;
        this.dato = dato;
    }

    public NodoDoble(T dato, NodoDoble<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = null;
    }
    
    public NodoDoble(T dato, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoDoble<T> getSiguiente() { //Señala al siguiente nodo 
        return this.siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) { //diferente nodo 
        this.siguiente = siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente, boolean juntar) {
        this.siguiente = siguiente; //Los nodos se juntan y cambian 
        siguiente.setAnterior(this);
    }
    
    public NodoDoble<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {//Diferente al nodo anterior 
        this.anterior = anterior;
    }

    public void setAnterior(NodoDoble<T> anterior, boolean juntar) {
        this.anterior = anterior;
        anterior.setSiguiente(this);
    }

    public T getDato() {
        return dato; //guarda el nodo 
    }

    public void setDato(T dato) { //Es diferente el nodo 
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "|" + dato + "| <-->";
    }

    public String TodosLosNodos() {
         return "[Anterior= "+ this.getAnterior() + "] <-> [Dato= " + dato + 
                 "] <-> [Siguiente= " + this.getSiguiente() + "]";
    }
    
    public static void main(String[] args) {
        NodoDoble inicio = new NodoDoble(9);
        NodoDoble fin;
        NodoDoble dn1 = new NodoDoble(8);
        dn1.setAnterior(inicio, true);
        dn1.setSiguiente(new NodoDoble(7), true);
        System.out.println(inicio.TodosLosNodos());
        System.out.println(inicio.getSiguiente());
        System.out.println(inicio.getSiguiente().getAnterior());
        fin = inicio.getSiguiente().getSiguiente();
        System.out.println("Ultimo: " +fin);
        System.out.println("Anterior al ultimo: "+fin.getAnterior());
        System.out.println(fin.TodosLosNodos());
        
        
    }
}
