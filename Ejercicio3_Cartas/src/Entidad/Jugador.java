package Entidad;

import Enum.Palos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Jugador {

    private String nombre;
    private ArrayList<Carta> cartas;
    private Integer puntosEnvido;

    public Jugador(String nombre) {
        this.nombre = nombre;
        cartas = new ArrayList<>();
    }

    public Integer getPuntosEnvido() {
        return puntosEnvido;
    }

    public void setPuntosEnvido(Integer puntosEnvido) {
        this.puntosEnvido = puntosEnvido;
    }

    public void agregarCartasMano(ArrayList<Carta> cartas) {
        this.cartas.addAll(cartas);
    }

    public ArrayList<Carta> verCartasMano() {
        return cartas;
    }

    public int puntosEnvido() {
        Collections.sort(cartas, compararPorPalo);
        System.out.println(cartas);
        int[] puntos = new int[4];
        int[] cantPalo = new int[4];

        for (Carta aux : cartas) {
            int numero = aux.getNumero();
            int paloIndex = aux.getPalo().ordinal();
            cantPalo[paloIndex]++;
            if (numero <= 7) {
                puntos[paloIndex] += numero;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (cantPalo[i] > 1) {
                puntos[i] += 20;
            }
        }
        Arrays.sort(puntos);
        setPuntosEnvido(puntos[3]);
        return puntos[3];
    }

    // COMPARATORS
    public static Comparator<Carta> compararPorPalo = (Carta p, Carta p1)
            -> p.getPalo().compareTo(p1.getPalo());

}
