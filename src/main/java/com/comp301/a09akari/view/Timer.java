package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.text.DecimalFormat;

import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer {
    private long startTime;
    private DecimalFormat decimalFormat;


    public Timer() {
        this.startTime = System.nanoTime();
        this.decimalFormat = new DecimalFormat("#.#");
    }

    @Override
    public void handle(long now) {
        double elapsedTime = (now - startTime) / 1e9;

        // Realiza acciones adicionales si es necesario
        // Puedes imprimir el tiempo para verificar que se está actualizando
        System.out.println("Tiempo actualizado: " + elapsedTime);
    }

    public double getElapsedTime() {
        return (System.nanoTime() - startTime) / 1e9;
    }
}
