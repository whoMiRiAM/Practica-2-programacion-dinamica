
import org.example.Principal;
import org.junit.Test;


import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class MainTest {


    @Test
    public void testGetPaquetesConCeroPaquetes(){
        //cero paquetes en la entrada
        Scanner mockScanner = new Scanner("0\n");
        Principal.scanner = mockScanner;

        int[] packages = Principal.getPaquetes();

        //se verifica que la longitud del array es 1 (incluyendo el espacio vacio)
        assertEquals(1, packages.length);

        //se verifica que el primer elemento (vacío) es cero
        assertEquals(0, packages[0]);
    }

    /*
    @Test
    public void testGetPaquetesConPesoNormal(){
        //se simulan paquetes con peso normal
        String input = "3\n10\n20\n30\n"; //"3" indica el total de paquetes, seguido de tres pesos: 10, 20 y 30
        Scanner mockScanner = new Scanner(input);
        Principal.scanner = mockScanner;

        int[] packages = Principal.getPaquetes();

        //se verifica que el array tiene el número correcto de pesos introducidos
        assertEquals(4, packages.length); //el array debería tener tamaño 4 debido a la posición extra inicializada con 0

        //se verifica que cada peso corresponda con la entrada esperada
        assertEquals(String.valueOf(10), packages[1], "El primer paquete debe pesar 10");
        assertEquals(String.valueOf(20), packages[2], "El segundo paquete debe pesar 20");
        assertEquals(String.valueOf(30), packages[3], "El tercer paquete debe pesar 30");
    }

     */

    @Test
    public void testGetPaquetesConVariosPaquetes(){
        //se simula que hay varios paquetes con pesos
        Scanner mockScanner = new Scanner("3\n2\n5\n3\n");
        Principal.scanner = mockScanner;

        int[] packages = Principal.getPaquetes();

        //se verifica que la longitud del array es correcta (incluyendo el hueco vacío)
        assertEquals(4, packages.length);

        //se verifica que los pesos del paquete han sido correctamente guardados
        assertEquals(2, packages[1]);
        assertEquals(5, packages[2]);
        assertEquals(3, packages[3]);
    }

/*

    @Test
    public void testPDCapacidadPequena() {
        int[] packages = {2, 3, 4, 5};
        int capacity = 5;

        int expectedSolution = 7; //solución óptima con capacidad 5 y paquetes [2, 5]

        int actualSolution = Principal.pd(packages, capacity);

        assertEquals(expectedSolution, actualSolution);
    }

    @Test
    public void testPDCapacidadGrande() {
        int[] packages = {10, 20, 30, 40};
        int capacity = 60;

        int expectedSolution = 60; //solución óptima con capacidad 60 y todos los paquetes

        int actualSolution = Principal.pd(packages, capacity);

        assertEquals(expectedSolution, actualSolution);
    }

 */

    @Test
    public void testFinal(){
        //se proporcionan los datos en un string
        String input = "4\n5\n10\n7\n2\n3\n";

        //se simula que el usuario ha escrito en la consola usando el Scanner
        Scanner mockScanner = new Scanner(input);
        Principal.scanner = mockScanner;

        //se ejecuta el programa con la entrada de antes
        Principal.main(null);

        //se verifica que la salida se muestra por pantalla
    }


}
