package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.campodejuego.Celda;
import edu.fiuba.algo3.modelo.pincel.EstadoPincel;
import edu.fiuba.algo3.modelo.pincel.Pincel;
import edu.fiuba.algo3.modelo.pincel.PincelAbajo;

public class PincelAbajoMock extends Pincel {

    private EstadoPincel estado = new PincelAbajo();

    public void usarSobre(Celda celda){
        estado.aplicarA(celda);
    }

}
