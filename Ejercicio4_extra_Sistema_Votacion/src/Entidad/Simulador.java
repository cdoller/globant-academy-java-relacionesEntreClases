package Entidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Simulador {

    private int cantidadAlumnos;

    public Simulador(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    /**
     * Genera una lista aleatoria de nombres de longitud cantidadAlumnos
     *
     * @return
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
     * @return
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
     * @param nombres
     * @param dnis
     * @return
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
     * Devuelve el listado completo de los alumnos
     *
     */
    public void imprimirAlumnos(ArrayList<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombreCompleto());
            System.out.println(alumno.getDni().toString());
            System.out.println("-------------");
        }
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
        HashSet<Alumno> alumnosHash = new HashSet<>();

        for (Alumno alumno : alumnos) {
            Voto voto = new Voto();
            HashSet<Alumno> alumnosElegidos = new HashSet<>();
            // generamos votos
            while (alumnosElegidos.size() != 3) {
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
        }
    }

    /**
     * Se debe crear un método que muestre a cada Alumno con su cantidad de
     * votos y cuales fueron sus 3 votos.
     *
     * @param alumnos
     */
    public void mostrarDetalleVotacion(ArrayList<Alumno> alumnos) {
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
     * Se debe crear un método que haga el recuento de votos, este recibe la
     * lista de Alumnos y comienza a hacer el recuento de votos.
     *
     * @param alumnos
     * @return el resultado de la votacion, un TreeMap con el listado de alumnos
     * ordenados por votos recibidos
     */
    public TreeSet<Alumno> recuentoVotos(ArrayList<Alumno> alumnos) {
        TreeSet<Alumno> resultadoVotacion = new TreeSet<>((a1, a2) -> {
            int comparacionPorVotos = Integer.compare(a2.getCantidadVotos(), a1.getCantidadVotos());
            if (comparacionPorVotos != 0) {
                // Si la cantidad de votos es diferente, usa esa comparación
                return comparacionPorVotos;
            } else {
                // Si la cantidad de votos es la misma, usa el nombre como desempate
                return Integer.compare(a2.getDni().getNumero(), a1.getDni().getNumero());
            }
        });
        resultadoVotacion.addAll(alumnos);
        return resultadoVotacion;
    }
}
