package Entidad;

import java.util.Comparator;
import java.util.Objects;

public class Alumno {

    private String nombreCompleto;
    private Dni dni;
    private int cantidadVotos;
    private Voto voto;
    private boolean haVotado;

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

    /**
     * Suma un voto a cantidad de votos
     */
    public void sumarVoto() {
        cantidadVotos++;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombreCompleto=" + nombreCompleto + ", dni=" + dni + '}';
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
    

}
