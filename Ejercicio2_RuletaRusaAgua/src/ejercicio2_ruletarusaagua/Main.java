/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2_ruletarusaagua;

import Entidad.Juego;
import Entidad.Jugador;
import Entidad.RevolverAgua;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        RevolverAgua revolver = new RevolverAgua();
        Juego ruletaRusaAgua = new Juego();
        
        cargarJugadores(jugadores, 1);     
        
        ruletaRusaAgua.llenarJuego(jugadores, revolver);
        System.out.println("Inicia el juego !! ");
        Jugador jugadorPerdedor = ruletaRusaAgua.ronda();
        
        System.out.println("");
        System.out.println("---------JUGADOR MOJADO---------");
        System.out.println(jugadorPerdedor.toString());
        System.out.println("--------------------------------");
    }
    
    public static void cargarJugadores(ArrayList<Jugador> jugadores, Integer cantJugadores){
        for(int i=0 ; i<cantJugadores; i++){
            jugadores.add(new Jugador(i+1));
        }
    }
    
}
