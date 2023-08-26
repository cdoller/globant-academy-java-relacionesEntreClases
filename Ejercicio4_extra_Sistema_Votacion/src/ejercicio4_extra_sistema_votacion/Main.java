package ejercicio4_extra_sistema_votacion;

import Servicio.ServicioSimulador;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        ServicioSimulador sv;
        int cantidadAlumnos = 0, cantidadFacilitadores = 0, votosPorAlumno = 0;

        System.out.println("-------------------------------------");
        System.out.println("Bienvenido al Simulador de Votaciones");
        System.out.println("-------------------------------------");

        System.out.println("Ingrese la cantidad de alumnos:");
        System.out.print(">> ");
        cantidadAlumnos = input.nextInt();
        System.out.println("Ingrese la cantidad de facilitadores:");
        System.out.print(">> ");
        cantidadFacilitadores = input.nextInt();
        System.out.println("Ingrese la cantidad de votos que puede hacer cada alumno:");
        System.out.print(">> ");
        votosPorAlumno = input.nextInt();

        sv = new ServicioSimulador(cantidadAlumnos, cantidadFacilitadores, votosPorAlumno);
        sv.arrancarSimulacion();

        System.out.println(".... Procesando simulacion");
        delay(3000);
        System.out.println(".... Fin simulacion");
        delay(500);
        System.out.println("-------------------------------------");
        
        menu(sv);
    }

    public static void menu(ServicioSimulador sv) {
        boolean seguir = true;
        do {
            int opcion = 0;
            System.out.println("-------------------------------------");
            System.out.println("1) Ver listado alumnos");
            System.out.println("2) Ver resultado votacion");
            System.out.println("3) Ver detalle votacion");
            System.out.println("4) Ver facilitadores");
            System.out.println("5) VALIDAR resultado votacion");
            System.out.println("");
            System.out.println("9) Salir");
            System.out.println("-------------------------------------");
            System.out.print(">> ");
            opcion = input.nextInt();
            System.out.println("-------------------------------------");

            switch (opcion) {
                case 1:
                    sv.imprimirAlumnos();
                    break;
                case 2:
                    sv.mostrarResultadoVotacion();
                    break;
                case 3:
                    sv.mostrarDetalleVotacion();
                    break;
                case 4:
                    sv.mostrarFacilitadores();
                    break;
                case 5:
                    System.out.println("Hubo " + sv.getCantidadAlumnos() + " alumnos");
                    System.out.println("Deberia haber " + sv.getCantidadAlumnos() * sv.getVotosPorAlumno() + " votos");
                    System.out.println("... Contabilizando");
                    delay(1500);
                    System.out.println("Hubo " + sv.contarVotosTotales() + " votos en total");
                    break;
                case 9:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opcion NO valida");
            }
        } while (seguir);

        System.out.println("Fin, gracias por usar el simulador de votacion");
    }

    private static void delay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
