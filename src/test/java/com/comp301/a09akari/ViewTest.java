// package com.comp301.a09akari;
// import com.comp301.a09akari.controller.*;
// import com.comp301.a09akari.model.*;
// import com.comp301.a09akari.view.*;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import org.junit.jupiter.api.Test;
// import javafx.scene.layout.BorderPane;

// import static org.junit.jupiter.api.Assertions.*;



// class ViewTest {

//     @Test
//     void render() {
//         PuzzleLibrary library = new PuzzleLibraryImpl();
//         Puzzle puzzle = new PuzzleImpl(new int[][]{{1, 2}, {3, 4}});
//         library.addPuzzle(puzzle);
//         Model model = new ModelImpl(library);
//         Stage stage = new Stage();

//         ControllerImpl controller = new ControllerImpl(model, stage);

//         View view = new View(controller, model);

//         Parent parent = view.render();

//         assertNotNull(parent);
//         assertTrue(parent instanceof BorderPane);

//         BorderPane borderPane = (BorderPane) parent;
//         assertNotNull(borderPane.getCenter());
//         assertNotNull(borderPane.getLeft());
//         assertNotNull(borderPane.getRight());
//     }
// }