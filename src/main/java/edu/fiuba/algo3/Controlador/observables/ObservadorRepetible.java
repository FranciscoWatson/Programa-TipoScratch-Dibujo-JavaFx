package edu.fiuba.algo3.Controlador.observables;

import edu.fiuba.algo3.interfaz.ventanas.Consola;
import edu.fiuba.algo3.modelo.acciones.Repetible;

public class ObservadorRepetible implements Observer{
    private Consola consola;
    private Repetible repetible;
    public ObservadorRepetible(Consola consola, Repetible repetible){
        this.consola = consola;
        this.repetible = repetible;
    }
    @Override
    public void change() {
        consola.displayRepetible(repetible);
    }
}
