
package Ejerc;

/**
 *
 * @author SAYURI HERNANDEZ
 */
public class TestJuegoDeLaVida {
    public static void main(String[] args) {
        
        int generacionespedidas = 10;
        System.out.println("Tablero");
        JuegoDeLaVida tablero = new JuegoDeLaVida(5);
        
        System.out.println(tablero);
        for (int contador = 0; contador < generacionespedidas; contador++) {
            System.out.println("Siguiente Generación");
            tablero.SiguienteGeneracion();
            
        }
        
    }
}
