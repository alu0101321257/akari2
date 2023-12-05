/**
 * @file Timer.java
 * This class represents a timer for tracking elapsed time in a JavaFX application.
 */
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

    /**
     * Constructs a Timer instance.
     *
     * @param primaryStage The primary stage of the JavaFX application.
     */
    public Timer(Stage primaryStage) {
        this.startTime = System.nanoTime();
        this.decimalFormat = new DecimalFormat("#.#");
        this.primaryStage = primaryStage;
    }

    /**
     * Handles the timer update on each frame.
     *
     * @param now The current time in nanoseconds.
     */
    @Override
    public void handle(long now) {
        double elapsedTime = (now - startTime) / 1e9;

        // Perform additional actions if necessary
        // You can print the time to verify that it is updating
        System.out.println("Updated time: " + elapsedTime);
    }

    /**
     * Gets the elapsed time since the timer was started.
     *
     * @return The elapsed time in seconds.
     */
    public double getElapsedTime() {
        return Double.parseDouble(decimalFormat.format((System.nanoTime() - startTime) / 1e9));
    }

    /**
     * Displays the final time in a new window.
     */
    public void showTimeFinal() {
        // Create a new window to display the final time
        Stage timeFinalStage = new Stage();
        TimeDisplayView timeDisplayView = new TimeDisplayViewImpl();
        timeFinalStage.setScene(new Scene(timeDisplayView.render(getElapsedTime()), 300, 200));
        timeFinalStage.setTitle("Final Time");
        timeFinalStage.show();
    }
}
