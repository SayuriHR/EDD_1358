package Ejerc;

// DAIRA SAYURI HERNANDEZ RUBIO 

public class TestArregloADT {

    public static void main(String[] args) {

        System.out.println("ARREGLO ADT");
        ArregloADT arregloADT = new ArregloADT(7);
        arregloADT.setElemento(0, "Vivir ");
        arregloADT.setElemento(1, "asi");
        arregloADT.setElemento(2, "es");
        arregloADT.setElemento(3, "morir");
        arregloADT.setElemento(4, "de");
        arregloADT.setElemento(6, "Amor");
        System.out.println("imprimiendo el arreglo");
        System.out.println(arregloADT.toString());
        System.out.println("elijiendo casilla 6");
        System.out.println(arregloADT.getElemento(6));
        System.out.println("limpiando arreglo");
        arregloADT.limpiar();
        System.out.println(arregloADT.toString());

    }

}
