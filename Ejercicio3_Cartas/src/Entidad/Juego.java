package Entidad;

import java.util.ArrayList;

public class Juego {

    private ArrayList<Jugador> jugadores;
    private Baraja mazo;
    private ArrayList<Carta> cartasMesa;
    private int numeroRonda;

    public Juego(ArrayList<Jugador> jugadores, Baraja mazo) {
        this.jugadores = jugadores;
        this.mazo = mazo;
        cartasMesa = new ArrayList<>();
        mazo.barajar();
        numeroRonda = 0;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Baraja getMazo() {
        return mazo;
    }

    public void repartirCartas(int cantidad) {
        for (Jugador jugador : jugadores) {
            ArrayList<Carta> cartas = mazo.darCartas(cantidad);
            if (cartas == null) {
                System.out.println("No hay esa cantidad de cartas");
                return;
            }
            jugador.agregarCartasMano(cartas);
            jugador.puntosEnvido();
            numeroRonda++;
        }
    }
    

}
