package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ControlView implements FXComponent {
  private ClassicMvcController controller;
  private Model model;

  private Label timerLabel;

  public ControlView(ClassicMvcController ac, Model m) {
    this.controller = ac;
    this.model = m;
    initialize();
  }

  private void initialize() {
    timerLabel = new Label("Tiempo: 0 segundos");

    // Configura el temporizador para actualizar el tiempo periódicamente
    new AnimationTimer() {
      @Override
      public void handle(long now) {
        updateTimerLabel();
      }
    }.start();
  }

  @Override
  public Parent render() {
    VBox format = new VBox();
    Button resetPuzzle = new Button("Reset Puzzle");
    resetPuzzle.setOnAction((ActionEvent event) -> controller.clickResetPuzzle());

    Button nextPuzzle = new Button("Next Puzzle ->");
    nextPuzzle.setOnAction((ActionEvent e) -> controller.clickNextPuzzle());

    Button prevPuzzle = new Button("Previous Puzzle <-");
    prevPuzzle.setOnAction((ActionEvent e) -> controller.clickPrevPuzzle());

    Button randPuzzle = new Button("Random");
    randPuzzle.setOnAction((ActionEvent e) -> controller.clickRandPuzzle());

    format.getChildren().addAll(prevPuzzle, nextPuzzle, randPuzzle, resetPuzzle, timerLabel);

    format.setAlignment(Pos.BASELINE_CENTER);
    return format;
  }

  // Método para actualizar el tiempo en el Label del temporizador
  public void updateTimerLabel() {
    timerLabel.setText("Tiempo: " + controller.getElapsedTime() + " segundos");
  }
}