
package Ejerc;

/**
 *
 * @author SAYURI HERNANDEZ
 */
class Casilla {
    private boolean celviva = false;

    public boolean isCelviva() {
        return celviva;
    }

    public void setCelviva(boolean celviva) {
        this.celviva = celviva;
    }

    public Casilla(boolean celviva) {
        this.celviva = celviva;
    }

    @Override
    public String toString() {
        if (celviva) {
            return "v";
        } else{
        return "m";
        }
    }
    
}

