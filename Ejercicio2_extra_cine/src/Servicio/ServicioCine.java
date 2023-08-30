package Servicio;

import Entidad.Cine;
import Entidad.Espectador;
import Entidad.Pelicula;
import Entidad.Sala;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Clase que se encarga de hacer la simulacion, crear las peliculas, las salas y
 * cargar la cantidad de espectadores.
 *
 * @author Carlos Oller
 */
public class ServicioCine {

    Cine cine;
    ArrayList<Espectador> espectadores;
    ArrayList<Espectador> espectadoresRechazados;
    ArrayList<Pelicula> peliculas;

    /**
     * Creamos un servicio cine, pero no iniciamos la simulacion
     */
    public ServicioCine() {
        espectadores = new ArrayList<>();
        espectadoresRechazados = new ArrayList<>();
        peliculas = new ArrayList<>();
    }

    /**
     * Inicia la simulacion
     *
     * @param nombreCine es a modo ilustrativo unicamente
     * @param cantidadEspectadores la cantidad de espectadores de la simulacion
     */
    public void crearSimulacion(String nombreCine, int cantidadEspectadores) {
        cine = new Cine(nombreCine);
        crearEspectadoresAleatorios(cantidadEspectadores);
        crearPeliculas();
        crearSalas();
    }

    /**
     * Crea una sala para cada pelicula, vamos a tener misma cantidad salas que
     * de peliculas El maximo de filas se encuentra entre [5 y 15] El maximo de
     * columnas es entre [6 y 10] El precio de la entrada es el numero de la
     * sala * 100 La pelicula es una aleatoria del listado, no se pueden repetir
     * entre salas
     */
    public void crearSalas() {
        Pelicula pelicula;
        int numeroSala = 1, maximoFilas = 0, maximoColumnas = 0;
        double precioEntrada = 0.0;
        ArrayList<Sala> salas = new ArrayList<>();
        for (int i = 0; i < peliculas.size(); i++) {
            numeroSala = i + 1;
            maximoFilas = (int) (Math.random() * 11 + 5);
            maximoColumnas = (int) (Math.random() * 5 + 6);
            precioEntrada = numeroSala * 100.0;
            Collections.shuffle(peliculas);
            pelicula = peliculas.get(i);
            salas.add(new Sala("Sala", numeroSala, maximoFilas, maximoColumnas, precioEntrada, pelicula));
        }
        cine.setSalas(salas);
    }

    /**
     * Crea 5 peliculas para hacer la simulacion, no necesita ninguna
     * informacion adicional
     */
    public void crearPeliculas() {
        peliculas.add(new Pelicula("Gran Turismo: De jugador a corredor", 134, "Neill Blomkamp", 13));
        peliculas.add(new Pelicula("Tortugas Ninja: Caos mutante", 100, "Jeff Rowe, Kyler Spears", 0));
        peliculas.add(new Pelicula("Asteroid City", 104, "Wes Anderson", 13));
        peliculas.add(new Pelicula("Oppenheimer", 180, "Christopher Nolan", 13));
        peliculas.add(new Pelicula("Barbie", 114, "Greta Gerwig", 0));
    }

    /**
     * Imprime el listado completo de las peliculas
     */
    public void imprimirPeliculas() {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.toString());
            System.out.println("------------------------------------------------------");
        }
    }

    /**
     * Imprime en pantalla el listado de las salas con sus detalles
     */
    public void verListadoDetalleCompletoSala() {
        for (Sala sala : cine.getSalas()) {
            System.out.println(sala.toString());
            System.out.println("------------------------------------------------------");
        }
    }

    /**
     * Imprime la informacion de las salas, nombre, numero sala, capacidad
     * maxima y pelicula
     */
    public void imprimirSalas() {
        for (Sala sala : cine.getSalas()) {
            System.out.println(sala.informacionSala());
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Valida si el numero de sala es correcto
     *
     * @param numeroSala numero ordinal de la sala
     * @return true, si el numero de sala es valido
     */
    private boolean validarNumeroSala(int numeroSala) {
        ArrayList<Sala> salas = cine.getSalas();
        if (numeroSala < 1 || numeroSala > salas.size()) {
            return false;
        }
        return true;
    }

    /**
     * Imprime en pantalla el detalle de la sala, en caso de no ser un numero
     * valido imprime un mensaje de error
     *
     * @param numeroSala es el numero de sala, no el indice
     */
    public void verDetalleCompletoSala(int numeroSala) {
        if (!validarNumeroSala(numeroSala)) {
            System.out.println("Numero de Sala incorrecto, no existe dicha sala");
            return;
        }
        System.out.println(cine.getSalas().get(numeroSala - 1).toString());
    }

    /**
     * Imprime por pantalla todos los espectadores random que se han creado y muestra sus atributos
     */
    public void verEspectadores() {
        for (Espectador e : espectadores) {
            System.out.println(e.toString());
        }
    }

    /**
     * Imprime por pantalla todos los espectadores rechazados
     */
    public void verEspectadoresRechazados() {
        for (Espectador e : espectadoresRechazados) {
            System.out.println(e.toString());
        }
    }

    /**
     * Imprime la ocupacion de cada sala
     */
    public void verOcupacionSalas() {
        for (Sala s : cine.getSalas()) {
            int capacidad = s.getMaximoFilas() * s.getMaximoColumnas();
            int ocupadas = s.ocupacionSala();
            double porcentajeOcupadas = (double) ocupadas / capacidad * 100.0;
            System.out.println(s.getNombre() + " " + s.getNumeroSala() + " - Ocupacion: " + (Math.round(porcentajeOcupadas)*100.0)/100.0 + "%");
            System.out.println(ocupadas + "/" + capacidad);
            System.out.println("");
        }
    }

    public void crearEspectadoresAleatorios(int cantidadEspectadores) {
        ArrayList<String> nombresEspectadores = generarListaNombres(cantidadEspectadores);
        for (int i = 0; i < cantidadEspectadores; i++) {
            int edad = (int) ((Math.random() * 70) + 10);
            double dinero = (Math.random() * 1000) + 50;
            espectadores.add(new Espectador(nombresEspectadores.get(i), edad, dinero));
        }
    }

    public void simularCompras() {
        int sala = 1;
        boolean pudoComprar = false;

        for (Espectador e : espectadores) {
            if(!e.isNuevo()){
                continue;
            }
            
            sala = (int) (Math.random() * cine.getSalas().size() + 1);
            pudoComprar = cine.comprarEntrada(sala, e);

            if (!pudoComprar) {
                espectadoresRechazados.add(e);
            }
        }
    }
    
    public void agregarEspectadores(int cantidad){
        crearEspectadoresAleatorios(cantidad);
        simularCompras();
    }

    private ArrayList<String> generarListaNombres(int cantidadEspectadores) {
        Random random = new Random();
        ArrayList<String> listaNombres = new ArrayList<>(Arrays.asList("Carlos", "Sofia", "Juan", "Victoria", "Pamela", "Tobias", "Juan Pablo", "Albus", "Harry", "Ramon", "Pedro", "Fernando", "Luisa"));
        ArrayList<String> listaApellidos = new ArrayList<>(Arrays.asList("Oller", "Reynoso", "Duarte", "Serra", "Albornoz", "Piraino", "Rodriguez", "Dumbledore", "Potter", "Gomez", "Diaz", "Sosa", "Gonzalez", "Silva", "Lopez", "Ramirez", "Martinez", "Garcia", "Lopez", "Ortiz", "Jimenez", "Morales", "Torres", "Cruz", "Vega", "Leon", "Castro", "Alvarez", "Herrera", "Mendoza", "Medina", "Flores", "Paredes", "Romero", "Rios", "Herrera", "Guerra"));
        ArrayList<String> nombresAlumnos = new ArrayList<>();
        String nombre = "";
        String apellido = "";

        while (nombresAlumnos.size() < cantidadEspectadores) {
            nombre = listaNombres.get(random.nextInt(listaNombres.size()));
            apellido = listaApellidos.get(random.nextInt(listaApellidos.size()));
            nombresAlumnos.add(nombre + " " + apellido);
        }

        return nombresAlumnos;
    }
}
