package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PersonajeMockTest {

    private PosicionMock posicion = new PosicionMock();

    private PersonajeMock personaje = new PersonajeMock(posicion);

    @Test
    public void personajeMoverDerechaModificaCorrectamentePosicion() {
        personaje.moverDerecha();
        posicion.sumarAColumna();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }

    @Test
    public void personajeMoverIzquierdaModificaCorrectamentePosicion() {
        personaje.moverIzquierda();
        posicion.restarAColumna();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }

    @Test
    public void personajeMoverArribaModificaCorrectamentePosicion() {
        personaje.moverArriba();
        posicion.sumarAFila();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }

    @Test
    public void personajeMoverAbajoModificaCorrectamentePosicion() {
        personaje.moverAbajo();
        posicion.restarAFila();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }

}