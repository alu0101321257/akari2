/**
 * @file Model.java
 * @brief Interface defining the behavior of a puzzle model.
 *
 * This interface outlines the methods necessary for interacting with a puzzle model, including adding and removing lamps,
 * checking the status of cells, managing the active puzzle, and observing changes in the model.
 *
 * @package com.comp301.a09akari.model
 */
package com.comp301.a09akari.model;
/**
 * @brief Interface defining the behavior of a puzzle model.
 *
 * This interface outlines the methods necessary for interacting with a puzzle model, including adding and removing lamps,
 * checking the status of cells, managing the active puzzle, and observing changes in the model.
 */
public interface Model {
  /**
   * @brief Adds a lamp to the active puzzle in the cell at row r, column c.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  void addLamp(int r, int c);

  /**
   * @brief Removes a lamp from the active puzzle at the cell at row r, column c.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  void removeLamp(int r, int c);

  /**
   * @brief Checks if the cell at row r, column c in the active puzzle is currently illuminated by a nearby lamp.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the cell is illuminated, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  boolean isLit(int r, int c);

  /**
   * @brief Checks if the cell at row r, column c in the active puzzle contains a user-placed lamp.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the cell contains a lamp, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  boolean isLamp(int r, int c);

  /**
   * @brief Checks if the cell at row r, column c in the active puzzle contains a user-placed lamp that is illegally placed.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the cell contains an illegally placed lamp, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell does not currently contain a lamp.
   */
  boolean isLampIllegal(int r, int c);

  /** 
   * @brief Getter method for the current active Puzzle instance.
   *
   * @return The active puzzle.
   */
  Puzzle getActivePuzzle();

  /** 
   * @brief Getter method for the active puzzle index.
   *
   * @return The index of the active puzzle.
   */
  int getActivePuzzleIndex();

  /**
   * @brief Setter method for the current active Puzzle index.
   *
   * @param index The new index for the active puzzle.
   * @throws IndexOutOfBoundsException if the passed index is out of bounds.
   */
  void setActivePuzzleIndex(int index);

  
  /**
   * @brief Getter method for the number of puzzles contained in the internal PuzzleLibrary.
   *
   * @return The size of the puzzle library.
   */
  int getPuzzleLibrarySize();

  /** 
   * @brief Resets the active puzzle by removing all lamps which have been placed.
   */
  void resetPuzzle();

  /**
   * @brief Checks if the active puzzle is solved.
   *
   * @return True if the puzzle is solved, false otherwise.
   */
  boolean isSolved();

  /**
   * @brief Checks if the clue at row r, column c of the active puzzle is satisfied.
   *
   * @param r The row of the clue.
   * @param c The column of the clue.
   * @return True if the clue is satisfied, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CLUE.
   */
  boolean isClueSatisfied(int r, int c);

  /** 
   * @brief Adds an observer to the model.
   *
   * @param observer The observer to add.
   */
  void addObserver(ModelObserver observer);

  /** 
   * @brief Removes an observer from the model.
   *
   * @param observer The observer to remove.
   */
  void removeObserver(ModelObserver observer);
}
