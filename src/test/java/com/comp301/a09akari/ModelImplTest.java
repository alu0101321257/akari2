/**
 * @file ModelImplTest.java
 * @brief Contains the unit test class for the ModelImpl class.
 */

package com.comp301.a09akari;

import com.comp301.a09akari.controller.*;
import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @brief Class that contains unit tests for the ModelImpl class.
 *
 * This class provides unit tests for the functionality of the ModelImpl class.
 */
class ModelImplTest {

    /**
     * @brief Unit test for the constructor of the ModelImpl class.
     *
     * This method tests the constructor of the ModelImpl class. It checks if the constructor
     * initializes the model with the correct active puzzle, active puzzle index, and puzzle library size.
     * It also checks that the constructor throws an IllegalArgumentException for a null library.
     */
    @Test
    void constructor() {
        PuzzleLibrary library = new PuzzleLibraryImpl();
        Puzzle puzzle = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
        library.addPuzzle(puzzle);

        Model model = new ModelImpl(library);

        assertEquals(puzzle, model.getActivePuzzle());
        assertEquals(0, model.getActivePuzzleIndex());
        assertEquals(1, model.getPuzzleLibrarySize());

        // Constructor should throw an IllegalArgumentException for a null library
        assertThrows(IllegalArgumentException.class, () -> new ModelImpl(null));
    }

    /**
     * @brief Unit test for the addLamp method of the ModelImpl class.
     *
     * This method tests the addLamp method, checking that lamps can be added to valid corridor cells,
     * and verifying that exceptions are thrown for invalid corridor cells or indices.
     */
    @Test
    void addLamp() {
        PuzzleLibrary library = new PuzzleLibraryImpl();
        Puzzle puzzle = new PuzzleImpl(SamplePuzzles.PUZZLE_05);
        library.addPuzzle(puzzle);

        Model model = new ModelImpl(library);

        // Adding a lamp to a valid corridor cell
        model.addLamp(2, 1);
        assertTrue(model.isLamp(2, 1));

        // Adding a lamp to a non-corridor cell should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> model.addLamp(0, 2));

        // Adding a lamp to an invalid index should throw an IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> model.addLamp(8, 8));
    }

    /**
     * @brief Unit test for the removeLamp method of the ModelImpl class.
     *
     * This method tests the removeLamp method, checking that lamps can be added and removed successfully,
     * and verifying that exceptions are thrown for invalid corridor cells or indices.
     */
    @Test
    void removeLamp() {
        PuzzleLibrary library = new PuzzleLibraryImpl();
        Puzzle puzzle = new PuzzleImpl(SamplePuzzles.PUZZLE_05);
        library.addPuzzle(puzzle);

        Model model = new ModelImpl(library);

        // Adding a lamp and then removing it
        model.addLamp(2, 1);
        assertTrue(model.isLamp(2, 1));
        model.removeLamp(2, 1);
        assertFalse(model.isLamp(2, 1));

        // Removing a lamp from a non-corridor cell should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> model.removeLamp(0, 2));

        // Removing a lamp from an invalid index should throw an IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> model.removeLamp(8, 8));
    }

    /**
     * @brief Unit test for the isLit method of the ModelImpl class.
     *
     * This method tests the isLit method, checking if lamps properly light up corridors,
     * and verifying that exceptions are thrown for invalid corridor cells or indices.
     */
    @Test
    void isLit() {
        PuzzleLibrary library = new PuzzleLibraryImpl();
        Puzzle puzzle = new PuzzleImpl(SamplePuzzles.PUZZLE_05);
        library.addPuzzle(puzzle);

        Model model = new ModelImpl(library);

        // Lamp in the middle should light up the corridor
        model.addLamp(2, 0);
        assertTrue(model.isLit(2, 0));

        // Adding a lamp to a non-corridor cell should throw an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> model.addLamp(0, 2));

        // Checking an invalid index should throw an IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> model.isLit(8, 8));
    }
}

