package edu.fiuba.algo3.interfaz.ventanas;

import edu.fiuba.algo3.Controlador.observables.Observer;
import edu.fiuba.algo3.modelo.actoresPrincipales.Personaje;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;

public class AreaDeDibujado extends VBox implements Observer {

    private final Personaje personaje;

    private final NumberAxis xAxis = new NumberAxis(-5,5,1);
    private final NumberAxis yAxis = new NumberAxis(-5,5,1);
    private ArrayList<XYChart.Series> seriePosiciones = new ArrayList<>();

    private LineChart lineChart = new LineChart(xAxis,yAxis);

    public AreaDeDibujado(Personaje personaje){
        this.getStylesheets().add("style.css");
        this.getStyleClass().add("panel");

        Label titulo = new Label("Tablero");
        titulo.getStyleClass().add("titulo");
        this.getChildren().add(titulo);

        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        seriePosiciones.add(new XYChart.Series());
        this.getChildren().add(lineChart);
        this.personaje = personaje;

        personaje.addObserver(this);

        this.lineChart.getData().add(seriePosiciones.get(seriePosiciones.size()-1));
        this.lineChart.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        this.lineChart.setLegendVisible(false);
    }

    public void nuevaSerie(){
        seriePosiciones.add(new XYChart.Series());
        this.lineChart.getData().add(seriePosiciones.get(seriePosiciones.size()-1));
    }

    public void change(){
        if(!personaje.pincelAbajo()){
            nuevaSerie();
        }
        seriePosiciones.get(seriePosiciones.size()-1).getData().add(new XYChart.Data(personaje.devolverPosicion().devolverColumna(), personaje.devolverPosicion().devolverFila()));
        columnas.add(personaje.devolverPosicion().devolverColumna());
        filas.add(personaje.devolverPosicion().devolverFila());
        xAxis.setLowerBound(Math.min(xAxis.getLowerBound(),Collections.min(columnas) -1));
        xAxis.setUpperBound(Math.max(xAxis.getUpperBound(),Collections.max(columnas) +1));
        yAxis.setLowerBound(Math.min(yAxis.getLowerBound(),Collections.min(filas) -1));
        yAxis.setUpperBound(Math.max(yAxis.getUpperBound(),Collections.max(filas) +1));
    }

    private ArrayList<Integer> columnas = new ArrayList<>();
    private ArrayList<Integer> filas = new ArrayList<>();
}
