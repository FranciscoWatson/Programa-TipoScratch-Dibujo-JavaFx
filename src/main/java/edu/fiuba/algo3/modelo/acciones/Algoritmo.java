package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;
import edu.fiuba.algo3.modelo.excepciones.RepetibleNoTieneAccionesTodaviaExcepcion;

import java.util.ArrayList;

public class Algoritmo extends Repetible {

    private int cantidadRepeticiones;

    public Algoritmo(int cantidad){
       this.cantidadRepeticiones = cantidad;
    }

    @Override
    public void almacenarAccion(Accion accion){
        accionesAEjecutar.add(accion);
        notifyObservers();
    }

    public void aplicarAccion(Personaje personaje){
        for(Accion accion: accionesAEjecutar){
            for(int i = 0; i < cantidadRepeticiones;i++) {
                accion.aplicarAccion(personaje);
            }
        }
    }
    public void aplicarAccionInversa(Personaje personaje) {
        for(Accion accion: accionesAEjecutar){
            for(int i = 0; i < cantidadRepeticiones;i++) {
                accion.aplicarAccionInversa(personaje);
            }
        }
    }

    public void transferirAcciones(Algoritmo algoritmoPersonalizado){
        if(accionesAEjecutar.isEmpty()){ throw new RepetibleNoTieneAccionesTodaviaExcepcion();}
        for(Accion accion: accionesAEjecutar){
            algoritmoPersonalizado.almacenarAccion(accion);
        }
    }

    public Repetible copiar(){
        Algoritmo copia = new Algoritmo(cantidadRepeticiones);
        transferirAcciones(copia);
        accionesAEjecutar.clear();
        return copia;
    }

    public String devolverNombre(){
        return "Algoritmo "+cantidadRepeticiones;
    }
}
