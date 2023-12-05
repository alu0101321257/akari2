/**
 * @file ControlView.java
 * @brief View class for the control panel of the Akari Puzzle Game.
 *
 * This class implements the FXComponent interface to create a control panel view for the Akari Puzzle Game.
 *
 * @package com.comp301.a09akari.view
 */
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
/**
 * @brief View class for the control panel of the Akari Puzzle Game.
 *
 * This class implements the FXComponent interface to create a control panel view for the Akari Puzzle Game.
 */
public class ControlView implements FXComponent {
 private ClassicMvcController controller; /**< Controller instance for handling user interactions */
 private Model model; /**< Model instance to interact with the game model */
 private Label timerLabel; /**< Label for displaying the elapsed time in the game */
  /**
   * @brief Constructor for the ControlView class.
   *
   * @param ac ClassicMvcController instance for handling user interactions.
   * @param m Model instance to interact with the game model.
   */
  public ControlView(ClassicMvcController ac, Model m) {
    this.controller = ac;
    this.model = m;
    initialize();
  }
  /**
   * @brief Initializes the ControlView by setting up the timer label and animation timer.
   */
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
  /**
   * @brief Renders the control panel view.
   *
   * @return The root node for the control panel view.
   */
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

  /**
   * @brief Updates the timer label with the elapsed time.
   */
  public void updateTimerLabel() {
    timerLabel.setText("Tiempo: " + controller.getElapsedTime() + " segundos");
  }
}
