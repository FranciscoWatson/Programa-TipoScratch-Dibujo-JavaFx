package edu.fiuba.algo3.modelo.pincel;

import edu.fiuba.algo3.modelo.campodejuego.Celda;

public class Pincel {

    private EstadoPincel estadoArriba = new PincelArriba();
    private EstadoPincel estadoAbajo = new PincelAbajo();
    private EstadoPincel estado = estadoArriba;

    public void usarSobre(Celda celda){
        estado.aplicarA(celda);
    }

    public EstadoPincel devolverEstadoPincel(){
        return estado;
    }

    public void subirPincel(){
        estado = estadoArriba;
    }

    public void bajarPincel(){
        estado = estadoAbajo;
    }

}
