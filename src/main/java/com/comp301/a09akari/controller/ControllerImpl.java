/**
 * @file ControllerImpl.java
 * @brief Implementation of the ClassicMvcController interface for handling puzzle-related actions.
 *
 * This class implements the ClassicMvcController interface and provides functionality to handle puzzle-related actions,
 * such as moving to the next/previous puzzle, resetting the current puzzle, interacting with individual cells in the puzzle,
 * and managing time-related functionality.
 *
 * @package com.comp301.a09akari.controller
 */
package com.comp301.a09akari.controller;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.view.Timer;
import javafx.stage.Stage;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
/**
 * @brief Implementation of the ClassicMvcController interface for handling puzzle-related actions.
 */
public class ControllerImpl implements ClassicMvcController {
  private Model model;
  private Timer timer;
  /**
   * @brief Constructor for the ControllerImpl class.
   *
   * @param model The Model instance associated with the controller.
   * @param stage The JavaFX stage for managing the timer view.
   */
  public ControllerImpl(Model model, Stage stage) {
    this.model = model;
    this.timer = new Timer(stage);
    this.timer.start();
  }
  /** 
   * @brief Handles the click action to go to the next puzzle.
   * 
   * If the current puzzle is the last puzzle in the library, it wraps around to the first puzzle.
   */
  public void clickNextPuzzle() {
    if (model.getPuzzleLibrarySize() - 1 == model.getActivePuzzleIndex()) {
      model.setActivePuzzleIndex(0);
    } else {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() + 1);
    }
  }
  /** 
   * @brief Handles the click action to go to the previous puzzle.
   * 
   * If the current puzzle is the first puzzle in the library, it wraps around to the last puzzle.
   */
  public void clickPrevPuzzle() {
    if (0 == model.getActivePuzzleIndex()) {
      model.setActivePuzzleIndex(model.getPuzzleLibrarySize() - 1);
    } else {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
    }
  }
  /** 
   * @brief Handles the click action to go to a random puzzle.
   * 
   * Generates a random puzzle index and sets it as the active puzzle, ensuring it's different from the current puzzle.
   */
  public void clickRandPuzzle() {
    SecureRandom randomPuzzle = new SecureRandom(); // Compliant for security-sensitive use cases
    byte[] bytes = new byte[20];
    randomPuzzle.nextBytes(bytes);
    int randomPuzzleIndex = randomPuzzle.nextInt(model.getPuzzleLibrarySize());
    while (model.getActivePuzzleIndex() == randomPuzzleIndex) {
      randomPuzzleIndex = randomPuzzle.nextInt(model.getPuzzleLibrarySize());
    }
    model.setActivePuzzleIndex(randomPuzzleIndex);
  }
  /** 
   * @brief Handles the click action to reset the currently active puzzle.
   * 
   * Resets the currently active puzzle to its initial state.
   */
  public void clickResetPuzzle() {
    model.resetPuzzle();
  }
  /** 
   * @brief Handles the click event on the cell at row r, column c.
   * 
   * If the clicked cell is a CORRIDOR cell, toggles the cell's state between being a lamp and not being a lamp.
   * 
   * @param r The row of the clicked cell.
   * @param c The column of the clicked cell.
   */
  public void clickCell(int r, int c) {
    if (model.getActivePuzzle().getCellType(r, c) == CellType.CORRIDOR) {
      if (model.isLamp(r, c)) {
        model.removeLamp(r, c);
      } else {
        model.addLamp(r, c);
      }
    }
  }
  /** 
   * @brief Gets the elapsed time since the start of the puzzle.
   * 
   * @return The elapsed time in seconds.
   */
  @Override
  public double getElapsedTime() {
    double elapsedTime = timer.getElapsedTime();

    // Formatea el tiempo con un solo decimal
    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    return Double.parseDouble(decimalFormat.format(elapsedTime));
  }
  /** 
   * @brief Displays the current time.
   * 
   * This method is responsible for displaying or handling the current time in the context of the puzzle.
   */
  @Override
  public void getTime() {
    timer.showTimeFinal();

  }

}
