package edu.fiuba.algo3.Controlador.observables;

public interface Observable {

    void addObserver(Observer observer);

    void notifyObservers();
}
