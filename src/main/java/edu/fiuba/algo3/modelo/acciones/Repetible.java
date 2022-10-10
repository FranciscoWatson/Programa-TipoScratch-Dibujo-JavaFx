package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.Controlador.observables.Observable;
import edu.fiuba.algo3.Controlador.observables.Observer;
import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;
import edu.fiuba.algo3.modelo.excepciones.RepetibleNoTieneAccionesTodaviaExcepcion;

import java.util.ArrayList;
import java.util.List;

public abstract class Repetible implements Accion, Observable {
        public List<Accion> accionesAEjecutar = new ArrayList();
        private ArrayList<Observer> observers = new ArrayList<>();

        public abstract void aplicarAccion(Personaje personaje);

        public abstract Repetible copiar();

        public void almacenarAccion(Accion accion){
            accionesAEjecutar.add(accion);
            notifyObservers();
        }

        public void transferirAcciones(Repetible repetible){
            if(accionesAEjecutar.isEmpty()){ throw new RepetibleNoTieneAccionesTodaviaExcepcion();}
            for(Accion accion: accionesAEjecutar){
                repetible.almacenarAccion(accion);
            }
        }

    @Override
    public void addObserver(Observer observer) {observers.add(observer);}

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.change());
    }
}



