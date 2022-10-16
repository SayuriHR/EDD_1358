 
package Ejerc;


import codigos.ADTS.Array2DADT;
import java.util.Stack;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


/**
 *
 * @author DAIRA HERNANDEZ
 */
public class Laberinto {
    private final Stack<ArrayList<Integer>> pila = new Stack();
    private final Array2DADT matriz;
    private final int numFilas;
    private final int numColumnas;
    private ArrayList<Integer> meta;
    private boolean solucion = true;
    private String resultado;

    public Laberinto(ArrayList<ArrayList<String>> archivo) {
        this.numFilas = Integer.parseInt(archivo.get(0).get(0));
        this.numColumnas = Integer.parseInt(archivo.get(1).get(0));
        this.matriz = new Array2DADT(numFilas, numColumnas);
        this.obtenerLaberinto(archivo);
        this.puntosIniciales(archivo);
    }

    public void paint(Graphics grafico) {
        int anchoBloque = 40;
        int altoBloque = 40;
        for (int filas = 0; filas < numFilas; filas++) {
            for (int columnas = 0; columnas < numColumnas; columnas++) {
                switch (matriz.getElemento(filas, columnas).toString()) {
                    case "1":
                        grafico.setColor(Color.CYAN);
                        grafico.fillRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        grafico.setColor(Color.black);
                        grafico.drawRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        break;
                    case "V":
                        grafico.setColor(Color.GREEN);
                        grafico.fillRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        break;
                    case "X":
                        grafico.setColor(Color.RED);
                        grafico.fillRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        break;
                    case "E":
                        grafico.setColor(Color.YELLOW);
                        grafico.fillRect(columnas * anchoBloque, filas * altoBloque, anchoBloque, altoBloque);
                        break;
                }
            }
        }
    }

    private void obtenerLaberinto(ArrayList<ArrayList<String>> archivo) {
        for (int i = 0; i < numFilas; i++) {//i = filas
            for (int j = 0; j < numColumnas; j++) {//j = columnas
                matriz.setElemento(i, j, archivo.get(i + 2).get(j));
            }
        }
    }

    private void puntosIniciales(ArrayList<ArrayList<String>> archivo) {
        int longitud = archivo.size();
        ArrayList<Integer> entrada = new ArrayList(2);
        entrada.add(Integer.parseInt(archivo.get(longitud - 2).get(0)));
        entrada.add(Integer.parseInt(archivo.get(longitud - 2).get(1)));
        this.meta = new ArrayList(2);
        meta.add(Integer.parseInt(archivo.get(longitud - 1).get(0)));
        meta.add(Integer.parseInt(archivo.get(longitud - 1).get(1)));
        this.matriz.setElemento(entrada.get(0), entrada.get(1), "E");
        this.pila.push(entrada);
    }

    private void avanzarPorPasos(ArrayList<Integer> posicion) {
        if (this.verificarCasilla(posicion.get(0), posicion.get(1) - 1)) {//Izquierda
            this.moverse(posicion.get(0), posicion.get(1) - 1);
        } else if (this.verificarCasilla(posicion.get(0) - 1, posicion.get(1))) {//Arriba
            this.moverse(posicion.get(0) - 1, posicion.get(1));
        } else if (this.verificarCasilla(posicion.get(0), posicion.get(1) + 1)) {//Derecha
            this.moverse(posicion.get(0), posicion.get(1) + 1);
        } else if (this.verificarCasilla(posicion.get(0) + 1, posicion.get(1))) {//Abajo
            this.moverse(posicion.get(0) + 1, posicion.get(1));
        } else if (this.meta.containsAll(posicion)) {//Ya se encontró la salida
            this.resultado = "Solución: \n" + this.pila.toString();
            this.solucion = false;
        } else { //No hay posibles caminos
            this.matriz.setElemento(posicion.get(0), posicion.get(1), "X");
            this.pila.pop();
            if (this.pila.isEmpty()) {
                this.resultado = "No se encontro solución: ";
                this.solucion = false;
            }
        }
    }

    private void buscarSolucion(int fila, int columna) {
        if (this.verificarCasilla(fila, columna - 1)) {//Izquierda
            this.moverse(fila, columna - 1);
            this.buscarSolucion(fila, columna - 1);
        } else if (this.verificarCasilla(fila - 1, columna)) {//Arriba
            this.moverse(fila - 1, columna);
            this.buscarSolucion(fila - 1, columna);
        } else if (this.verificarCasilla(fila, columna + 1)) {//Derecha
            this.moverse(fila, columna + 1);
            this.buscarSolucion(fila, columna + 1);
        } else if (this.verificarCasilla(fila + 1, columna)) {//Abajo
            this.moverse(fila + 1, columna);
            this.buscarSolucion(fila + 1, columna);
        } else if (this.meta.contains(fila) && this.meta.contains(columna)) { //Ya encontró la salida
            this.resultado = "Solución: \n" + this.pila.toString();
        } else { //No hay posibles caminos
            this.matriz.setElemento(fila, columna, "X");
            this.pila.pop();
            if (this.pila.isEmpty()) { //Verifica sí hay todavía lugar a donde moverse
                this.resultado = "No se encontro solución: ";
            } else {
                this.buscarSolucion(this.pila.peek().get(0), this.pila.peek().get(1));
            }
        }
    }

    private boolean verificarCasilla(int fila, int columna) {
        if (this.comprobarRango(fila, columna)) {
            return matriz.getElemento(fila, columna).equals("0");
        }
        return false;
    }

    private void moverse(int fila, int columna) {
        ArrayList<Integer> nuevaPosicion = new ArrayList(2);
        nuevaPosicion.add(fila);
        nuevaPosicion.add(columna);
        this.matriz.setElemento(fila, columna, "V");
        this.pila.push(nuevaPosicion);
    }

    private boolean comprobarRango(int fila, int columna) {
        return (fila >= 0 && fila < this.numFilas && columna >= 0 && columna < this.numColumnas);
    }

    public void siguientePaso() {
        this.avanzarPorPasos(this.pila.peek());
    }

    public void buscarSinDetenerse() {
        ArrayList<Integer> a = this.pila.peek();
        this.buscarSolucion(a.get(0), a.get(1));
    }

    public boolean isSolucion() {
        return this.solucion;
    }

    public String resultadoFinal() {
        return this.resultado;
    }
}
