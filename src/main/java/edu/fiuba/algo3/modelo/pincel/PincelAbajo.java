package edu.fiuba.algo3.modelo.pincel;

import edu.fiuba.algo3.modelo.campodejuego.Celda;

public class PincelAbajo implements EstadoPincel {

    public void aplicarA(Celda celda){
        celda.pintar();
    }
}
