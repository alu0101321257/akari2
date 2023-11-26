package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.text.DecimalFormat;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

public class Timer extends AnimationTimer {
    private long startTime;
    private DecimalFormat decimalFormat;
    private Stage primaryStage;

    public Timer(Stage primaryStage) {
        this.startTime = System.nanoTime();
        this.decimalFormat = new DecimalFormat("#.#");
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(long now) {
        double elapsedTime = (now - startTime) / 1e9;

        // Realiza acciones adicionales si es necesario
        // Puedes imprimir el tiempo para verificar que se está actualizando
        System.out.println("Tiempo actualizado: " + elapsedTime);
    }

    public double getElapsedTime() {
        return Double.parseDouble(decimalFormat.format((System.nanoTime() - startTime) / 1e9));
    }

    public void showTimeFinal() {
        // Crea una nueva ventana para mostrar el tiempo final
        Stage timeFinalStage = new Stage();
        TimeDisplayView timeDisplayView = new TimeDisplayViewImpl();
        timeFinalStage.setScene(new Scene(timeDisplayView.render(getElapsedTime()), 300, 200));
        timeFinalStage.setTitle("Tiempo Final");
        timeFinalStage.show();
    }
}
