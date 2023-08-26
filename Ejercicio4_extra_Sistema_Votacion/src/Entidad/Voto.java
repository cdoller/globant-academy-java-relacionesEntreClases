package Entidad;

import java.util.ArrayList;

/**
 * Es el voto emitido, almacena la lista de los elementos votados
 * @author User
 */
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
