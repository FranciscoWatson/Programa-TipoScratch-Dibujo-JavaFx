package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ventanas.VentanaPresentacion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

/**
 * JavaFX App
 */
public class App extends Application {
    private static final String RUTA_ICONO = "logo.png";
    private static final int ANCHO = 500;
    private static final int ALTO = 500;
    private static final String nombreVentana = "Tp2 - AlgoBlocks - Grupo 6";


    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) {
        String musicFile = "src/main/resources/musicadefondo.mp3";
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        VentanaPresentacion ventanaPresentacion = new VentanaPresentacion(stage);
        Scene presentacion = new Scene(ventanaPresentacion, ANCHO, ALTO);

        stage.setScene(presentacion);
        stage.setTitle(nombreVentana);
        Image imagen = new Image(RUTA_ICONO);
        stage.getIcons().add(imagen);
        stage.show();
    }
}