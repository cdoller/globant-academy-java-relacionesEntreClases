package Entidad;

import java.util.ArrayList;

public class Voto {

    private ArrayList<Alumno> listaVotos;

    public Voto() {
        listaVotos = new ArrayList<>();
    }

    public ArrayList<Alumno> getListaVotos() {
        return listaVotos;
    }

    public void setListaVotos(ArrayList<Alumno> listaVotos) {
        this.listaVotos = listaVotos;
    }

    @Override
    public String toString() {
        return "Voto{" + "listaVotos=" + listaVotos + '}';
    }

}
