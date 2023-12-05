/**
 * @file FXComponent.java
 * @brief Interface for JavaFX components in the Akari Puzzle Game.
 *
 * This interface defines a contract for JavaFX components in the Akari Puzzle Game.
 *
 * @package com.comp301.a09akari.view
 */
package com.comp301.a09akari.view;

import javafx.scene.Parent;
/**
 * @brief Interface for JavaFX components in the Akari Puzzle Game.
 *
 * This interface defines a contract for JavaFX components in the Akari Puzzle Game.
 */
public interface FXComponent {
  /**
   * @brief Render the JavaFX component and return the resulting Parent object.
   *
   * This method should be implemented by classes that implement the FXComponent interface.
   *
   * @return The root Parent object representing the rendered JavaFX component.
   */
  Parent render();
}
