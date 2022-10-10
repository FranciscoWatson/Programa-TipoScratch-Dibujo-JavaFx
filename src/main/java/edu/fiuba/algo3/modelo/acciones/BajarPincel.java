package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;

public class BajarPincel implements Accion {

    public void aplicarAccion(Personaje personaje){
       personaje.bajarPincel();
    }

    public void aplicarAccionInversa(Personaje personaje) { personaje.subirPincel(); }

    public String devolverNombre(){
        return "Bajar pincel";
    }
}
