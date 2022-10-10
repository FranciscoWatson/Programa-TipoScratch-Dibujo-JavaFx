package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.campodejuego.Posicion;

import java.util.Objects;

public class PosicionMock extends Posicion {
    private int fila = 0;
    private int columna = 0;

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    public void sumarAColumna(){
        columna++;
    }
    public void restarAColumna(){
        columna--;
    }
    public void sumarAFila(){
        fila ++;
    }
    public void restarAFila(){
        fila --;
    }
}
