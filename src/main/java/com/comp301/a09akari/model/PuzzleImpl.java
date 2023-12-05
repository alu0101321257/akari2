/**
 * @file PuzzleImpl.java
 * @brief Implementation of the Puzzle interface for representing a puzzle board.
 *
 * This class implements the Puzzle interface, providing methods to access information about the puzzle board,
 * including dimensions, cell types, and clues.
 *
 * @package com.comp301.a09akari.model
 */
package com.comp301.a09akari.model;
/**
 * @brief Implementation of the Puzzle interface for representing a puzzle board.
 *
 * This class implements the Puzzle interface, providing methods to access information about the puzzle board,
 * including dimensions, cell types, and clues.
 */
public class PuzzleImpl implements Puzzle {
  int[][] board;
  /**
   * @brief Constructor for the PuzzleImpl class.
   *
   * @param board The 2D array representing the puzzle board.
   */
  public PuzzleImpl(int[][] board) {
    this.board = board;
  }
  /**
   * @brief Gets the width of the puzzle board.
   *
   * @return The width of the puzzle board.
   */
  public int getWidth() {
    return this.board[0].length;
  }
  /**
   * @brief Gets the height of the puzzle board.
   *
   * @return The height of the puzzle board.
   */
  public int getHeight() {
    return this.board.length;
  }
  /**
   * @brief Gets the cell type at the specified position on the puzzle board.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return The cell type at the specified position.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   */
  public CellType getCellType(int r, int c) {
    if (this.board[r][c] > 6 || this.board[r][c] < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (this.board[r][c] == 6) {
      return CellType.CORRIDOR;
    }
    if (this.board[r][c] == 5) {
      return CellType.WALL;
    }
    if (this.board[r][c] <= 4 && this.board[r][c] >= 0) {
      return CellType.CLUE;
    }
    return null;
  }
  /**
   * @brief Gets the clue value at the specified position on the puzzle board.
   *
   * @param r The row of the clue.
   * @param c The column of the clue.
   * @return The clue value at the specified position.
   * @throws IllegalArgumentException if the cell is a wall or corridor.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   */
  public int getClue(int r, int c) {
    if (this.board[r][c] == 5 || this.board[r][c] == 6) {
      throw new IllegalArgumentException();
    }
    if (this.board[r][c] > 4 || this.board[r][c] < 0) {
      throw new IndexOutOfBoundsException();
    }
    return this.board[r][c];
  }
}
