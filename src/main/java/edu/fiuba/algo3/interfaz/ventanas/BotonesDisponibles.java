package edu.fiuba.algo3.interfaz.ventanas;

import edu.fiuba.algo3.Controlador.handlers.*;
import edu.fiuba.algo3.modelo.actoresPrincipales.Juego;
import edu.fiuba.algo3.modelo.acciones.*;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BotonesDisponibles extends VBox {
    private Consola consola;
    private Juego juego;

    public BotonesDisponibles(Consola consola, Juego juego) {
        this.consola = consola;
        this.juego = juego;
        this.setSpacing(30);
        this.getChildren().add(consola);
        this.getStylesheets().add("style.css");
        this.getStyleClass().add("panel");

        Label titulo = new Label("Acciones Disponibles");
        titulo.getStyleClass().add("titulo");

        ArrayList<Accion> AccionesDisponibles = juego.devolverAcciones();

        //Seteo boton ejecutar
        Button botonEjecutar = new Button();
        botonEjecutar.getStyleClass().add("botonEjecutar");
        botonEjecutar.setText("Ejecutar");
        EjecutarEventhandler botonEjecutarHandler = new EjecutarEventhandler(juego, consola);
        botonEjecutar.setOnAction(botonEjecutarHandler);

        //Seteo boton salir
        Button botonSalir = new Button();
        botonSalir.getStyleClass().add("botonSalir");
        botonSalir.setText("Salir");
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        //Seteo boton limpiar
        Button botonlimpiar = new Button();
        botonlimpiar.getStyleClass().add("botonLimpiar");
        botonlimpiar.setText("Limpiar algoritmo");
        LimpiarEventhandler botonLimpiarHanlder = new LimpiarEventhandler(juego, consola);
        botonlimpiar.setOnAction(botonLimpiarHanlder);

        //Agrego Salir y Ejecutar a una botonera
        HBox botonera = new HBox(botonEjecutar, botonSalir);
        botonera.setAlignment( Pos.CENTER );
        botonera.setSpacing( 50 );

        //Configuracion Boton Algoritmo personalizado//
        Button botonGuardarAlgoritmo = new Button();
        botonGuardarAlgoritmo.getStyleClass().add("botones");
        botonGuardarAlgoritmo.setText("Guardar este Algoritmo");

        TextField NombreAlgoritmo = new TextField();
        NombreAlgoritmo.getStyleClass().add("botones");
        MenuButton AlgoritmosGuardados = new MenuButton("Algoritmos Guardados");
        AlgoritmosGuardados.getStyleClass().add("botones");

        GuardarAlgoritmoEventHandler botonGuardarHandler = new GuardarAlgoritmoEventHandler(juego, consola, NombreAlgoritmo, AlgoritmosGuardados);
        botonGuardarAlgoritmo.setOnAction(botonGuardarHandler);

        //Seteo los botones repetibles
        MenuButton repetirPorDos = new MenuButton("Repetir Por Dos");
        repetirPorDos.getStyleClass().add("botones");
        MenuButton repetirPorTres = new MenuButton("Repetir Por Tres");
        repetirPorTres.getStyleClass().add("botones");
        MenuButton invertirComportamiento = new MenuButton("Invertir Comportamiento");
        invertirComportamiento.getStyleClass().add("botones");

        Algoritmo repetirPorDosBloque = new Algoritmo(2);
        Algoritmo repetirPorTresBloque = new Algoritmo(3);
        InvertirComportamiento invertirComportamientoBloque = new InvertirComportamiento();

        consola.agregarObservable(repetirPorDosBloque);
        consola.agregarObservable(repetirPorTresBloque);
        consola.agregarObservable(invertirComportamientoBloque);

        crearBloquerepetible(AccionesDisponibles,repetirPorDosBloque,repetirPorDos);
        crearBloquerepetible(AccionesDisponibles,repetirPorTresBloque,repetirPorTres);
        crearBloquerepetible(AccionesDisponibles,invertirComportamientoBloque,invertirComportamiento);

        //Agrego los botones a una VBox
        VBox botoneraAcciones = new VBox(titulo,AlgoritmosGuardados,NombreAlgoritmo,botonGuardarAlgoritmo,repetirPorDos,repetirPorTres,invertirComportamiento);
        botoneraAcciones.setAlignment( Pos.CENTER );
        botoneraAcciones.setSpacing( 10 );

        //Agrego los botones de acciones simples//
        for (Accion accion :AccionesDisponibles) {
            Button button = new Button();
            button.setText(accion.devolverNombre());
            button.getStyleClass().add("botones");
            AccionEventhandler eventHandler = new AccionEventhandler(juego, accion, consola);
            button.setOnAction(eventHandler);
            botoneraAcciones.getChildren().add(button);
        }
        this.getChildren().addAll(botonera,botonlimpiar,botoneraAcciones);
    }

    private void crearBloquerepetible(ArrayList<Accion> AccionesDisponibles, Repetible repetible, MenuButton repetibleButton) {

        //Meto los items dentro del Boton menu//
        for (Accion accion :AccionesDisponibles) {
            MenuItem acciones = new MenuItem(accion.devolverNombre());
            RepetibleEventhandler botonUsardarHandler = new RepetibleEventhandler(accion, consola,repetible,juego);
            acciones.setOnAction(botonUsardarHandler);

            repetibleButton.getItems().add(acciones);
        }

        MenuItem guardarRepetible = new MenuItem("Almacenar");
        AlmacenarRepetibleEventhandler botonAlmacenarRepetibleEventhandler = new AlmacenarRepetibleEventhandler(juego,consola,repetible);
        guardarRepetible.setOnAction(botonAlmacenarRepetibleEventhandler);
        repetibleButton.getItems().add(guardarRepetible);
    }
}
