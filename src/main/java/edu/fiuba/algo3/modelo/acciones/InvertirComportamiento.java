package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;

public class InvertirComportamiento extends Repetible {
    public void aplicarAccion(Personaje personaje){
        for(Accion accion: accionesAEjecutar){
            accion.aplicarAccionInversa(personaje);
        }
    }
    public void aplicarAccionInversa(Personaje personaje) {
        for(Accion accion: accionesAEjecutar){
            accion.aplicarAccion(personaje);
        }
    }

    public String devolverNombre(){
        return "Invertir comportamiento";
    }

    public Repetible copiar(){
        InvertirComportamiento copia = new InvertirComportamiento();
        transferirAcciones(copia);
        accionesAEjecutar.clear();
        return copia;
    }
}
