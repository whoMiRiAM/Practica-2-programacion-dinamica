package org.example;

import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Principal {

    private static final Logger logger = LogManager.getLogger(Principal.class);
    public static Scanner scanner = new Scanner(System.in);
    private final static int CAPACIDAD = 40;
    private final static int PAGO = 6;

    public static int[] getPaquetes(){
        logger.info("Solicitando el total de paquetes");
        System.out.println("Total paquetes: ");
        int[] v = new int[scanner.nextInt() + 1]; //incluyendo la fila vacía

        v[0] = 0; //dejamos la posicion 0 con el valor 0 para el vacío

        for(int i = 1; i < v.length; i++){
            System.out.println("Peso: ");
            v[i] = scanner.nextInt();
        }
        logger.debug("Paquetes cargados: {}", (Object) v);
        return v;
    }

    public static void main(String[] args) {

        logger.info("Iniciando el programa");
        int c = CAPACIDAD;
        int[] v = getPaquetes();

        pd(v,c); //pd es programación dinámica
        logger.info("Programa finalizado");

    }//MAIN

    public static void pd(int[] v, int C){

        logger.debug("Iniciando cálculo de programación dinámica");

        //todo 3: incluir este proyecto en el anterior de github, es decir, pegarle esta clase a la carpeta de la otra
        //y llamarle al anterior voraz, por ejemplo, y este, dinámico, por ejemplo

        int f = v.length; //filas
        int c = C + 1; //COLUMNA para camión sin capacidad (el camión sin capacidad hay que ponerlo, por eso el +1)

        int[][] T = new int[f][c];

        //HACER TABLA
        for(int i = 0; i < f; i++){
            for(int j = 0; j < c; j++){
                if(i == 0 || j == 0){
                    T[i][j] = 0;
                }
                else if(v[i] > j){
                    T[i][j] = T[i - 1][j];
                }else if(T[i - 1][j] >= v[i] + T[i - 1][j - v[i]]){ //si no coger el objeto actual me da mejores resultado que cogerlo
                    T[i][j] = T[i - 1][j];
                }else{ //si cogerlo me genera mejores resultados
                    T[i][j] = v[i] + T[i - 1][j - v[i]];
                }
            }
        }

        // IMPRIMIR TABLA
        System.out.print("\t\t|\t");
        for (int j = 0; j < c; j++){
            System.out.print(j + "\t");
        }
        System.out.println("\n-----------------------------------------------");
        for (int i = 0; i < f; i++){
            System.out.print("Peso " + v[i] + "\t|\t");
            for (int j = 0; j < c; j++){
                System.out.print(T[i][j] + "\t");
            }
            System.out.println("\n");
        }

        // MOSTRAR SOLUCION
        int i, j, pesoT;

        pesoT = T[f - 1][c - 1];
        System.out.println("Capacidad maxima del camion: " + pesoT);
        System.out.println("Mercancias utilizadas: ");
        i = f - 1;
        j = c - 1;
        while (i > 0 && j > 0) {
            if (T[i][j] != T[i - 1][j]) {
                System.out.print("[" + v[i] + "]");
                j -= v[i];
            }
            i--;
        }
        System.out.println("");
        System.out.println("Factura: " + pesoT * PAGO);
        logger.debug("Tabla de programación dinámica completada");

    }
}

