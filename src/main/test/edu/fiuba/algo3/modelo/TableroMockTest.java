package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.campodejuego.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableroMockTest {

    Tablero tablero = new Tablero();
    PosicionMock posicion = new PosicionMock();
    PincelAbajoMock pincel = new PincelAbajoMock();

    @Test
    public void TableroDibujarEfectivamenteDibujaConPincelAbajo() {

        tablero.dibujar(posicion, pincel);
        posicion.sumarAColumna();
        tablero.dibujar(posicion, pincel);
        posicion.sumarAColumna();
        tablero.dibujar(posicion, pincel);
        assertEquals(3, tablero.celdasPintadas());
    }
}
