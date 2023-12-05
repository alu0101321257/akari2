// package com.comp301.a09akari;
// import com.comp301.a09akari.controller.*;
// import com.comp301.a09akari.model.*;
// import com.comp301.a09akari.view.*;
// import javafx.stage.Stage;
// import org.junit.jupiter.api.Test;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.layout.BorderPane;
// import static org.junit.jupiter.api.Assertions.*;

// import javax.swing.text.View;

// class ControllerImplTest {

//     @Test
//     void constructor() {
//         PuzzleLibrary library = new PuzzleLibraryImpl();
//         Puzzle puzzle = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
//         library.addPuzzle(puzzle);
//         Model model = new ModelImpl(library);
//         Stage stage = new Stage();

//         ControllerImpl controller = new ControllerImpl(model, stage);
      
//         assertNotNull(controller.getElapsedTime());
        
//     }

    // @Test
    // void clickNextPuzzle() {
    //     PuzzleLibrary library = new PuzzleLibraryImpl();
    //     Puzzle puzzle1 = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
    //     Puzzle puzzle2 = new PuzzleImpl(new int[][]{{5, 6}, {7, 8}});
    //     library.addPuzzle(puzzle1);
    //     library.addPuzzle(puzzle2);
    //     Model model = new ModelImpl(library);
    //     Stage stage = new Stage();
    //     ControllerImpl controller = new ControllerImpl(model, stage);

    //     assertEquals(puzzle1, model.getActivePuzzle());

    //     controller.clickNextPuzzle();

    //     assertEquals(puzzle2, model.getActivePuzzle());

    //     controller.clickNextPuzzle();  // Should loop back to the first puzzle
    //     assertEquals(puzzle1, model.getActivePuzzle());
    // }

    // @Test
    // void clickPrevPuzzle() {
    //     PuzzleLibrary library = new PuzzleLibraryImpl();
    //     Puzzle puzzle1 = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
    //     Puzzle puzzle2 = new PuzzleImpl(new int[][]{{5, 6}, {7, 8}});
    //     library.addPuzzle(puzzle1);
    //     library.addPuzzle(puzzle2);
    //     Model model = new ModelImpl(library);
    //     Stage stage = new Stage();
    //     ControllerImpl controller = new ControllerImpl(model, stage);

    //     assertEquals(puzzle1, model.getActivePuzzle());

    //     controller.clickPrevPuzzle();  // Should loop back to the last puzzle
    //     assertEquals(puzzle2, model.getActivePuzzle());

    //     controller.clickPrevPuzzle();
    //     assertEquals(puzzle1, model.getActivePuzzle());
    // }

    // @Test
    // void clickRandPuzzle() {
    //     PuzzleLibrary library = new PuzzleLibraryImpl();
    //     Puzzle puzzle1 = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
    //     Puzzle puzzle2 = new PuzzleImpl(new int[][]{{5, 6}, {7, 8}});
    //     library.addPuzzle(puzzle1);
    //     library.addPuzzle(puzzle2);
    //     Model model = new ModelImpl(library);
    //     Stage stage = new Stage();
    //     ControllerImpl controller = new ControllerImpl(model, stage);

    //     assertEquals(puzzle1, model.getActivePuzzle());

    //     controller.clickRandPuzzle();
    //     assertNotEquals(puzzle1, model.getActivePuzzle());
    // }
//}
