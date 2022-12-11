package Exposicion;

import java.util.ArrayList;

public class TestAuto {

    public static void main(String[] args) {
        //objetos 
        Auto a1 = new Auto("CDEG123", "morado");
        //Auto a2 = new Auto("ERTW345", "rosa");
        //Auto a3 = new Auto("TYUU789", "azul");

        ArrayList<Auto> misAutos = new ArrayList<>(); 
        System.out.println(misAutos.size()); //Sale un valor de 0 devuleve el num de elementos 
        System.out.println(misAutos);

        System.out.println("* * * * * * * * * *");
        misAutos.add(a1);           //añade el objeto 
        System.out.println(misAutos.size()); //Sale un valor de 1 
        System.out.println(misAutos);

        System.out.println("* * * * * * * * * *");
        misAutos.add(new Auto("ERTW345", "rosa")); // se puede definir el argumento 
        System.out.println(misAutos.size()); //Sale un valor de 2 
        System.out.println(misAutos);

        System.out.println("* * * * * * * * * *");
        misAutos.add(new Auto("TYUU789", "azul")); //añadir valores 
        System.out.println(misAutos.size()); //Sale un valor de 3 
        System.out.println(misAutos);

        System.out.println("* * * * * * * * * *");
        System.out.println("El auto 3° es:" + misAutos.get(2)); //Indica en la posicion que esta

        System.out.println("* * * * * * * * * *");
        System.out.println("Mostrando todos los autos de la lista:");
        for (int i = 0; i < misAutos.size(); i++) {
            System.out.println("El auto en la posicion " + i + "es" + misAutos.get(i));
        }

        System.out.println("* * * * * * * * * *");
        misAutos.remove(1); // se elimino el auto 2 
        System.out.println(misAutos.size());
        System.out.println(misAutos);

    }

}
