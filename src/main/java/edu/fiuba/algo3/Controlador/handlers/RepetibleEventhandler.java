package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.interfaz.ventanas.Consola;
import edu.fiuba.algo3.modelo.acciones.Accion;
import edu.fiuba.algo3.modelo.acciones.Repetible;
import edu.fiuba.algo3.modelo.actoresPrincipales.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class RepetibleEventhandler implements EventHandler<ActionEvent> {

    private Accion accion;
    private Consola consola;
    private Repetible repetible;
    private Juego juego;

    public RepetibleEventhandler(Accion accion, Consola consola, Repetible repetible, Juego juego){
        this.accion = accion;
        this.consola = consola;
        this.repetible = repetible;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        this.reproducirSonido();
        this.repetible.almacenarAccion(accion);
    }
    private void reproducirSonido() {
        String musicFile = "src/main/resources/sonidobotonnormal.mp3";
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
    }
}