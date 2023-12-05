package com.comp301.a09akari.model;

/**
 * @file PuzzleLibrary.java
 * This interface represents a puzzle library, providing methods to manage and retrieve puzzles.
 */
public interface PuzzleLibrary {

  /**
   * Adds the given puzzle to the library, placing it as the last puzzle.
   *
   * @param puzzle The puzzle to be added to the library.
   * @throws IllegalArgumentException If a null puzzle is passed.
   */
  void addPuzzle(Puzzle puzzle);

  /**
   * Retrieves the puzzle at the specified index in the library.
   *
   * @param index The index of the puzzle to retrieve.
   * @return The puzzle at the specified index.
   * @throws IndexOutOfBoundsException If the specified index is outside the bounds of the library.
   */
  Puzzle getPuzzle(int index);

  /**
   * Returns the size of the puzzle library, which is the number of puzzles it contains.
   *
   * @return The size of the puzzle library.
   */
  int size();
}
