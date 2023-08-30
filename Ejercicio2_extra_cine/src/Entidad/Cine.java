package Entidad;

import java.util.ArrayList;

public class Cine {

    private String nombre;
    private ArrayList<Sala> salas;
    private ArrayList<Pelicula> peliculas;

    public Cine(String nombre) {
        this.nombre = nombre;
        salas = new ArrayList<>();
        peliculas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public boolean comprarEntrada(int numeroSala, Espectador espectador) {
        Sala sala = salas.get(numeroSala - 1);
        espectador.setNuevo(false);
        
        if (espectador.getEdad() < sala.getPelicula().getEdadMinima()) {
            espectador.setObservacion("No posee la edad minima para comprar");
            return false;
        }

        if (espectador.getDineroDisponible() < sala.getPrecioEntrada()) {
            espectador.setObservacion("No tiene el dinero suficiente");
            return false;
        }

        Butaca butacaDisponible = sala.getButacaDisponible();
        if (butacaDisponible == null) {
            espectador.setObservacion("No habia butacas disponibles");
            return false;
        }

        butacaDisponible.setEspectador(espectador);
        espectador.setDineroDisponible(espectador.getDineroDisponible() - sala.getPrecioEntrada());
        espectador.setObservacion("Exito! pudo comprar su entrada");
        return true;
    }

}
