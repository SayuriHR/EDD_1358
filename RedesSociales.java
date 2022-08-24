package Ejerc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// Daira Sayuri Hernandez Rubio 

public class RedesSociales {

    public static void main(String[] args) {

        Scanner escritor = new Scanner(System.in);

        String[][] datosCSV = deCSVaMatriz("C:\\Users\\DENISSE HERNANDEZ\\Desktop\\presenciaredes.csv");
        if (datosCSV != null) { 
            System.out.println("Archivo leído");
            for (int fila = 0; fila < datosCSV[fila].length; fila++) {                
                if (datosCSV[fila][0] != null) { 
                    for (int col = 0; col < datosCSV[col].length; col++) {
                        System.out.print(datosCSV[fila][col] + " ");
                    }
                    System.out.println();
                }
            }

        } else {
            System.out.println("No se encuentran los datos de CSV.");
        }
        
        
        System.out.println("Diferencia de seguidores (followers) en Twitter entre el mes de enero y junio");
        System.out.println(Double.parseDouble(datosCSV[8][3]) - Double.parseDouble(datosCSV[8][8]));
        boolean MesBien = false;
        int MesFinal = 0;
        int MesInicio = 0;
        while (MesBien == false) {
            System.out.println("El mes de inicio debe ser menor al mes final");
            System.out.println("Elije el mes de inicio"); 
            MesInicio = escritor.nextInt();
            System.out.println("Elije el mes final");
            MesFinal = escritor.nextInt();
            if (MesFinal > MesInicio) {
                MesBien = true;
            } else {
                MesBien = false;

            }
        }
        MesFinal = MesFinal + 2;
        MesInicio += 2;
        System.out.println("Diferencia de visualizaciones de YOUTUBE "
                + "entre el mes de " + datosCSV[0][MesInicio]
                + " y el mes de " + datosCSV[0][MesFinal]);

        System.out.println(Math.abs(Double.parseDouble(datosCSV[16][MesInicio]) - Double.parseDouble(datosCSV[16][MesFinal])));

        System.out.println("Calculando promedio de crecimiento de Facebook");
        for (int col = 3; col < 9; col++) {
            datosCSV[3][col] = datosCSV[3][col].substring(0, datosCSV[3][col].length() - 1);
        }
        double suma = 0;
        double valor1;
        for (int col = 3; col < 9; col++) {
            valor1 = Double.parseDouble(datosCSV[3][col]);
            suma = valor1 + suma;
        }
        System.out.println("Promedio de crecimiento en FACEBOOK es de:");
        double promediofacebook = suma / 6;
        System.out.println(promediofacebook + "%");

        System.out.println("Calculando promedio de crecimiento de TWITTER");
        for (int col = 3; col < 9; col++) {
            datosCSV[10][col] = datosCSV[10][col].substring(0, datosCSV[10][col].length() - 1);
        }
        suma = 0;
        for (int col = 3; col < 9; col++) {
            valor1 = Double.parseDouble(datosCSV[10][col]);
            suma = valor1 + suma;
        }
        System.out.println("Promedio de crecimiento en TWITTER es de:");
        double promediotw = suma / 6;
        System.out.println(promediotw + "%");

    }

    private static String[][] deCSVaMatriz(String rutaCSV) {
        try {
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
                fila++; 
                linea = lector.nextLine();
            }
            matriz[fila] = linea.split(",");
            lector.close();
            return matriz;
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra: " + rutaCSV);
            return null;
        }
    }
}
