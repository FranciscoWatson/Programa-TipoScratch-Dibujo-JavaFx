package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Controlador.observables.Observable;
import edu.fiuba.algo3.Controlador.observables.Observer;
import edu.fiuba.algo3.modelo.campodejuego.Posicion;
import edu.fiuba.algo3.modelo.campodejuego.Tablero;
import edu.fiuba.algo3.modelo.pincel.EstadoPincel;
import edu.fiuba.algo3.modelo.pincel.Pincel;
import edu.fiuba.algo3.modelo.pincel.PincelAbajo;

import java.util.ArrayList;


//Se comporta igual que la clase personaje
//la unica diferencia radica en que recibe un objeto posicion en su creacion,
//necesario para poder instanciar la posicionMock
public class PersonajeMock implements Observable {

    private ArrayList<Observer> observers;
    private Pincel pincel = new Pincel();
    private Posicion posicion;
    private Tablero tablero = new Tablero();

    public PersonajeMock(Posicion posicion){
        this.posicion = posicion;
    }

    public int devolverCantidadCeldasPintadas(){
        return (tablero.celdasPintadas());
    }

    public boolean posicionPintada(Posicion posicion){
        return tablero.posicionPintada(posicion);
    }

    public EstadoPincel devolverEstadoPincel(){
        return pincel.devolverEstadoPincel();
    }

    public int posicionActual(){
        return posicion.hashCode();
    }

    public Posicion devolverPosicion(){
        return posicion;
    }

    public void moverAbajo(){
        posicion.restarAFila();
        //tablero.dibujar(posicion, pincel);
        //notifyObservers();
    }

    public void moverArriba(){
        posicion.sumarAFila();
        tablero.dibujar(posicion, pincel);
        //notifyObservers();
    }

    public void moverDerecha(){
        posicion.sumarAColumna();
        //tablero.dibujar(posicion, pincel);
        //notifyObservers();
    }

    public void moverIzquierda(){
        posicion.restarAColumna();
        tablero.dibujar(posicion, pincel);
        //notifyObservers();
    }

    public void bajarPincel(){
        pincel.bajarPincel();
        tablero.dibujar(posicion, pincel);
        notifyObservers();
    }

    public void subirPincel(){
        pincel.subirPincel();
        notifyObservers();
    }

    public boolean pincelAbajo(){
        return pincel.devolverEstadoPincel().getClass() == PincelAbajo.class;
    }

    @Override
    public void addObserver(Observer observer) {observers.add(observer);}

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.change());
    }
}
