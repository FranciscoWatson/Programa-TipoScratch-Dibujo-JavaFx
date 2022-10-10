package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;
import edu.fiuba.algo3.modelo.campodejuego.Posicion;
import edu.fiuba.algo3.modelo.pincel.EstadoPincel;
import edu.fiuba.algo3.modelo.pincel.PincelAbajo;
import edu.fiuba.algo3.modelo.pincel.PincelArriba;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {
    @Test
    public void personajeSeIniciaEnLaPosicionCorrecta() {
        Personaje personaje = new Personaje();
        Posicion posicion = new Posicion();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }
    @Test
    public void personajeSeIniciaConPincelArriba() {
        EstadoPincel pincelArriba = new PincelArriba();
        Personaje personaje = new Personaje();
        assertSame(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
    }
    @Test
    public void personajeMoverAbajoModificaCorrectamentePosicion() {
        Personaje personaje = new Personaje();
        personaje.moverAbajo();
        Posicion posicion = new Posicion();
        posicion.restarAFila();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }
    @Test
    public void personajeMoverDerechaModificaCorrectamentePosicion() {
        Personaje personaje = new Personaje();
        personaje.moverDerecha();
        Posicion posicion = new Posicion();
        posicion.sumarAColumna();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }
    @Test
    public void personajeMoverIzquierdaModificaCorrectamentePosicion() {
        Personaje personaje = new Personaje();
        personaje.moverIzquierda();
        Posicion posicion = new Posicion();
        posicion.restarAColumna();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }
    @Test
    public void personajeMoverArribaModificaCorrectamentePosicion() {
        Personaje personaje = new Personaje();
        personaje.moverArriba();
        Posicion posicion = new Posicion();
        posicion.sumarAFila();
        assertEquals(personaje.posicionActual(), posicion.hashCode());
    }
    @Test
    public void personajeBajaCorrectamenteElPincel() {
        EstadoPincel pincelAbajo = new PincelAbajo();
        Personaje personaje = new Personaje();
        personaje.bajarPincel();
        assertSame(pincelAbajo.getClass(), personaje.devolverEstadoPincel().getClass());
        assertTrue(personaje.pincelAbajo());
    }
    @Test
    public void personajeSubeCorrectamenteElPincel() {
        EstadoPincel pincelArriba = new PincelArriba();
        Personaje personaje = new Personaje();
        personaje.bajarPincel();
        personaje.subirPincel();
        assertSame(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
    }
}
