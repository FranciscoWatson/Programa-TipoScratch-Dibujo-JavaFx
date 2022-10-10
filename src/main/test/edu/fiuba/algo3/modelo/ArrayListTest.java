package edu.fiuba.algo3.modelo;

import java.util.*;

public class ArrayListTest<Accion> extends ArrayList<Accion> {
    // Esta implementacion de arraylist se usa en
    // PruebaJuegoDevolverPosiblesAccionesDevuelveAccionesCorrectamente en JuegoTest
    // Para comparar que efectivamente Juego tenga las Acciones Disponibles correctas
    @Override
    public boolean equals(Object o){
        if (o == this) // Not the same list so no return
            return true;
        if (!(o instanceof List)) // is an instance of List, so no return
            return false;

        ListIterator<Accion> e1 = listIterator();
        ListIterator<?> e2 = ((List<?>) o).listIterator();
        while (e1.hasNext() && e2.hasNext()) { // Both have no next, so no loop    here
            Accion o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.getClass().equals(o2.getClass()))) //esta linea difiere de la implementacion original en arraylist pues le pido la clase a los objetos
                return false;
        }
        return !(e1.hasNext() || e2.hasNext()); // Both validate to false, so negating false return true in the end.
    }
}
