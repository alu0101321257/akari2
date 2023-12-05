/**
 * @file AppLauncher.java
 * @brief Application launcher for the Akari Puzzle Game.
 *
 * This class extends the JavaFX Application class to launch the Akari Puzzle Game application.
 *
 * @package com.comp301.a09akari.view
 */
package com.comp301.a09akari.view;

import com.comp301.a09akari.SamplePuzzles;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.ModelImpl;
import com.comp301.a09akari.model.Puzzle;
import com.comp301.a09akari.model.PuzzleImpl;
import com.comp301.a09akari.model.PuzzleLibrary;
import com.comp301.a09akari.model.PuzzleLibraryImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @brief Application launcher for the Akari Puzzle Game.
 *
 * This class extends the JavaFX Application class to launch the Akari Puzzle Game application.
 **/
public class AppLauncher extends Application {
  private Timer timer;
  /**
   * @brief Entry point for launching the Akari Puzzle Game application.
   *
   * @param stage The primary stage for the application.
   *
  @Override
  public void start(Stage stage) {
    Puzzle puzzle1 = new PuzzleImpl(SamplePuzzles.PUZZLE_01);
    Puzzle puzzle2 = new PuzzleImpl(SamplePuzzles.PUZZLE_02);
    Puzzle puzzle3 = new PuzzleImpl(SamplePuzzles.PUZZLE_03);
    Puzzle puzzle4 = new PuzzleImpl(SamplePuzzles.PUZZLE_04);
    Puzzle puzzle5 = new PuzzleImpl(SamplePuzzles.PUZZLE_05);
    Puzzle puzzle6 = new PuzzleImpl(SamplePuzzles.PUZZLE_06);
    Puzzle puzzle7 = new PuzzleImpl(SamplePuzzles.PUZZLE_07);
    Puzzle puzzle8 = new PuzzleImpl(SamplePuzzles.PUZZLE_EXPERTO);
    Puzzle puzzle9 = new PuzzleImpl(SamplePuzzles.PUZZLE_08);
    Puzzle puzzleexperto = new PuzzleImpl(SamplePuzzles.PUZZLE_EXPERTO_REAL);

    PuzzleLibrary library = new PuzzleLibraryImpl();
    library.addPuzzle(puzzle1);
    library.addPuzzle(puzzle2);
    library.addPuzzle(puzzle3);
    library.addPuzzle(puzzle4);
    library.addPuzzle(puzzle5);
    library.addPuzzle(puzzle6);
    library.addPuzzle(puzzle7);
    library.addPuzzle(puzzle8);
    library.addPuzzle(puzzle9);
    library.addPuzzle(puzzleexperto);

    Model model = new ModelImpl(library);
    ClassicMvcController controller = new ControllerImpl(model,stage);
    View view = new View(controller, model);

    Scene scene = new Scene(view.render());

    stage.setScene(scene);

    model.addObserver(
        (Model m) -> {
          scene.setRoot(view.render());
          stage.sizeToScene();
        });
    stage.setTitle("Akari Puzzle Game");
    stage.show();
    stage.setOnCloseRequest(event -> {
      controller.getTime();
    });
  }
}
