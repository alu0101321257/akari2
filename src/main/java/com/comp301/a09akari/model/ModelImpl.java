/**
 * @file ModelImpl.java
 * @brief Implementation of the Model interface for puzzle-related operations.
 *
 * This class implements the Model interface, providing methods to interact with the puzzle model, including adding
 * and removing lamps, checking the status of cells, managing the active puzzle, and observing changes in the model.
 *
 * @package com.comp301.a09akari.model
 */
package com.comp301.a09akari.model;

import java.util.ArrayList;
import java.util.List;
/**
 * @brief Implementation of the Model interface for puzzle-related operations.
 *
 * This class implements the Model interface, providing methods to interact with the puzzle model, including adding
 * and removing lamps, checking the status of cells, managing the active puzzle, and observing changes in the model.
 */
public class ModelImpl implements Model {
  private PuzzleLibrary library; /**< Reference to the puzzle library */
  private Puzzle activePuzzle; /**< Reference to the active puzzle */
  private int[][] lampBoard; /**< 2D array to represent the placement of lamps on the puzzle */
  private int counter; /**< Counter to track the active puzzle index */
  private List<ModelObserver> observers = new ArrayList<>(); /**< List of observers for model updates */

  /**
   * @brief Constructor for the ModelImpl class.
   *
   * @param library The puzzle library to initialize the model with.
   * @throws IllegalArgumentException if the provided library is null.
   */
  public ModelImpl(PuzzleLibrary library) {
    if (library == null) {
      throw new IllegalArgumentException();
    }
    this.library = library;
    this.counter = 0;
    this.activePuzzle = library.getPuzzle(counter);
    lampBoard = new int[activePuzzle.getHeight()][activePuzzle.getHeight()];
  }
  /** 
   * @brief Adds a lamp to the active puzzle in the cell at row r, column c.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  public void addLamp(int r, int c) {
    if (r < 0 || c < 0 || r >= activePuzzle.getHeight() || c >= activePuzzle.getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (activePuzzle.getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }
    lampBoard[r][c] = 1;
    notifyObservers();
  }
  /** 
   * @brief Removes a lamp from the active puzzle at the cell at row r, column c.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  public void removeLamp(int r, int c) {
    if (r < 0 || c < 0 || r >= activePuzzle.getHeight() || c >= activePuzzle.getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (activePuzzle.getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }
    lampBoard[r][c] = 0;
    notifyObservers();
  }
  /**
   * @brief Checks if the cell at row r, column c in the active puzzle is currently illuminated by a nearby lamp.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the cell is illuminated, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  public boolean isLit(int r, int c) {
    if (r < 0 || c < 0 || r >= activePuzzle.getHeight() || c >= activePuzzle.getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (activePuzzle.getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }
    if (lampBoard[r][c] == 1) {
      return true;
    }
    int left = c;
    int right = c;
    int up = r;
    int down = r;

    while (left >= 0) {
      if (activePuzzle.getCellType(r, left) != CellType.CORRIDOR) {
        break;
      }
      if (lampBoard[r][left] == 1) {
        return true;
      }
      left--;
    }

    while (right < activePuzzle.getWidth()) {
      if (activePuzzle.getCellType(r, right) != CellType.CORRIDOR) {
        break;
      }
      if (lampBoard[r][right] == 1) {
        return true;
      }
      right++;
    }

    while (up >= 0) {
      if (activePuzzle.getCellType(up, c) != CellType.CORRIDOR) {
        break;
      }
      if (lampBoard[up][c] == 1) {
        return true;
      }
      up--;
    }

    while (down < activePuzzle.getHeight()) {
      if (activePuzzle.getCellType(down, c) != CellType.CORRIDOR) {
        break;
      }
      if (lampBoard[down][c] == 1) {
        return true;
      }
      down++;
    }

    return false;
  }
  /**
   * @brief Checks if the cell at row r, column c in the active puzzle contains a user-placed lamp.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the cell contains a lamp, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CORRIDOR.
   */
  public boolean isLamp(int r, int c) {
    if (r < 0 || c < 0 || r >= activePuzzle.getHeight() || c >= activePuzzle.getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (activePuzzle.getCellType(r, c) != CellType.CORRIDOR) {
      throw new IllegalArgumentException();
    }

    if (lampBoard[r][c] == 1) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * @brief Checks if the cell at row r, column c in the active puzzle contains a user-placed lamp that is illegally placed.
   *
   * @param r The row of the cell.
   * @param c The column of the cell.
   * @return True if the cell contains an illegally placed lamp, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell does not currently contain a lamp.
   */
  public boolean isLampIllegal(int r, int c) {
    if (r < 0 || c < 0 || r >= activePuzzle.getHeight() || c >= activePuzzle.getWidth()) {
      throw new IndexOutOfBoundsException();
    }
    if (!isLamp(r, c)) {
      throw new IllegalArgumentException();
    }
    // checking all directions for lamp or wall/clue
    for (int i = r - 1; i >= 0; i--) {
      if ((activePuzzle.getCellType(i, c) == CellType.CLUE)
          || (activePuzzle.getCellType(i, c) == CellType.WALL)) {
        break;
      }
      if (isLamp(i, c)) {
        return true;
      }
    }
    for (int i = c - 1; i >= 0; i--) {
      if ((activePuzzle.getCellType(r, i) == CellType.CLUE)
          || (activePuzzle.getCellType(r, i) == CellType.WALL)) {
        break;
      }
      if (isLamp(r, i)) {
        return true;
      }
    }
    for (int i = r + 1; i < activePuzzle.getHeight(); i++) {
      if ((activePuzzle.getCellType(i, c) == CellType.CLUE)
          || (activePuzzle.getCellType(i, c) == CellType.WALL)) {
        break;
      }
      if (isLamp(i, c)) {
        return true;
      }
    }
    for (int i = c + 1; i < activePuzzle.getWidth(); i++) {
      if ((activePuzzle.getCellType(r, i) == CellType.CLUE)
          || (activePuzzle.getCellType(r, i) == CellType.WALL)) {
        break;
      }
      if (isLamp(r, i)) {
        return true;
      }
    }
    return false;
  }
  /** 
   * @brief Getter method for the current active Puzzle instance.
   *
   * @return The active puzzle.
   */
  public Puzzle getActivePuzzle() {
    return activePuzzle;
  }
  /** 
   * @brief Getter method for the active puzzle index.
   *
   * @return The index of the active puzzle.
   */
  public int getActivePuzzleIndex() {
    return counter;
  }
  /**
   * @brief Setter method for the current active Puzzle index.
   *
   * @param index The new index for the active puzzle.
   * @throws IndexOutOfBoundsException if the passed index is out of bounds.
   */
  public void setActivePuzzleIndex(int index) {
    if (index < 0 || index >= getPuzzleLibrarySize()) {
      throw new IndexOutOfBoundsException();
    } else {
      this.counter = index;
      this.activePuzzle = library.getPuzzle(index);
      lampBoard = new int[activePuzzle.getHeight()][activePuzzle.getWidth()];
      notifyObservers();
    }
  }
  /**
   * @brief Getter method for the number of puzzles contained in the internal PuzzleLibrary.
   *
   * @return The size of the puzzle library.
   */
  public int getPuzzleLibrarySize() {
    return library.size();
  }
  /** 
   * @brief Resets the active puzzle by removing all lamps which have been placed.
   */
  public void resetPuzzle() {
    lampBoard = new int[activePuzzle.getHeight()][activePuzzle.getWidth()];
    notifyObservers();
  }
  /**
   * @brief Checks if the active puzzle is solved.
   *
   * @return True if the puzzle is solved, false otherwise.
   */
  public boolean isSolved() {
    for (int row = 0; row < activePuzzle.getHeight(); row++) {
      for (int col = 0; col < activePuzzle.getWidth(); col++) {
        if (activePuzzle.getCellType(row, col) == CellType.CLUE) {
          if (!isClueSatisfied(row, col)) {
            return false;
          }
        } else if (activePuzzle.getCellType(row, col) == CellType.CORRIDOR) {
          if (isLamp(row, col)) {
            if (isLampIllegal(row, col)) {
              return false;
            }
          }
          if (!isLit(row, col)) {
            return false;
          }
        }
      }
    }

    return true;
  }
  /**
   * @brief Checks if the clue at row r, column c of the active puzzle is satisfied.
   *
   * @param r The row of the clue.
   * @param c The column of the clue.
   * @return True if the clue is satisfied, false otherwise.
   * @throws IndexOutOfBoundsException if r or c is out of bounds.
   * @throws IllegalArgumentException if the cell is not type CLUE.
   */
  public boolean isClueSatisfied(int r, int c) {
    if (r < 0 || c < 0 || c >= activePuzzle.getWidth() || r >= activePuzzle.getHeight()) {
      throw new IndexOutOfBoundsException();
    } else if (activePuzzle.getCellType(r, c) != CellType.CLUE) {
      throw new IllegalArgumentException();
    }
    int clue = activePuzzle.getClue(r, c);
    if (r - 1 >= 0) {
      if (activePuzzle.getCellType(r - 1, c) == CellType.CORRIDOR) {
        if (isLamp(r - 1, c)) {
          clue--;
        }
      }
    }
    if (c - 1 >= 0) {
      if (activePuzzle.getCellType(r, c - 1) == CellType.CORRIDOR) {
        if (isLamp(r, c - 1)) {
          clue--;
        }
      }
    }
    if (c + 1 < activePuzzle.getWidth()) {
      if (activePuzzle.getCellType(r, c + 1) == CellType.CORRIDOR) {
        if (isLamp(r, c + 1)) {
          clue--;
        }
      }
    }
    if (r + 1 < activePuzzle.getHeight()) {
      if (activePuzzle.getCellType(r + 1, c) == CellType.CORRIDOR) {
        if (isLamp(r + 1, c)) {
          clue--;
        }
      }
    }

    return clue == 0;
  }
  /** 
   * @brief Adds an observer to the model.
   *
   * @param observer The observer to add.
   */
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }
  /** 
   * @brief Removes an observer from the model.
   *
   * @param observer The observer to remove.
   */
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }
  /** 
   * @brief Notifies all observers of the model about changes.
   */
  public void notifyObservers() {
    for (ModelObserver o : observers) {
      o.update(this);
    }
  }
}
