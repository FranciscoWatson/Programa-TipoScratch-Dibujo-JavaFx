package edu.fiuba.algo3.modelo.acciones;

import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;

public interface Accion {

    void aplicarAccion(Personaje personaje);
    void aplicarAccionInversa(Personaje personaje);
    String devolverNombre();
}
