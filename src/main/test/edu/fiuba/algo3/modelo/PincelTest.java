package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.campodejuego.Celda;
import edu.fiuba.algo3.modelo.pincel.EstadoPincel;
import edu.fiuba.algo3.modelo.pincel.Pincel;
import edu.fiuba.algo3.modelo.pincel.PincelAbajo;
import edu.fiuba.algo3.modelo.pincel.PincelArriba;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PincelTest {
    @Test
    public void PincelSeIniciaConEstadoPincelArriba() {
        Pincel pincel = new Pincel();
        EstadoPincel pincelArriba = new PincelArriba();
        assertEquals(pincelArriba.getClass(),(pincel.devolverEstadoPincel().getClass()));
    }
    @Test
    public void PincelActualizoSuEstado() {
        Pincel pincel = new Pincel();
        EstadoPincel pincelAbajo = new PincelAbajo();
        pincel.bajarPincel();
        assertEquals(pincelAbajo.getClass(),(pincel.devolverEstadoPincel().getClass()));
    }
    @Test
    public void PincelAbajoPintaCelda() {
        Pincel pincel = new Pincel();
        Celda celda = new Celda();
        EstadoPincel pincelAbajo = new PincelAbajo();
        pincel.bajarPincel();
        assertEquals(pincelAbajo.getClass(),(pincel.devolverEstadoPincel().getClass()));
        pincel.usarSobre(celda);
        assertTrue(celda.devolverEstado());
    }
    @Test
    public void PincelArribaNoPintaCelda() {
        Pincel pincel = new Pincel();
        Celda celda = new Celda();
        EstadoPincel pincelArriba = new PincelArriba();
        assertEquals(pincelArriba.getClass(),(pincel.devolverEstadoPincel().getClass()));
        pincel.usarSobre(celda);
        assertFalse(celda.devolverEstado());
    }
}
