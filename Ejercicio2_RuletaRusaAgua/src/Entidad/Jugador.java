/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

public class Jugador{
    private Integer id;
    private String nombre;
    private Boolean mojado;
    
    public Jugador(Integer id){
        this.id = id;
        nombre = "Jugador " + id;
        mojado = false;
    }
    
    public Boolean disparo(RevolverAgua revolver){
        revolver.girarTambor();
        if(revolver.mojar()){
            mojado = true;
            return true;
        }
        //revolver.siguienteChorro();
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", mojado=" + mojado + '}';
    }
    
    
}