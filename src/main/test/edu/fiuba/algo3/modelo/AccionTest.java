package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.acciones.*;
import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;
import edu.fiuba.algo3.modelo.campodejuego.Posicion;
import edu.fiuba.algo3.modelo.pincel.EstadoPincel;
import edu.fiuba.algo3.modelo.pincel.PincelAbajo;
import edu.fiuba.algo3.modelo.pincel.PincelArriba;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionTest {
    @Test
    public void PruebaMoverALaderechaModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverALaDerecha();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        accion.aplicarAccion(personaje);
        posicion.sumarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaMoverALaIzquierdaModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverALaIzquierda();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        accion.aplicarAccion(personaje);
        posicion.restarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaMoverArribaModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverArriba();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        accion.aplicarAccion(personaje);
        posicion.sumarAFila();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaMoverAbajoModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverAbajo();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        accion.aplicarAccion(personaje);
        posicion.restarAFila();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaBajarPincelCambiaCorrectamenteElEstadoDelPincel() {
        Personaje personaje = new Personaje();
        Accion accion = new BajarPincel();
        EstadoPincel pincelAbajo = new PincelAbajo();
        EstadoPincel pincelArriba = new PincelArriba();
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
        accion.aplicarAccion(personaje);
        assertEquals(pincelAbajo.getClass(), personaje.devolverEstadoPincel().getClass());
    }

    @Test
    public void PruebaSubirPincelCambiaCorrectamenteElEstadoDelPincel() {
        Personaje personaje = new Personaje();
        Accion accion = new BajarPincel();
        Accion subir = new SubirPincel();
        EstadoPincel pincelAbajo = new PincelAbajo();
        EstadoPincel pincelArriba = new PincelArriba();
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
        accion.aplicarAccion(personaje);
        assertEquals(pincelAbajo.getClass(), personaje.devolverEstadoPincel().getClass());
        subir.aplicarAccion(personaje);
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
    }

    @Test
    public void PruebaRepetirPorDosModificaCorrectamenteLaPosicionDelPersonaje() {
        Personaje personaje = new Personaje();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        Algoritmo repetirPorDos = new Algoritmo(2);
        repetirPorDos.almacenarAccion(new MoverALaDerecha());
        repetirPorDos.aplicarAccion(personaje);
        posicion.sumarAColumna();
        posicion.sumarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaRepetirPorTresModificaCorrectamenteLaPosicionDelPersonaje() {
        Personaje personaje = new Personaje();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        Algoritmo repetirPorTres = new Algoritmo(3);
        repetirPorTres.almacenarAccion(new MoverALaDerecha());
        repetirPorTres.aplicarAccion(personaje);
        posicion.sumarAColumna();
        posicion.sumarAColumna();
        posicion.sumarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaInvertirComportamientoModificaCorrectamenteLaPosicionDelPersonaje() {
        Personaje personaje = new Personaje();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(new MoverALaDerecha());
        invertirComportamiento.aplicarAccion(personaje);
        posicion.restarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaMoverALaderechaInversaModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverALaDerecha();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(accion);
        invertirComportamiento.aplicarAccion(personaje);
        posicion.restarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaMoverALaIzquierdaInversaModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverALaIzquierda();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(accion);
        invertirComportamiento.aplicarAccion(personaje);
        posicion.sumarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaMoverAbajoInversaModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverAbajo();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(accion);
        invertirComportamiento.aplicarAccion(personaje);
        posicion.sumarAFila();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaMoverArribaInversaModificaCorrectamenteLaPosicion() {
        Personaje personaje = new Personaje();
        Accion accion = new MoverArriba();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(accion);
        invertirComportamiento.aplicarAccion(personaje);
        posicion.restarAFila();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaRepetirPorDosInversaModificaCorrectamenteLaPosicionDelPersonaje() {
        Personaje personaje = new Personaje();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        Algoritmo repetirPorDos = new Algoritmo(2);
        repetirPorDos.almacenarAccion(new MoverALaDerecha());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(repetirPorDos);
        invertirComportamiento.aplicarAccion(personaje);
        posicion.restarAColumna();
        posicion.restarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaRepetirPorTresInversaModificaCorrectamenteLaPosicionDelPersonaje() {
        Personaje personaje = new Personaje();
        Posicion posicion = new Posicion();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
        Algoritmo repetirPorTres = new Algoritmo(3);
        repetirPorTres.almacenarAccion(new MoverALaDerecha());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(repetirPorTres);
        invertirComportamiento.aplicarAccion(personaje);
        posicion.restarAColumna();
        posicion.restarAColumna();
        posicion.restarAColumna();
        assertEquals(posicion.hashCode(), personaje.posicionActual());
    }

    @Test
    public void PruebaBajarPincelInversaCambiaCorrectamenteElEstadoDelPincel() {
        Personaje personaje = new Personaje();
        Accion accion = new BajarPincel();
        EstadoPincel pincelArriba = new PincelArriba();
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(accion);
        invertirComportamiento.aplicarAccion(personaje);
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
    }

    @Test
    public void PruebaSubirPincelInversaCambiaCorrectamenteElEstadoDelPincel() {
        Personaje personaje = new Personaje();
        Accion accion = new SubirPincel();
        EstadoPincel pincelAbajo = new PincelAbajo();
        EstadoPincel pincelArriba = new PincelArriba();
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(accion);
        invertirComportamiento.aplicarAccion(personaje);
        assertEquals(pincelAbajo.getClass(), personaje.devolverEstadoPincel().getClass());
    }

    @Test
    public void PruebaInvertirComportamientoInversaNoCambiaElEstadoDelPincel() {
        Personaje personaje = new Personaje();
        Accion accion = new SubirPincel();
        EstadoPincel pincelArriba = new PincelArriba();
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
        InvertirComportamiento invertirComportamiento = new InvertirComportamiento();
        InvertirComportamiento invertirComportamientoAuxiliar = new InvertirComportamiento();
        invertirComportamiento.almacenarAccion(accion);
        invertirComportamientoAuxiliar.almacenarAccion(invertirComportamiento);
        invertirComportamientoAuxiliar.aplicarAccion(personaje);
        assertEquals(pincelArriba.getClass(), personaje.devolverEstadoPincel().getClass());
    }

    @Test
    public void PruebaMoverALaDerechaDevuelveNombreCorrecto() {
        Accion accion = new MoverALaDerecha();
        assertEquals(accion.devolverNombre(),"Mover a la derecha");
    }

    @Test
    public void PruebaMoverALaIzquierdaDevuelveNombreCorrecto() {
        Accion accion = new MoverALaIzquierda();
        assertEquals(accion.devolverNombre(),"Mover a la izquierda");
    }

    @Test
    public void PruebaMoverArribaDevuelveNombreCorrecto() {
        Accion accion = new MoverArriba();
        assertEquals(accion.devolverNombre(),"Mover arriba");
    }

    @Test
    public void PruebaMoverAbajoDevuelveNombreCorrecto() {
        Accion accion = new MoverAbajo();
        assertEquals(accion.devolverNombre(),"Mover abajo");
    }

    @Test
    public void PruebaInvertirComportamientoDevuelveNombreCorrecto() {
        Accion accion = new InvertirComportamiento();
        assertEquals(accion.devolverNombre(),"Invertir comportamiento");
    }

    @Test
    public void PruebaAlgoritmoDevuelveNombreCorrecto() {
        Accion accion = new Algoritmo(1);
        assertEquals(accion.devolverNombre(),"Algoritmo 1");
    }

    @Test
    public void PruebaRepetirPorDosDevuelveNombreCorrecto() {
        Accion accion = new Algoritmo(2);
        assertEquals(accion.devolverNombre(),"Algoritmo 2");
    }

    @Test
    public void PruebaRepetirPorTresDevuelveNombreCorrecto() {
        Accion accion = new Algoritmo(3);
        assertEquals(accion.devolverNombre(),"Algoritmo 3");
    }

    @Test
    public void PruebaBajarPincelDevuelveNombreCorrecto() {
        Accion accion = new BajarPincel();
        assertEquals(accion.devolverNombre(),"Bajar pincel");
    }

    @Test
    public void PruebaSubirPincelDevuelveNombreCorrecto() {
        Accion accion = new SubirPincel();
        assertEquals(accion.devolverNombre(),"Subir pincel");
    }

    @Test
    public void AlgoritmoDentroDeBloqueInvertirFuncionaCorrectamente() {
        Algoritmo algoritmo = new Algoritmo(1);
        Personaje personaje = new Personaje();
        Posicion posicion = new Posicion();

        algoritmo.almacenarAccion(new MoverALaDerecha());
        algoritmo.aplicarAccionInversa(personaje);
        posicion.restarAColumna();
        assertEquals(posicion.hashCode(),personaje.posicionActual());
    }
}
