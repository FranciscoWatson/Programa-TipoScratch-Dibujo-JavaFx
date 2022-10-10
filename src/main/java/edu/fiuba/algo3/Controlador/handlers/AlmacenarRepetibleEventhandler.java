package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.interfaz.ventanas.Consola;
import edu.fiuba.algo3.modelo.actoresPrincipales.Juego;
import edu.fiuba.algo3.modelo.acciones.Repetible;
import edu.fiuba.algo3.modelo.excepciones.RepetibleNoTieneAccionesTodaviaExcepcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AlmacenarRepetibleEventhandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Consola consola;
    private Repetible repetible;

    public AlmacenarRepetibleEventhandler(Juego juego, Consola consola, Repetible repetible){
        this.juego = juego;
        this.consola = consola;
        this.repetible = repetible;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        try {
            this.juego.agregarAccion(repetible.copiar());
        }
        catch (RepetibleNoTieneAccionesTodaviaExcepcion e){
            consola.escribir(e.getMessage());
        }
        this.reproducirSonido();
    }

    private void reproducirSonido() {
        String musicFile = "src/main/resources/sonidobotonnormal.mp3";
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
    }
}