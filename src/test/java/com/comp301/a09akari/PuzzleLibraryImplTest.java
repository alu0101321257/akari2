/**
 * @file PuzzleLibraryImplTest.java
 * @brief Contains the unit test class for the PuzzleLibraryImpl class.
 */

package com.comp301.a09akari;

import com.comp301.a09akari.controller.*;
import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @brief Class that contains unit tests for the PuzzleLibraryImpl class.
 *
 * This class provides unit tests for the functionality of the PuzzleLibraryImpl class.
 */
public class PuzzleLibraryImplTest {

    /**
     * @brief Unit test for the addPuzzle method of the PuzzleLibraryImpl class.
     *
     * This method tests the addPuzzle method, checking if it correctly adds a puzzle to the library
     * and verifies that an IllegalArgumentException is thrown for a null puzzle.
     */
    @Test
    void addPuzzle() {
        PuzzleLibraryImpl puzzleLibrary = new PuzzleLibraryImpl();
        Puzzle puzzle = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});

        puzzleLibrary.addPuzzle(puzzle);

        assertEquals(1, puzzleLibrary.size());
        assertEquals(puzzle, puzzleLibrary.getPuzzle(0));

        // Adding null puzzle should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> puzzleLibrary.addPuzzle(null));
    }

    /**
     * @brief Unit test for the getPuzzle method of the PuzzleLibraryImpl class.
     *
     * This method tests the getPuzzle method, checking if it correctly retrieves puzzles from the library
     * and verifies that IndexOutOfBoundsException is thrown for an invalid index.
     */
    @Test
    void getPuzzle() {
        PuzzleLibraryImpl puzzleLibrary = new PuzzleLibraryImpl();
        Puzzle puzzle1 = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
        Puzzle puzzle2 = new PuzzleImpl(new int[][]{{5, 6}, {7, 8}});

        puzzleLibrary.addPuzzle(puzzle1);
        puzzleLibrary.addPuzzle(puzzle2);

        assertEquals(puzzle1, puzzleLibrary.getPuzzle(0));
        assertEquals(puzzle2, puzzleLibrary.getPuzzle(1));

        // Getting puzzle with an invalid index should throw an IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> puzzleLibrary.getPuzzle(2));
        assertThrows(IndexOutOfBoundsException.class, () -> puzzleLibrary.getPuzzle(-1));
    }

    /**
     * @brief Unit test for the size method of the PuzzleLibraryImpl class.
     *
     * This method tests the size method, checking if it correctly returns the number of puzzles in the library.
     */
    @Test
    void size() {
        PuzzleLibraryImpl puzzleLibrary = new PuzzleLibraryImpl();

        assertEquals(0, puzzleLibrary.size());

        Puzzle puzzle = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
        puzzleLibrary.addPuzzle(puzzle);

        assertEquals(1, puzzleLibrary.size());

        puzzleLibrary.addPuzzle(new PuzzleImpl(new int[][]{{5, 6}, {7, 8}}));

        assertEquals(2, puzzleLibrary.size());
    }
}

