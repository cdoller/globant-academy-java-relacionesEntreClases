/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Random;

public class RevolverAgua {

    Integer posicionActual;
    Integer posicionTambor;

    public RevolverAgua() {
        posicionActual = 0;
        posicionTambor = 0;
    }

    public void cargarRevolver() {
        Random aleatorio = new Random();
        posicionActual = aleatorio.nextInt(6);
    }

    public void girarTambor() {
        Random aleatorio = new Random();
        posicionTambor = aleatorio.nextInt(6);
    }

    public Boolean mojar() {
        System.out.println("Posicion actual: " + posicionActual);
        System.out.println("Posicion Tambor: " + posicionTambor);
        return posicionActual.equals(posicionTambor);
    }

    public void siguienteChorro() {
        posicionActual++;
        posicionActual %= 6;
    }

    @Override
    public String toString() {
        return "RevolverAgua{" + "posicionActual=" + posicionActual + ", posicionTambor=" + posicionTambor + '}';
    }

}
