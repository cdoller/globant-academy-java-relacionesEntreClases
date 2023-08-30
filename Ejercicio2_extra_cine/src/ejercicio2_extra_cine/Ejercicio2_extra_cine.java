/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2_extra_cine;

import Servicio.ServicioCine;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Ejercicio2_extra_cine {

    private static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenidos al sistema de simulacion de cine");
        System.out.println("A continuacion se creara un cine y se le pedira la cantidad de espectadores para hacer la simulacion.");
        menuPrincipal();

    }

    public static void menuPrincipal() {
        ServicioCine servCine = new ServicioCine();
        boolean seguir = true;

        System.out.println("Ingrese la cantidad de espectadores:");
        System.out.print(">>>> ");
        int cantidadEspectadores = input.nextInt();
        delay(1000);
        System.out.println("Creando simulacion...");
        delay(1500);
        System.out.println("Fin simulacion!");
        delay(500);

        servCine.crearSimulacion("Cinemark Hoyts NuevoCentro", cantidadEspectadores);
        servCine.simularCompras();
        do {
            System.out.println("----- Menu Cine -----");
            System.out.println("1) Ver Salas");
            System.out.println("2) Ver Peliculas");
            System.out.println("3) Ver Detalle Sala");
            System.out.println("4) Ver Detalle Salas (Todas)");
            System.out.println("5) Ver Ocupacion Salas");
            System.out.println("6) Ver Espectadores (Rechazados)");
            System.out.println("7) Ver Espectadores (Todos)");
            System.out.println("8) Agregar mas espectadores");
            System.out.println("9) Salir");
            System.out.print(">>>>> ");
            int opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    servCine.imprimirSalas();
                    break;
                case 2:
                    servCine.imprimirPeliculas();
                    break;
                case 3:
                    System.out.println("Ingrese el numero de sala");
                    System.out.print(">>>>> ");
                    servCine.verDetalleCompletoSala(input.nextInt());
                    break;
                case 4:
                    System.out.println("---------------------");
                    servCine.verListadoDetalleCompletoSala();
                    break;
                case 5:
                    System.out.println("---------------------");
                    servCine.verOcupacionSalas();
                    break;
                case 6:
                    System.out.println("---------------------");
                    servCine.verEspectadoresRechazados();
                    break;
                case 7:
                    System.out.println("---------------------");
                    servCine.verEspectadores();
                    break;
                case 8:
                    System.out.println("---------------------");
                    System.out.println("Cuantos espectadores desea agregar?");
                    servCine.agregarEspectadores(input.nextInt());
                    break;
                case 9:
                    System.out.println("Gracias por usar el servicio del cine");
                    seguir = false;
                    break;
                default:
                    throw new AssertionError();
            }

        } while (seguir);

    }

    private static void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
