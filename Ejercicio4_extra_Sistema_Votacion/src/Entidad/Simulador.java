package Entidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * Simula una votacion entre alumnos
 * @author Carlos Oller
 */
public class Simulador {

    private int cantidadAlumnos;
    private int votosPorAlumno;

    public Simulador(int cantidadAlumnos, int votosPorAlumno) {
        this.cantidadAlumnos = cantidadAlumnos;
        this.votosPorAlumno = votosPorAlumno;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    /**
     * Genera una lista aleatoria de nombres de longitud cantidadAlumnos
     * 
     * @return la lista de nombres completos aleatoria
     */
    public ArrayList<String> generarListaNombres() {
        Random random = new Random();
        ArrayList<String> listaNombres = new ArrayList<>(Arrays.asList("Manolo", "Nikita", "Takeshi", "Vladimir", "Martha", "Aristoteles", "Hypatia", "Deborah", "Kim"));
        ArrayList<String> listaApellidos = new ArrayList<>(Arrays.asList("Putin", "Nakamura", "Jimenez", "Mussolini", "Khan", "Hotpants", "Coldpants", "Solis", "Zheng"));
        ArrayList<String> nombresAlumnos = new ArrayList<>();
        String nombre = "";
        String apellido = "";

        while (nombresAlumnos.size() < cantidadAlumnos) {
            nombre = listaNombres.get(random.nextInt(listaNombres.size()));
            apellido = listaApellidos.get(random.nextInt(listaApellidos.size()));
            nombresAlumnos.add(nombre + " " + apellido);
        }

        return nombresAlumnos;
    }

    /**
     * Genera un HashSet con dni aleatorios, los cuales deben ser unicos La
     * cantidad de elementos del HashSet debe ser cantidadAlumnos
     * 
     * @return dnis unicos que no se pueden repetir
     */
    public HashSet<Dni> generarListaDni() {
        HashSet<Dni> dnis = new HashSet<>();
        Random random = new Random();
        String posiblesTiposDni = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int numerosPosiblesDni = 99_999_999;
        int posicionRandomTipo = 0;

        String tipoSeleccionado = "";
        int numeroDni = 0;

        while (dnis.size() != cantidadAlumnos) {
            posicionRandomTipo = random.nextInt(posiblesTiposDni.length());
            tipoSeleccionado = posiblesTiposDni.substring(posicionRandomTipo, posicionRandomTipo + 1);
            numeroDni = random.nextInt(numerosPosiblesDni) + 1;

            dnis.add(new Dni(numeroDni, tipoSeleccionado));
        }

        return dnis;
    }

    /**
     * Genera cantidadAlumnos de Alumnos
     * 
     * @param nombres los nombres aleatorios
     * @param dnis los dnis aleatorios
     * @return un listado de Alumnos con un nombre y dni aleatorio
     */
    public ArrayList<Alumno> generarAlumnos(ArrayList<String> nombres, HashSet<Dni> dnis) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Iterator it = dnis.iterator();
        int indice = 0;
        String nombre = "";
        while (it.hasNext()) {
            nombre = nombres.get(indice);
            alumnos.add(new Alumno(nombre, (Dni) it.next()));
            indice++;
        }
        return alumnos;
    }

    /**
     * Recibe el listado de alumnos y para cada alumno genera tres votos de
     * manera aleatoria. debemos guardar a los alumnos a los que votó y sumarle
     * uno a la cantidad de votos a cada alumno que reciba un voto Tener en
     * cuenta que un alumno no puede votarse a sí mismo o votar más de una vez
     * al mismo alumno.
     * 
     * @param alumnos
     */
    public void votacion(ArrayList<Alumno> alumnos) {
        Random random = new Random();
        HashSet<Alumno> alumnosElegidos = new HashSet<>();

        for (Alumno alumno : alumnos) {
            Voto voto = new Voto();
            
            while (alumnosElegidos.size() != votosPorAlumno) {
                int indiceAleatorio = random.nextInt(alumnos.size());
                Alumno alumnoAleatorio = alumnos.get(indiceAleatorio);

                if (alumnoAleatorio.equals(alumno) || alumnosElegidos.contains(alumnoAleatorio)) {
                    continue;
                }

                alumnosElegidos.add(alumnoAleatorio);
                alumnoAleatorio.sumarVoto();
            }
            
            voto.setListaVotos(new ArrayList<>(alumnosElegidos));
            alumno.setVoto(voto);
            alumno.setHaVotado(true);
            alumnosElegidos.clear();
        }
    }
}
