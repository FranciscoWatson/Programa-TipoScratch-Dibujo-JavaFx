package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.interfaz.ventanas.Consola;
import edu.fiuba.algo3.modelo.actoresPrincipales.Juego;
import edu.fiuba.algo3.modelo.acciones.Accion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AccionEventhandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Accion accion;
    private Consola consola;

    public AccionEventhandler(Juego juego, Accion accion, Consola consola){
        this.juego = juego;
        this.accion = accion;
        this.consola = consola;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.juego.agregarAccion(accion);
        this.reproducirSonido();
    }

    private void reproducirSonido() {
        String musicFile = "src/main/resources/sonidobotonnormal.mp3";
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
    }
}