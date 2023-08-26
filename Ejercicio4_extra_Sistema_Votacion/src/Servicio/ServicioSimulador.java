package Servicio;

import Entidad.Alumno;
import Entidad.Simulador;
import java.util.ArrayList;
import java.util.Collections;

public class ServicioSimulador {

    private ArrayList<Alumno> alumnos;
    private Simulador simulacion;
    private int cantidadAlumnos;
    private int cantidadFacilitadores;
    private int votosPorAlumno;

    public ServicioSimulador(int cantidadAlumnos, int cantidadFacilitadores, int votosPorAlumno) {
        alumnos = new ArrayList<>();
        this.cantidadAlumnos = cantidadAlumnos;
        this.cantidadFacilitadores = cantidadFacilitadores;
        this.votosPorAlumno = votosPorAlumno;
        simulacion = new Simulador(cantidadAlumnos, votosPorAlumno);
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public int getCantidadFacilitadores() {
        return cantidadFacilitadores;
    }

    public int getVotosPorAlumno() {
        return votosPorAlumno;
    }

    /**
     * Arranca la simulacion, es el primer metodo que debe ejecutarse.
     */
    public void arrancarSimulacion() {
        alumnos = simulacion.generarAlumnos(simulacion.generarListaNombres(), simulacion.generarListaDni());
        simulacion.votacion(alumnos);
        setearFacilitadores();
    }

    /**
     * Setea a los alumnos mas votados como facilitadores.
     * cantidadFacilitadoresTitulares = cantidadFacilitadores/2
     * cantidadFacilitadoresSuplentes = cantidadFacilitadores/2
     */
    public void setearFacilitadores() {
        Collections.sort(alumnos, Alumno.compararVotos.reversed());

        for (int i = 0; i < cantidadFacilitadores / 2; i++) {
            alumnos.get(i).setFacilitadorTitular(true);
        }

        for (int i = cantidadFacilitadores / 2; i < cantidadFacilitadores; i++) {
            alumnos.get(i).setFacilitadorSuplente(true);
        }
    }

    /**
     * Imprime el listado completo de los alumnos con su nombre y dni
     */
    public void imprimirAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombreCompleto() + " " + alumno.getDni());
        }
        System.out.println("-------------");
    }

    /**
     * Ordena los alumnos por su cantidad de votos y los imprime por pantalla.
     */
    public void mostrarResultadoVotacion() {
        Collections.sort(alumnos, Alumno.compararVotos.reversed());
        System.out.println("Votos Recibidos - Nombre - Dni");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getCantidadVotos() + " - " + alumno.getNombreCompleto() + " - " + alumno.getDni());
        }
        System.out.println("------------");
    }

    /**
     * Muestra el detalle de la votacion. Se imprime a cada alumno con su
     * cantidad de votos recibidos y sus votos emitidos.
     *
     */
    public void mostrarDetalleVotacion() {
        for (Alumno alumno : alumnos) {
            System.out.println("Votos recibidos: " + alumno.getCantidadVotos() + " - " + alumno.getNombreCompleto() + ":");

            ArrayList<Alumno> listaAlumnosVotados = alumno.getVoto().getListaVotos();
            for (Alumno alumnoVotado : listaAlumnosVotados) {
                System.out.println(alumnoVotado.getDni().toString() + "-" + alumnoVotado.getNombreCompleto());
            }
            System.out.println("------------");
        }
    }

    /**
     * Muestra por pantalla los alumnos que son facilitadores titulares y
     * suplentes.
     */
    public void mostrarFacilitadores() {
        for (Alumno alumno : alumnos) {
            if (alumno.isFacilitadorTitular()) {
                System.out.println("Titular: " + alumno.getNombreCompleto() + " - " + alumno.getDni());
            }

            if (alumno.isFacilitadorSuplente()) {
                System.out.println("Suplente: " + alumno.getNombreCompleto() + " - " + alumno.getDni());
            }
        }
    }

    /**
     * Suma los votos recibidos de todos los alumnos
     *
     * @return la suma de todos los votos recibidos por los alumnos
     */
    public int contarVotosTotales() {
        int totalVotos = 0;
        for (Alumno alumno : alumnos) {
            totalVotos += alumno.getCantidadVotos();
        }
        return totalVotos;
    }

}
