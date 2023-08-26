package Servicio;

import Entidad.Alumno;
import Entidad.Simulador;
import java.util.ArrayList;
import java.util.TreeSet;

public class ServicioSimulador {

    private static int cantidadFacilitadores = 10;

    private ArrayList<Alumno> alumnos;
    private TreeSet<Alumno> resultadoVotacion;
    private ArrayList<Alumno> facilitadoresTitulares;
    private ArrayList<Alumno> facilitadoresSuplentes;
    private Simulador simulacion;

    public ServicioSimulador() {
        alumnos = new ArrayList<>();
        facilitadoresTitulares = new ArrayList<>();
        facilitadoresSuplentes = new ArrayList<>();
        resultadoVotacion = new TreeSet<>();
    }

    public void crearSimulacion(int cantidadAlumnos) {
        simulacion = new Simulador(cantidadAlumnos);
    }

    public void arrancarSimulacion() {
        alumnos = simulacion.generarAlumnos(simulacion.generarListaNombres(), simulacion.generarListaDni());
        simulacion.imprimirAlumnos(alumnos);
        simulacion.votacion(alumnos);
        simulacion.mostrarDetalleVotacion(alumnos);
        resultadoVotacion = simulacion.recuentoVotos(alumnos);
    }

    /**
     * Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se
     * deben crear 5 facilitadores suplentes con los 5 segundos alumnos más
     * votados. A continuación, mostrar los 5 facilitadores y los 5
     * facilitadores suplentes.
     *
     * @param facilitadores
     */
    public void setearFacilitadores() {
        int contador = 0;
        for (Alumno alumno : resultadoVotacion) {
            if (contador < 5) {
                facilitadoresTitulares.add(alumno);
            }
            if (contador > 5 && contador < 10) {
                facilitadoresSuplentes.add(alumno);
            }
            contador++;
            if (contador == 10) {
                break;
            }
        }
    }

    public ArrayList<Alumno> getFacilitadoresTitulares() {
        return facilitadoresTitulares;
    }

    public ArrayList<Alumno> getFacilitadoresSuplentes() {
        return facilitadoresSuplentes;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public TreeSet<Alumno> getResultadoVotacion() {
        return resultadoVotacion;
    }

}
