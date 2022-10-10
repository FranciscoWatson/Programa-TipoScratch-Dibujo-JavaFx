package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.interfaz.ventanas.Consola;
import edu.fiuba.algo3.modelo.actoresPrincipales.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class LimpiarEventhandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private Consola consola;

    public LimpiarEventhandler(Juego juego, Consola consola){
        this.juego = juego;
        this.consola = consola;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.juego.limpiar();
        this.consola.limpiar();
        this.reproducirSonido();
    }

    private void reproducirSonido() {
        String musicFile = "src/main/resources/sonidobotonnormal.mp3";
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
    }
}
