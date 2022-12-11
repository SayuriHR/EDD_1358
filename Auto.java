package Exposicion;

public class Auto {

    //estado 
    private String patente;
    private String color;           

    //constructor 
    public Auto(String patente, String color) {
        this.patente = patente;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" + "patente" + patente + ", color " + color + '}';
    }

}
