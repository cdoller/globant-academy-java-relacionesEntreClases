package ejercicio3_cartas;

import Entidad.Baraja;
import Entidad.Carta;
import Entidad.Juego;
import Entidad.Jugador;
import Enum.TipoBaraja;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Baraja mazo = new Baraja(TipoBaraja.ESPANIOLA);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Carlos"));
        jugadores.add(new Jugador("Daniel"));

        Juego nuevoJuego = new Juego(jugadores, mazo);
        imprimirCartas(nuevoJuego.getMazo().mostrarBaraja());
        System.out.println("--");
        nuevoJuego.repartirCartas(3);
        System.out.println("Jugador 1:");
        imprimirCartas(nuevoJuego.getJugadores().get(0).verCartasMano());
        System.out.println("Jugador 2:");
        imprimirCartas(nuevoJuego.getJugadores().get(1).verCartasMano());
        System.out.println("-----");
        System.out.println("Jugador 1 ordenado:");
        System.out.println("Puntos: " + nuevoJuego.getJugadores().get(0).puntosEnvido());
        System.out.println("Check: " + nuevoJuego.getJugadores().get(0).getPuntosEnvido());
        System.out.println("-----");
        System.out.println("Jugador 2 ordenado:");
        System.out.println("Puntos: " + nuevoJuego.getJugadores().get(1).puntosEnvido());
        System.out.println("Check: " + nuevoJuego.getJugadores().get(1).getPuntosEnvido());
    }

    public static void imprimirCartas(ArrayList<Carta> cartas) {
        for (Carta carta : cartas) {
            System.out.print(carta.toString());
            System.out.println("");
        }
    }

}
