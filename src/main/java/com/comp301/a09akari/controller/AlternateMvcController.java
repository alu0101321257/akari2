/**
 * @file AlternateMvcController.java
 * @brief Defines the AlternateMvcController interface for handling puzzle-related actions.
 * 
 * This interface includes methods for handling various puzzle-related actions and querying puzzle state.
 * It follows a classic MVC (Model-View-Controller) design.
 * 
 * @package com.comp301.a09akari.controller
 */
package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.Puzzle;
/**
 * @brief Interface for handling puzzle-related actions in an MVC architecture.
 * 
 * This interface defines methods for handling actions such as moving to the next/previous puzzle, 
 * resetting the current puzzle, and interacting with individual cells in the puzzle.
 */
public interface AlternateMvcController {
  /** 
   * @brief Handles the click action to go to the next puzzle.
   */
  void clickNextPuzzle();

  /** 
   * @brief Handles the click action to go to the next puzzle.
   */
  void clickPrevPuzzle();

  /** 
   * @brief Handles the click action to go to a random puzzle.
   */
  void clickRandPuzzle();

  /** 
   * @brief Handles the click action to reset the currently active puzzle.
   */
  void clickResetPuzzle();

  /** 
   * @brief Handles the click event on the cell at row r, column c.
   * 
   * @param r The row of the clicked cell.
   * @param c The column of the clicked cell.
   */
  void clickCell(int r, int c);
  // end of classic MVC design
  
  /** 
   * @brief Returns true if the CORRIDOR cell at row r, column c is lit.
   * 
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the CORRIDOR cell is lit, false otherwise.
   */
  boolean isLit(int r, int c);
  /** 
   * @brief Returns true if the CORRIDOR cell at row r, column c is a lamp.
   * 
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the CORRIDOR cell is a lamp, false otherwise.
   */
  
  boolean isLamp(int r, int c);
  /** 
   * @brief Returns true if the CLUE cell at row r, column c is satisfied by nearby lamps.
   * 
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the CLUE cell is satisfied, false otherwise.
   */
  boolean isClueSatisfied(int r, int c);

  /** 
   * @brief Returns true if the active puzzle is solved.
   * 
   * @return True if the puzzle is solved, false otherwise.
   */
  boolean isSolved();

  /** 
   * @brief Getter method for the active puzzle.
   * 
   * @return The currently active puzzle.
   */
  Puzzle getActivePuzzle();
}
