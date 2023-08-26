package Entidad;

import java.util.Comparator;
import java.util.Objects;

/**
 * Simula un alumno que puede votar, recibir votos y ser facilitador
 * @author User
 */
public class Alumno {

    private String nombreCompleto;
    private Dni dni;
    private int cantidadVotos;
    private Voto voto;
    private boolean haVotado;
    private boolean facilitadorTitular;
    private boolean facilitadorSuplente;

    /**
     *
     * @param nombreCompleto
     * @param dni
     */
    public Alumno(String nombreCompleto, Dni dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        cantidadVotos = 0;
        haVotado = false;
        facilitadorTitular = false;
        facilitadorSuplente = false;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Dni getDni() {
        return dni;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public Voto getVoto() {
        return voto;
    }

    public boolean isHaVotado() {
        return haVotado;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public void setHaVotado(boolean haVotado) {
        this.haVotado = haVotado;
    }

    public boolean isFacilitadorTitular() {
        return facilitadorTitular;
    }

    public void setFacilitadorTitular(boolean facilitadorTitular) {
        this.facilitadorTitular = facilitadorTitular;
    }

    public boolean isFacilitadorSuplente() {
        return facilitadorSuplente;
    }

    public void setFacilitadorSuplente(boolean facilitadorSuplente) {
        this.facilitadorSuplente = facilitadorSuplente;
    }

    
    

    /**
     * Suma un voto a cantidad de votos
     */
    public void sumarVoto() {
        cantidadVotos++;
    }

    @Override
    public String toString() {
        String salida = "";
        if(facilitadorTitular){
            salida += "Titular: ";
        }
        if(facilitadorSuplente){
            salida += "Suplente: ";
        }
        salida += nombreCompleto + "-" + dni + " - (" + cantidadVotos + ")votos";
        return salida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    public static Comparator<Alumno> compararVotos = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno a1, Alumno a2) {
            return Integer.compare(a1.getCantidadVotos(), a2.getCantidadVotos());
        }
    };

}
