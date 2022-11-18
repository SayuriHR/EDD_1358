
package Ejerc;

import java.util.ArrayList;

/**
 *
 * @author SAYURI HERNANDEZ
 * @param <T>
 */
public class ADTTablasHash<T> {
     int key;
    int tam;
    T dato;
    ArregloADT<T> Tabla;
    ArrayList<T> array;


    public ADTTablasHash() {
    }

    public ADTTablasHash(int tam) {
        this.tam = tam;
        Tabla = new ArregloADT(tam);
    }
   
    public void add(int key, T dato){
     int colocador = key%tam;
     Tabla.setElemento(colocador, dato);
    }

    public T valueOf(int key){
     int colocador = key%tam;   
     return (T) Tabla.getElemento(colocador) ; 
    }
 
    public void eliminar(int key){
     int colocador = key%tam; 
     Tabla.limpiar(dato);
    }

    @Override
    public String toString() {
        return "|"+Tabla+"|"; 
    }

    public static void main(String[] args) {
        ADTTablasHash prueba = new ADTTablasHash(10);
        prueba.add(5,123);
        prueba.add(9, 456);
        prueba.add(10, 678);
        System.out.println(prueba);
        prueba.eliminar(9);
        prueba.eliminar(10);
        prueba.eliminar(5);
        System.out.println(prueba);
       
    }
}
