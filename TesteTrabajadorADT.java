package Ejerc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//Daira Sayuri Hernadez Rubio 
public class TesteTrabajadorADT {

    public static void main(String[] args) {

        Scanner escritor = new Scanner(System.in);

        String[][] datosCSV = deCSVaMatriz("C:\\Users\\DENISSE HERNANDEZ\\Downloads\\junio.dat");

        if (datosCSV != null) {

            System.out.println("    Se leyo archivo ");

            for (int fila = 0; fila < datosCSV[fila].length; fila++) {

                if (datosCSV[fila][0] != null) {
                    //Es la matriz 
                    for (int col = 0; col < datosCSV[col].length; col++) {
                        System.out.print(datosCSV[fila][col] + " ");

                    }

                    System.out.println();
                }

            }
            //Si hay un error te lanzara esto 
        } else {

            System.out.println("Error");
        }
        ArrayList<Trabajador> Trabajadores = new ArrayList();
        Object object = new Object();
        for (int i = 1; i < datosCSV.length; i++) {
            if (datosCSV[i][0] == null) {
                break;
            }//imprimiendo los datos de la matriz 
            System.out.println(datosCSV[0][0]);
            Trabajadores.add(new Trabajador(Integer.parseInt(datosCSV[i][0]),
                    datosCSV[i][1], datosCSV[i][2], datosCSV[i][3], Integer.parseInt(datosCSV[i][4]),
                    Double.parseDouble(datosCSV[i][5]), Integer.parseInt(datosCSV[i][6])));
            System.out.println(".........");
        }
        System.out.println("SALARIOS BASE");
        for (Trabajador item : Trabajadores) {
            System.out.println(item);
        }
        System.out.println("SALARIOS CON HORAS EXTRA ");
        for (Trabajador item : Trabajadores) {
            ((Trabajador) item).calcularsueldofinal();
            System.out.println(item);
        }
        Trabajador.calcularsueldobonus(Trabajadores);
        System.out.println("SALARIOS CON BONUS ");
        for (Trabajador item : Trabajadores) {
            System.out.println(item);
        }
    }

    private static String[][] deCSVaMatriz(String rutaCSV) {

        try {
            //Esto va ir recorriendo las filas 
            Scanner lector = new Scanner(new File(rutaCSV));
            String[][] matriz = new String[30][30];
            int fila = 0;

            String linea = lector.nextLine();
            while (lector.hasNextLine()) {

                if (matriz[fila].toString().endsWith(",")) {
                    fila++;
                } else {
                    matriz[fila] = linea.split(",");
                }
                //Suiente fila 
                fila++;
                linea = lector.nextLine();
            }

            matriz[fila] = linea.split(",");
            lector.close();
// se termina de leer el archivo 
            return matriz;
        } catch (FileNotFoundException e) {

            System.out.println("No se encuentra: " + rutaCSV);
            return null;

        }

    }

}
