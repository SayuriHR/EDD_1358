package Ejerc;

import java.util.Scanner;

/**
 *
 * @author SAYURI HERNANDEZ
 */
public class JuegoDeLaVida {

    Casilla[][] matriz = new Casilla[10][10];
    int celulasvivas;
    int[][] matriz2 = new int[10][10];
    Scanner lector = new Scanner(System.in);
    Casilla casillamuerta = new Casilla(false);
    Casilla casillaviva = new Casilla(true);

    public JuegoDeLaVida(int celvivas) {
        this.celulasvivas = celvivas;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = casillamuerta;
            }

        }
        int y;
        int x;
        for (int cont = 0; cont < celvivas; cont++) {
            System.out.println("Componente en Y: ");
            y = lector.nextInt();
            System.out.println("Componente en X: ");
            x = lector.nextInt();
            matriz[y][x] = casillaviva;

        }

    }

    public int comparacion(int fila, int columna) {
        int contadorvivas = 0;

        //arriba
        if (fila - 1 >= 0) {
            if (((Casilla) matriz[fila - 1][columna]).isCelviva()) {
                contadorvivas = contadorvivas + 1;
            }
        }

        //izquierda
        if (columna - 1 > -1) {
            if (((Casilla) matriz[fila][columna - 1]).isCelviva()) {
                contadorvivas++;
            }
        }

        //izquierda arriba
        if (columna - 1 > -1 && fila - 1 > -1) {
            if (((Casilla) matriz[fila - 1][columna - 1]).isCelviva()) {
                contadorvivas++;
            }
        }

        //arriba derecha
        if (fila - 1 > -1 && columna + 1 < 10) {
            if (((Casilla) matriz[fila - 1][columna + 1]).isCelviva()) {
                contadorvivas++;
            }
        }

        //derecha
        if (columna + 1 < 10) {
            if (((Casilla) matriz[fila][columna + 1]).isCelviva()) {
                contadorvivas++;
            }
        }

        //derecha abajo
        if (columna + 1 < 10 && fila + 1 < 10) {
            if (((Casilla) matriz[fila + 1][columna + 1]).isCelviva()) {
                contadorvivas++;
            }
        }

        //abajo
        if (fila + 1 < 10) {
            if (((Casilla) matriz[fila + 1][columna]).isCelviva()) {
                contadorvivas++;
            }
        }

        //abajo izquierda
        if (fila + 1 < 10 && columna - 1 > -1) {
            if (((Casilla) matriz[fila + 1][columna - 1]).isCelviva()) {
                contadorvivas++;
            }

        }
        return contadorvivas;
    }

    public void SiguienteGeneracion() {
        int numvivas;
        System.out.println("------");
        System.out.println(this.toString());
        Casilla[][] matriz3 = matriz;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                numvivas = this.comparacion(i, j);

                System.out.print(numvivas + " ");
                matriz2[i][j] = numvivas;
                
            }

            System.out.println(" ");

        }
        System.out.println("Matriz de contadores");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz2[i][j]);

            }
            System.out.println("");

        }
        System.out.println("Matriz duplicada");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz3.length; j++) {
                System.out.print(matriz3[i][j]);

            }
            System.out.println("");

        }

        System.out.println("Generación Siguiente:");
        int vivas = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                vivas = matriz2[i][j];

                if (matriz[i][j].isCelviva() && (vivas == 2 || vivas == 3)) {
                    matriz3[i][j] = casillaviva;
                }
                if (vivas < 2) {
                    matriz3[i][j] = casillamuerta;
                }
                if (matriz[i][j].isCelviva() && vivas > 3) {
                    matriz3[i][j] = casillamuerta;
                }
                if (matriz[i][j].isCelviva() == false && vivas == 3) {
                    matriz3[i][j] = casillaviva;
                }

            }

        }
        System.out.println("siguiente generación");
            matriz = matriz3;
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String mensaje = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                mensaje = mensaje + matriz[i][j] + " ";
            }
            mensaje = mensaje + "\n";
        }
        return mensaje;
    }

}
