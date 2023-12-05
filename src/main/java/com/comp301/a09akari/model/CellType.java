/**
 * @file CellType.java
 * @brief Enumerates different types of cells in a puzzle.
 *
 * This enum defines various types of cells that can exist in a puzzle, including CLUE, CORRIDOR, and WALL.
 *
 * @package com.comp301.a09akari.model
 */

package com.comp301.a09akari.model;

/**
 * @brief Enumerates different types of cells in a puzzle.
 *
 * This enum represents the possible types of cells that can be present in a puzzle, providing clarity for
 * distinguishing between different cell types such as CLUE, CORRIDOR, and WALL.
 */
public enum CellType {
  CLUE,      /**< Represents a clue cell in the puzzle. */
  CORRIDOR,  /**< Represents a corridor cell in the puzzle. */
  WALL       /**< Represents a wall cell in the puzzle. */
}
