/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego{
    ArrayList<Jugador> jugadores;
    RevolverAgua revolver;
    
    public Juego(){
        jugadores = new ArrayList<>();
        revolver = new RevolverAgua();
    }
    
    public void llenarJuego(ArrayList<Jugador> jugadores, RevolverAgua revolver){
        this.jugadores = jugadores;
        this.revolver = revolver;
        revolver.cargarRevolver();
    }
    
    public Jugador ronda(){
        Scanner gatillar = new Scanner(System.in).useDelimiter("\n");
        //System.out.println(revolver.toString());
        while(true)
            for (Jugador jugador : jugadores) {
                System.out.println("--------------------------------");
                System.out.println("Turno " + jugador.getNombre());
                System.out.print("DISPARAR >>>>>> ");
                gatillar.next();
                if (jugador.disparo(revolver)) {
                    System.out.println("Te mojaste :'( , a dormir la siesta");
                    return jugador;
                }
                System.out.println("Ufff estuvo cerca...");
            }
    }
}
