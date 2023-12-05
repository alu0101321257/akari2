package com.comp301.a09akari.model;

/**
 * @file Puzzle.java
 * This interface represents a puzzle, defining methods to retrieve information about its size,
 * cell types, and clue numbers.
 */
public interface Puzzle {

  /**
   * Getter method for the width of the puzzle (i.e., the number of columns it has).
   *
   * @return The width of the puzzle.
   */
  int getWidth();

  /**
   * Getter method for the height of the puzzle (i.e., the number of rows it has).
   *
   * @return The height of the puzzle.
   */
  int getHeight();

  /**
   * Getter method for the type of the cell located at row r, column c.
   *
   * @param r The row index of the cell.
   * @param c The column index of the cell.
   * @return The type of the cell at the specified position.
   * @throws IndexOutOfBoundsException If r or c is out of bounds.
   */
  CellType getCellType(int r, int c);

  /**
   * Getter method for the clue number of the cell located at row r, column c.
   *
   * @param r The row index of the cell.
   * @param c The column index of the cell.
   * @return The clue number of the cell at the specified position.
   * @throws IndexOutOfBoundsException If r or c is out of bounds.
   * @throws IllegalArgumentException If the cell is not of type CLUE.
   */
  int getClue(int r, int c);
}
