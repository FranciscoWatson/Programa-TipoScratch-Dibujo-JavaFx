package edu.fiuba.algo3.modelo.excepciones;

public class NombreNoValidoParaAlgoritmoExcepcion extends RuntimeException{
    public String getMessage(){
        return "El nombre ingresado no es valido";
    }
}
