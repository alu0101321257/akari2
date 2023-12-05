package com.comp301.a09akari;
import com.comp301.a09akari.controller.*;
import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuzzleLibraryImplTest {

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
