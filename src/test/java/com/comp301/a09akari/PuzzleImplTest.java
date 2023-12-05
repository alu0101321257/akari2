/**
 * @file PuzzleImplTest.java
 * @brief Contains the unit test class for the PuzzleImpl class.
 */

package com.comp301.a09akari;

import com.comp301.a09akari.controller.*;
import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @brief Class that contains unit tests for the PuzzleImpl class.
 *
 * This class provides unit tests for the functionality of the PuzzleImpl class.
 */
public class PuzzleImplTest {

    /**
     * @brief Unit test for the getWidth method of the PuzzleImpl class.
     *
     * This method tests the getWidth method, checking if it correctly returns the width of the puzzle.
     */
    @Test
    void getWidth() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        PuzzleImpl puzzle = new PuzzleImpl(board);
        assertEquals(3, puzzle.getWidth());
    }

    /**
     * @brief Unit test for the getHeight method of the PuzzleImpl class.
     *
     * This method tests the getHeight method, checking if it correctly returns the height of the puzzle.
     */
    @Test
    void getHeight() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        PuzzleImpl puzzle = new PuzzleImpl(board);
        assertEquals(2, puzzle.getHeight());
    }

    /**
     * @brief Unit test for the getCellType method of the PuzzleImpl class.
     *
     * This method tests the getCellType method, checking if it correctly returns the type of a specific cell.
     * It also verifies that an IndexOutOfBoundsException is thrown for an invalid index.
     */
    @Test
    void getCellType() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        PuzzleImpl puzzle = new PuzzleImpl(board);

        assertEquals(CellType.CLUE, puzzle.getCellType(0, 0));
        assertEquals(CellType.CORRIDOR, puzzle.getCellType(1, 2));
        assertEquals(CellType.WALL, puzzle.getCellType(1, 1));

        assertThrows(IndexOutOfBoundsException.class, () -> puzzle.getCellType(2, 0));
    }

    /**
     * @brief Unit test for the getClue method of the PuzzleImpl class.
     *
     * This method tests the getClue method, checking if it correctly returns the clue value of a specific cell.
     * It also verifies that an IndexOutOfBoundsException is thrown for an invalid index, and an IllegalArgumentException
     * is thrown for a non-CLUE cell.
     */
    @Test
    void getClue() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        PuzzleImpl puzzle = new PuzzleImpl(board);

        assertEquals(1, puzzle.getClue(0, 0));
        assertEquals(4, puzzle.getClue(1, 0));

        assertThrows(IndexOutOfBoundsException.class, () -> puzzle.getClue(2, 0));
        assertThrows(IllegalArgumentException.class, () -> puzzle.getClue(1, 2));
    }
}
