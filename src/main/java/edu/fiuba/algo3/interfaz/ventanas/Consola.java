package edu.fiuba.algo3.interfaz.ventanas;

import edu.fiuba.algo3.Controlador.observables.ObservadorRepetible;
import edu.fiuba.algo3.Controlador.observables.Observer;
import edu.fiuba.algo3.modelo.acciones.Algoritmo;
import edu.fiuba.algo3.modelo.acciones.Repetible;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class Consola extends VBox implements Observer {
    private Label log = new Label();
    private Integer ALTO = 125;
    private Integer ANCHO = 125;
    private ArrayList<Repetible> observables = new ArrayList<>();

    private Algoritmo algoritmo;

    public Consola(Algoritmo algoritmo){
        this.getStylesheets().add("style.css");
        this.getStyleClass().add("panel");
        this.getChildren().add(log);
        log.getStyleClass().add("error");
        this.observables.add(algoritmo);
        this.observables.get(0).addObserver(this);

        this.algoritmo = algoritmo;
    }

    public void display(String rutaBloque){
        Image imagen = new Image(rutaBloque);
        ImageView vistaDeImagen = new ImageView(imagen);
        vistaDeImagen.setFitHeight(ALTO);
        vistaDeImagen.setFitWidth(ANCHO);
        this.getChildren().add(vistaDeImagen);
    }

    public void escribir(String texto){
        String aux = log.getText();
        log.setText(aux+"\n"+ texto);
    }

    public void limpiar() {
        getChildren().clear();
        log.setText("");
        getChildren().add(log);
    }

    public void displayRepetible(Repetible repetible) {
        HBox repetibleBox = new HBox();
        Image imagenRepetible = new Image(repetible.devolverNombre()+".png");
        ImageView vistaDeImagen = new ImageView(imagenRepetible);
        vistaDeImagen.setFitHeight(ALTO);
        vistaDeImagen.setFitWidth(ANCHO);
        repetibleBox.getChildren().add(vistaDeImagen);

        Image imagenBloque = new Image(repetible.accionesAEjecutar.get(repetible.accionesAEjecutar.size() - 1).devolverNombre()+".png");
        ImageView vistaDeImagenBloque = new ImageView(imagenBloque);
        vistaDeImagenBloque.setFitHeight(ALTO);
        vistaDeImagenBloque.setFitWidth(ANCHO);
        repetibleBox.getChildren().add(vistaDeImagenBloque);

        this.getChildren().add(repetibleBox);
    }

    public void agregarObservable(Repetible repetible){
        ObservadorRepetible observadorRepetible = new ObservadorRepetible(this,repetible);

        repetible.addObserver(observadorRepetible);
    }

    public void change(){
        display(algoritmo.accionesAEjecutar.get(algoritmo.accionesAEjecutar.size()-1).devolverNombre()+".png");
    }
}
