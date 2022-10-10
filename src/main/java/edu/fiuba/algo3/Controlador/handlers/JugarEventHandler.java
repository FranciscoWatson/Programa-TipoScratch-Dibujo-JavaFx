package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.interfaz.ventanas.CampoDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JugarEventHandler implements EventHandler<ActionEvent> {
    private App app;
    private Stage stage;

    public JugarEventHandler(Stage stage){
        this.stage = stage;
    }
    @Override
    public void handle(ActionEvent actionEvent){
        CampoDeJuego vistaPrincipal = new CampoDeJuego();
        Scene nuevaScena = new Scene(vistaPrincipal);
        stage.setScene(nuevaScena);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setMinHeight(600);
        stage.setMinWidth(1200);
    }
}
