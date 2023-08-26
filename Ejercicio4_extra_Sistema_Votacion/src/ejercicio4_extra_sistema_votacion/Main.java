package ejercicio4_extra_sistema_votacion;

import Entidad.Alumno;
import Servicio.ServicioSimulador;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        
        ServicioSimulador servSimulador = new ServicioSimulador();
        int cantidadAlumnos = 50;
        servSimulador.crearSimulacion(cantidadAlumnos);
        servSimulador.arrancarSimulacion();
        servSimulador.setearFacilitadores();
        
        TreeSet<Alumno> votacion = servSimulador.getResultadoVotacion();
        System.out.println(votacion.size() + " -> cantidad alumnos");
        System.out.println("Deberian haber " + cantidadAlumnos*3 + " votos en total");
        
        int sumaVotos = 0;
        for(Alumno alumno : servSimulador.getResultadoVotacion()){
            System.out.println(alumno.getCantidadVotos() + " votos - " + alumno.getNombreCompleto());
            sumaVotos += alumno.getCantidadVotos();
        }
        System.out.println("Se contabilizaron " + sumaVotos + " votos");
    }
}
