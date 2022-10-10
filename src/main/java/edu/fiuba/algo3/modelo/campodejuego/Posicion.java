package edu.fiuba.algo3.modelo.campodejuego;

import java.util.Objects;

public class Posicion {
    private int fila = 0;
    private int columna = 0;

    public int devolverColumna(){
        return columna;
    }

    public int devolverFila(){
        return fila;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

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
