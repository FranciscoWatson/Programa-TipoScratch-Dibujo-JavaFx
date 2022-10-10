package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.campodejuego.Posicion;
import edu.fiuba.algo3.modelo.campodejuego.Tablero;
import edu.fiuba.algo3.modelo.pincel.Pincel;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void TableroRecienCreadoNoTieneCeldasPintadas(){
        Tablero tablero = new Tablero();
        assertEquals(0, tablero.celdasPintadas());
    }

    @Test
    public void TableroDibujarEfectivamenteDibujaConPincelAbajo() {
        Tablero tablero = new Tablero();
        Pincel pincel = new Pincel();
        pincel.bajarPincel();
        Posicion posicion_a = new Posicion();
        Posicion posicion_b = new Posicion();
        tablero.dibujar(posicion_a, pincel);
        posicion_b.sumarAColumna();
        tablero.dibujar(posicion_b, pincel);
        posicion_b.sumarAColumna();
        tablero.dibujar(posicion_b, pincel);
        assertEquals(3, tablero.celdasPintadas());
    }

    @Test
    public void TableroDibujarNoDibujaConPincelArriba() {
        Tablero tablero = new Tablero();
        Pincel pincel = new Pincel();
        Posicion posicion_a = new Posicion();
        tablero.dibujar(posicion_a, pincel);
        assertEquals(0, tablero.celdasPintadas());
    }
    @Test
    public void TableroSabeDiferenciarEntrePosicionPintadaONo() {
        Tablero tablero = new Tablero();
        Pincel pincel = new Pincel();
        Posicion posicion_a = new Posicion();
        tablero.dibujar(posicion_a, pincel);
        assertFalse(tablero.posicionPintada(posicion_a));
        pincel.bajarPincel();
        tablero.dibujar(posicion_a, pincel);
        assertTrue(tablero.posicionPintada(posicion_a));
    }

}
