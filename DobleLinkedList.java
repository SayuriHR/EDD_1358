package Ejerc;

/**
 *
 * @author SAYURI HERNANDEZ
 */
public class DobleLinkedList<T> {

    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int tamanio;

    public DobleLinkedList() {
        this.tamanio = 0;
    }

    public boolean Estavacia() {
        return this.inicio == null;
    }

    public int getTamanio() { //regresa el numero de elemntos 
        return this.tamanio;
    }

    public void AgregarInicio(T valor) {
        NodoDoble<T> nuevo = new NodoDoble(valor);
        if (this.Estavacia()) {
            this.inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio, true);
            inicio = nuevo;
        }
        this.tamanio++;
    }

    public void AgregarFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble(valor);
        NodoDoble<T> Aux;
        if (this.Estavacia()) {
            this.fin = nuevo;
        } else {
            Aux = fin;
            this.fin = nuevo;
            Aux.setSiguiente(fin, true);
        }
        this.tamanio++;
    }

    public void AgregarDespuesDe(int posicion, T valor) {
       NodoDoble Aux = new NodoDoble(valor);
        NodoDoble Tem = this.inicio;
        for (int contador = 1; contador <= posicion - 1; contador++) {
            Tem = Tem.getSiguiente();
        }
        Aux.setSiguiente(Tem.getSiguiente());
        Tem.setSiguiente(Aux);
        Tem.setAnterior(Tem.getAnterior());
    }

    public void eliminar(int posicion) {
        NodoDoble Aux = inicio;
        if (this.Estavacia()) {
            System.out.println("La lista esta vacia");
        } else {
            if (posicion > inicio.toString().length()) {
                System.out.println("no existe la lista ");
            } else {
                for (int contador = 1; contador < posicion - 1; contador++) {
                    Aux = Aux.getSiguiente();
                }
            }
        }

        Aux.setSiguiente(Aux.getSiguiente().getSiguiente());
        Aux.setAnterior(Aux.getAnterior());
    }

    public void eliminarInicio() {
        NodoDoble Aux = inicio;
        if (this.Estavacia()) {
            inicio = Aux;
        } else {
            inicio = Aux.getSiguiente();
        }
    }
    
    public void eliminarFinal() {
        NodoDoble Aux = inicio;
        if (this.Estavacia()) {
            inicio = Aux;
        } else {
            while (Aux.getSiguiente().getSiguiente() != null) {
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(null);
        }
            }

    public int buscar(T dato) {
        NodoDoble aux = this.inicio;
        for (int posicion = 0; posicion < this.tamanio; posicion++) {
            if (aux.getDato().equals(dato)) {
                return posicion;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return -1;
    }

    public void actualizar(T dato, T actualizar) {
        NodoDoble Aux = inicio;
        while (Aux.getDato() != dato) {
            Aux = Aux.getSiguiente();
        }
        Aux.setDato(actualizar);
    }

    public void transversal(int direccion) {
       NodoDoble nodo_actual = this.inicio;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("  ");
    }

    public static void main(String[] args) {
        DobleLinkedList a = new DobleLinkedList();
        a.AgregarFinal(18);
        a.AgregarFinal(1);
        a.AgregarFinal(27);
        a.AgregarFinal(20);
        a.AgregarFinal(500);
        a.transversal(2);
        a.eliminarFinal();
        a.actualizar(1, 1818);
        a.transversal(1);
        a.eliminarInicio();
        a.transversal(4);
        a.eliminar(2);
        a.transversal(2);
        a.AgregarDespuesDe(1, 18);
        a.transversal(5);
        a.AgregarFinal(27);
        a.AgregarInicio(2);
        a.transversal(7);
    }

}
