
package Ejerc;

/**
 *
 * @author SAYURI HERNANDEZ
 */
class Nodo<T> {

    private T dato;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(T valor) {
        this.dato = valor;
    }

    public Nodo(T dato, Nodo<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "|" + dato + "| --> ";
    }

    public String printAll() {
        if (this.siguiente == null) {
            return this.toString() + null;
        }
        return this.toString() + this.getSiguiente().printAll();

    }
}
