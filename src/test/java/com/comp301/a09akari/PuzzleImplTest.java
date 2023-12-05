package com.comp301.a09akari;
import com.comp301.a09akari.controller.*;
import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PuzzleImplTest {
    @Test
    void getWidth() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        PuzzleImpl puzzle = new PuzzleImpl(board);
        assertEquals(3, puzzle.getWidth());
    }

    @Test
    void getHeight() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        PuzzleImpl puzzle = new PuzzleImpl(board);
        assertEquals(2, puzzle.getHeight());
    }

    @Test
    void getCellType() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        PuzzleImpl puzzle = new PuzzleImpl(board);

        assertEquals(CellType.CLUE, puzzle.getCellType(0, 0));
        assertEquals(CellType.CORRIDOR, puzzle.getCellType(1, 2));
        assertEquals(CellType.WALL, puzzle.getCellType(1, 1));

        assertThrows(IndexOutOfBoundsException.class, () -> puzzle.getCellType(2, 0));
    }

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
