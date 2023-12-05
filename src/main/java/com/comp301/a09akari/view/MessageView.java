/**
 * @file MessageView.java
 * @brief View class for displaying messages in the Akari Puzzle Game.
 *
 * This class implements the FXComponent interface to create a view for displaying messages in the Akari Puzzle Game.
 *
 * @package com.comp301.a09akari.view
 */
package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
/**
 * @brief View class for displaying messages in the Akari Puzzle Game.
 *
 * This class implements the FXComponent interface to create a view for displaying messages in the Akari Puzzle Game.
 */
public class MessageView implements FXComponent {
  private ClassicMvcController controller; /**< Controller instance for handling user interactions */
  private Model model; /**< Model instance to interact with the game model */
  /**
   * @brief Constructor for the MessageView class.
   *
   * @param ac ClassicMvcController instance for handling user interactions.
   * @param m Model instance to interact with the game model.
   */
  public MessageView(ClassicMvcController ac, Model m) {
    this.controller = ac;
    this.model = m;
  }
  /**
   * @brief Renders the message view.
   *
   * @return The root node for the message view.
   */
  @Override
  public Parent render() {
    StackPane format = new StackPane();
    Label message;
    int i = model.getActivePuzzleIndex();
    int totalPuzzles = model.getPuzzleLibrarySize();

    if (model.isSolved()) {
      message = new Label("Congrats! You solved Puzzle " + ((i++)+1) + " out of " + (totalPuzzles) + " ");
    } else {
      message =
          new Label("Sorry, Puzzle " + ((i++)+1) + " out of " + (totalPuzzles) + " has not been solved.");
    }
    format.getChildren().add(message);
    return format;
  }
}
