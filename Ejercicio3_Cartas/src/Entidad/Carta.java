package Entidad;

import Enum.Palos;

public class Carta {

    private int numero;
    private Palos palo;

    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }

}
