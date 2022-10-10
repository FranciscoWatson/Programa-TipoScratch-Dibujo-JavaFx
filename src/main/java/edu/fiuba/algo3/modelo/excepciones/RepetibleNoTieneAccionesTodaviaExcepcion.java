package edu.fiuba.algo3.modelo.excepciones;

public class RepetibleNoTieneAccionesTodaviaExcepcion extends RuntimeException{
    public String getMessage(){
        return "El Algoritmo esta vacio";
    }
}
