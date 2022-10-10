package edu.fiuba.algo3.modelo.actoresPrincipales;

import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.acciones.Algoritmo;
import edu.fiuba.algo3.modelo.acciones.*;
import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;
import edu.fiuba.algo3.modelo.campodejuego.Posicion;
import edu.fiuba.algo3.modelo.excepciones.NombreNoValidoParaAlgoritmoExcepcion;

import java.util.*;

public class Juego {
    private Personaje personaje = new Personaje();
    private Algoritmo algoritmo = new Algoritmo(1);

    private HashMap<String, Algoritmo> algoritmosGuardados = new HashMap<>();

    public ArrayList<Accion> posiblesAcciones = new ArrayList<>();
    {
        posiblesAcciones.add(new MoverAbajo());
        posiblesAcciones.add(new MoverArriba());
        posiblesAcciones.add(new MoverALaDerecha());
        posiblesAcciones.add(new MoverALaIzquierda());
        posiblesAcciones.add(new SubirPincel());
        posiblesAcciones.add(new BajarPincel());
    }

    public ArrayList<Accion> devolverAcciones(){
        return posiblesAcciones;
    }

    public void agregarAccion(Accion accion){algoritmo.almacenarAccion(accion); }

    public void crearAlgoritmoPersonalizado(String nombre){
        Algoritmo AlgoritmoPersonalizado = new Algoritmo(1);
        if(algoritmosGuardados.get(nombre) != null) {throw new NombreNoValidoParaAlgoritmoExcepcion();}
        if(nombre.equals("")) {throw new NombreNoValidoParaAlgoritmoExcepcion();}
        algoritmo.transferirAcciones(AlgoritmoPersonalizado);
        algoritmosGuardados.put(nombre, AlgoritmoPersonalizado);
    }

    public void usarAlgoritmoPersonalizado(String nombre){
        Algoritmo aux = algoritmosGuardados.get(nombre);
        algoritmo.almacenarAccion(aux);
    }

    public void ejecutar(){
        algoritmo.aplicarAccion(personaje);
        this.limpiar();
    }

    public void limpiar(){
        algoritmo.accionesAEjecutar.clear();
    }

    public Personaje devolverPersonaje(){
        return personaje;
    }

    public int devolverCeldasPintadas(){
        return personaje.devolverCantidadCeldasPintadas();
    }

    public boolean posicionPintada(Posicion posicion){
        return personaje.posicionPintada(posicion);
    }

    public Algoritmo devolverAlgoritmo() {
        return algoritmo;
    }
}