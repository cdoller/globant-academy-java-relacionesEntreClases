package Entidad;

import java.util.ArrayList;

public class Sala {

    private String nombre;
    private int numeroSala;
    private Pelicula pelicula;
    private ArrayList<Butaca> butacas;
    int maximoFilas;
    int maximoColumnas;
    double precioEntrada;

    public Sala(String nombre, int numeroSala, int maximoFilas, int maximoColumnas, double precioEntrada, Pelicula pelicula) {
        this.nombre = nombre;
        this.numeroSala = numeroSala;
        this.maximoFilas = maximoFilas;
        this.maximoColumnas = maximoColumnas;
        this.precioEntrada = precioEntrada;
        this.pelicula = pelicula;
        butacas = new ArrayList<>();
        crearButacas(maximoFilas, maximoColumnas);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public int getMaximoFilas() {
        return maximoFilas;
    }

    public int getMaximoColumnas() {
        return maximoColumnas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public Butaca getButacaDisponible() {
        if (isSalaLlena()) {
            System.out.println("La sala esta llena no puede comprar entrada");
            return null;
        }
        do {
            Butaca butaca = butacas.get((int) (Math.random() * butacas.size()));
            if (!butaca.ocupada) {
                return butaca;
            }
        } while (true);
    }

    public boolean isSalaLlena() {
        for (Butaca butaca : butacas) {
            if (!butaca.ocupada) {
                return false;
            }
        }
        return true;
    }

    public int ocupacionSala() {
        int cantidadOcupadas = 0;
        for (Butaca butaca : butacas) {
            if (butaca.ocupada) {
                cantidadOcupadas++;
            }
        }
        return cantidadOcupadas;
    }

    private void crearButacas(int maximoFilas, int maximoColumnas) {
        for (int i = 0; i < maximoFilas; i++) {
            String fila = String.valueOf((char) ('A' + i));
            for (int j = 0; j < maximoColumnas; j++) {
                butacas.add(new Butaca(fila, j + 1));
            }
        }
    }
    
    public String informacionSala(){
        return nombre + " " + numeroSala + " - Precio entrada: $" + precioEntrada + 
                " - Capacidad Maxima: " + maximoFilas*maximoColumnas + " espectadores" + "\n" +
                "Pelicula: " + pelicula.getTitulo();
    }

    @Override
    public String toString() {
        String sala = nombre + " " + numeroSala + " - Precio entrada: $" + precioEntrada + 
                        " - Capacidad Maxima: " + maximoFilas*maximoColumnas + " espectadores" +
                        "\n" + pelicula + "\n\n";
        for (Butaca butaca : butacas) {
            sala += butaca;
            if (butaca.getColumna() == maximoColumnas) {
                sala += "\n";
            }
        }

        return sala;
    }

}
