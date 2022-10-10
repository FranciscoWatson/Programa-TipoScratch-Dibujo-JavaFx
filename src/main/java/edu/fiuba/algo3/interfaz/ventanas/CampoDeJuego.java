package edu.fiuba.algo3.interfaz.ventanas;

import edu.fiuba.algo3.modelo.acciones.Algoritmo;
import edu.fiuba.algo3.modelo.actoresPrincipales.Juego;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CampoDeJuego extends BorderPane {

        Juego juego = new Juego();
        Consola consola = new Consola(juego.devolverAlgoritmo());
        VBox panel = new VBox();
        private ScrollPane scroll = new ScrollPane(consola);

        AreaDeDibujado areaDeDibujado = new AreaDeDibujado(juego.devolverPersonaje());
        BotonesDisponibles botonesDisponibles = new BotonesDisponibles(consola, juego);

        public CampoDeJuego() {
            this.getStylesheets().add("style.css");

            scroll.getStylesheets().add("style.css");
            scroll.getStyleClass().add("panel");

            Label titulo = new Label("Bloques Agregados");
            titulo.getStyleClass().add("titulo");

            panel.getChildren().add(titulo);
            panel.getChildren().add(scroll);
            panel.setMaxWidth(300);

            posicionarSectores();
            BorderPane.setMargin(areaDeDibujado, new Insets(20,50,50,30));
            BorderPane.setMargin(botonesDisponibles, new Insets(20,50,50,30));
            BorderPane.setMargin(consola, new Insets(75,75,75,8));
        }
        private void posicionarSectores() {
            this.setRight(botonesDisponibles);
            this.setCenter(panel);
            this.setLeft(areaDeDibujado);
        }
}
