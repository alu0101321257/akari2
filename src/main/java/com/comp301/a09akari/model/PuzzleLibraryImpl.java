/**
 * @file PuzzleLibraryImpl.java
 * @brief Implementation of the PuzzleLibrary interface for managing a collection of puzzles.
 *
 * This class implements the PuzzleLibrary interface, providing methods to add puzzles, retrieve puzzles by index,
 * and get the size of the library.
 *
 * @package com.comp301.a09akari.model
 */
package com.comp301.a09akari.model;

import java.util.ArrayList;
import java.util.List;
/**
 * @brief Implementation of the PuzzleLibrary interface for managing a collection of puzzles.
 *
 * This class implements the PuzzleLibrary interface, providing methods to add puzzles, retrieve puzzles by index,
 * and get the size of the library.
 */
public class PuzzleLibraryImpl implements PuzzleLibrary {
  private final List<Puzzle> puzzles;
  /**
   * @brief Constructor for the PuzzleLibraryImpl class.
   */
  public PuzzleLibraryImpl() {
    this.puzzles = new ArrayList<>();
  }
  /**
   * @brief Adds a puzzle to the library.
   *
   * @param puzzle The puzzle to add.
   * @throws IllegalArgumentException if the provided puzzle is null.
   */
  @Override
  public void addPuzzle(Puzzle puzzle) {
    if (puzzle == null) {
      throw new IllegalArgumentException("Cannot add null Puzzle to the library");
    }
    puzzles.add(puzzle);
  }
  /**
   * @brief Gets a puzzle from the library by index.
   *
   * @param index The index of the puzzle to retrieve.
   * @return The puzzle at the specified index.
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  @Override
  public Puzzle getPuzzle(int index) {
    return puzzles.get(index);
  }
  /**
   * @brief Gets the size of the puzzle library.
   *
   * @return The number of puzzles in the library.
   */
  @Override
  public int size() {
    return puzzles.size();
  }
}
