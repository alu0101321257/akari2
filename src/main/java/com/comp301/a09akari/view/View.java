/**
 * @file View.java
 * This class represents the main view component in the MVC architecture for the Akari puzzle game.
 */
package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
/**
 * The View class is responsible for rendering the user interface components for the Akari Puzzle game.
 * It uses other components such as MessageView, PuzzleView, and ControlView to display the puzzle board,
 * messages, and control buttons.
 */
public class View implements FXComponent {
  private ClassicMvcController controller; // The controller associated with the view
  private Model model; // The model associated with the view

  /**
   * Constructs a View instance.
   *
   * @param ac The controller associated with the view.
   * @param m  The model associated with the view.
   */
  public View(ClassicMvcController ac, Model m) {
    this.controller = ac; // Set the controller
    this.model = m; // Set the model
  }

  /**
   * Renders the main view of the Akari puzzle game, including message, puzzle, and control views.
   *
   * @return The JavaFX Parent node representing the main view.
   */
  public Parent render() {
    BorderPane format = new BorderPane(); // BorderPane for organizing the components
    FXComponent messageView = new MessageView(controller, model); // Message view component
    FXComponent puzzleView = new PuzzleView(controller, model); // Puzzle view component
    FXComponent controlView = new ControlView(controller, model); // Control view component

    format.setCenter(puzzleView.render()); // Set puzzle view at the center
    format.setLeft(messageView.render()); // Set message view to the left
    format.setRight(controlView.render()); // Set control view to the right

    return format; // Return the formatted main view
  }
}
