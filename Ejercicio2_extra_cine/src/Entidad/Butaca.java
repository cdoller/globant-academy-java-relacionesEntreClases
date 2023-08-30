package Entidad;

public class Butaca {

    String fila;
    int columna;
    boolean ocupada;
    Espectador espectador;

    public Butaca(String fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        ocupada = false;
    }

    public String getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Espectador getEspectador() {
        if (ocupada) {
            return espectador;
        }
        return null;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public boolean setEspectador(Espectador espectador) {
        if(ocupada)
            return false;
        this.espectador = espectador;
        ocupada = true;
        return true;
    }

    @Override
    public String toString() {
        String butaca = "|" + fila + columna;
        if(ocupada){
            butaca += " X |";
        }else{
            butaca += "   |";
        }
        return butaca;
    }
    
    

}
