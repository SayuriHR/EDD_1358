package Ejerc;

import java.util.ArrayList;

// DAIRA SAYURI HERNANDEZ RUBIO 
public class ArregloADT {

    public int tamanio;
    ArrayList<Object> Lista = new ArrayList(tamanio);

    //CONSTRUCTOR 
    public ArregloADT(int tamanio) {
        this.tamanio = tamanio;
        System.out.println("El arreglo tiene un tamaño de:" + tamanio + " casillas");

        for (int i = 0; i < tamanio; i++) {
            Lista.add(null);
        }
        System.out.println(Lista);
    }

    //  NOS VA RETORNAR EL TAMAÑO 
    public int getLongitud() {
        return Lista.lastIndexOf(Lista);
    }

    // ESTABLECE UN ELEMENTO EN UNA POSICION ESPECIFICA 
    public void setElemento(int índice, Object item) {
        Lista.set(índice, item);
    }

    //REGRESA EL ELEMENTO EN EL INDICE SOLICITADO 
    public Object getElemento(int índice) {
         return Lista.get(índice);
    }

    //VA A LIMPIAR TODO NUESTRO DOCUMENTO SIN DEJAR RASTRO 
    public void limpiar() {
        for (int i = 0; i < tamanio; i++) {
            Lista.set(i, null);
        }
    }

    // REGRESA EL STRING EN EL ESTADO ACTUAL DEL OBJETO 
    @Override
    public String toString() {
        return Lista.toString();
    }
}
