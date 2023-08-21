package Entidad;

import Enum.Palos;
import Enum.TipoBaraja;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    private ArrayList<Carta> mazo;
    private ArrayList<Carta> monton;

    public Baraja(TipoBaraja tipo) {
        mazo = new ArrayList<>();
        monton = new ArrayList<>();
        switch (tipo) {
            case ESPANIOLA:
                nuevaBarajaEspaniola();
                break;
        }
    }

    public void nuevaBarajaEspaniola() {
        for (Palos palo : Palos.values()) {
            for (int i = 1; i <= 12; i++) {
                if (i == 8 || i == 9) {
                    continue;
                }
                mazo.add(new Carta(i, palo));
            }
        }
    }

    public ArrayList<Carta> mostrarBaraja() {
        return mazo;
    }

    public void barajar() {
        Collections.shuffle(mazo);
    }

    public Carta siguienteCarta() {
        if (mazo.isEmpty()) {
            System.out.println("No hay mas cartas en el mazo");
            return null;
        }
        Carta siguienteCarta = mazo.get(0);
        mazo.remove(0);
        return siguienteCarta;
    }

    public Integer cartasDisponibles() {
        return mazo.size();
    }

    public ArrayList<Carta> darCartas(int cantidad) {
        if (cantidad > cartasDisponibles()) {
            System.out.println("No hay " + cantidad + " cartas disponibles");
            return null;
        }
        ArrayList<Carta> cartas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            cartas.add(siguienteCarta());
        }
        return cartas;
    }
    
    public void agregarAlMonton(Carta carta){
        monton.add(carta);
    }
    
    public void agregarAlMonton(ArrayList<Carta> cartas){
        for (Carta carta : cartas) {
            monton.add(carta);
        }
    }
    
    public ArrayList<Carta> cartasMonton(){
        return monton;
    }
    
}
