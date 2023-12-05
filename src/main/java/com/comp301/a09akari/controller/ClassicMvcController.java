/**
 * @file ClassicMvcController.java
 * @brief Defines the ClassicMvcController interface for handling puzzle-related actions.
 * 
 * This interface includes methods for handling various puzzle-related actions in a classic MVC (Model-View-Controller) design.
 * 
 * @package com.comp301.a09akari.controller
 */
package com.comp301.a09akari.controller;
/**
 * @brief Interface for handling puzzle-related actions in a classic MVC architecture.
 * 
 * This interface defines methods for handling actions such as moving to the next/previous puzzle, 
 * resetting the current puzzle, interacting with individual cells in the puzzle, and managing time-related functionality.
 */
public interface ClassicMvcController {
  /** 
   * @brief Handles the click action to go to the next puzzle.
   * 
   * This method is called when the user clicks to move to the next puzzle in the sequence.
   */
  void clickNextPuzzle();

  /** 
   * @brief Handles the click action to go to the previous puzzle.
   * 
   * This method is called when the user clicks to move to the previous puzzle in the sequence.
   */
  void clickPrevPuzzle();

  /** 
   * @brief Handles the click action to go to a random puzzle.
   * 
   * This method is called when the user clicks to move to a randomly selected puzzle.
   */
  void clickRandPuzzle();

  /** 
   * @brief Handles the click action to reset the currently active puzzle.
   * 
   * This method is called when the user clicks to reset the currently active puzzle to its initial state.
   */
  void clickResetPuzzle();

  /** 
   * @brief Handles the click event on the cell at row r, column c.
   * 
   * This method is called when the user clicks on a specific cell within the puzzle grid.
   * 
   * @param r The row of the clicked cell.
   * @param c The column of the clicked cell.
   */
  void clickCell(int r, int c);
  /**
   * @brief Gets the elapsed time since the start of the puzzle.
   * 
   * This method retrieves the elapsed time since the start of the puzzle.
   * 
   * @return The elapsed time in seconds.
   */
  double getElapsedTime();
  /**
   * @brief Displays the current time.
   * 
   * This method is responsible for displaying or handling the current time in the context of the puzzle.
   */
  void getTime();
}
