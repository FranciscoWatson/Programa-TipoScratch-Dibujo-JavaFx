package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;

public class SubirPincel implements Accion {

    public void aplicarAccion(Personaje personaje){
        personaje.subirPincel();
    }

    public void aplicarAccionInversa(Personaje personaje) { personaje.bajarPincel(); }

    public String devolverNombre(){
        return "Subir pincel";
    }
}