/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

public class Pelicula{
    private String titulo;
    private int duracionMinutos;
    private String director;
    private int edadMinima;

    public Pelicula(String titulo, int duracionMinutos, String director, int edadMinima) {
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.director = director;
        this.edadMinima = edadMinima;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        if(duracionMinutos>=0){
            this.duracionMinutos = duracionMinutos;
            return;
        }
        System.out.println("Duracion no valida");
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        if(duracionMinutos>=0){
            this.edadMinima = edadMinima;
            return;
        }
        System.out.println("Edad no valida");
    }

    @Override
    public String toString() {
        String pelicula = "TITULO: " + titulo + "\n" +
               "DIRECCION: " + director + "\n" +
               "DURACION: " + duracionMinutos + " minutos\n";
        if(edadMinima==0){
            pelicula += "CALIFICACION: APT (Apta todo público)";
        }else{
            pelicula += "CALIFICACION: Apta mayores de " + edadMinima + " años";
        }
        
        return pelicula;
    }
    
    
}