/**
 * @file TimeDisplayView.java
 * @brief Interface for rendering a view that displays the final time in the Akari Puzzle Game.
 *
 * This interface defines the contract for rendering a view that displays the final time in the Akari Puzzle Game.
 *
 * @package com.comp301.a09akari.view
 */
package com.comp301.a09akari.view;

import javafx.scene.Parent;
/**
 * @brief Interface for rendering a view that displays the final time in the Akari Puzzle Game.
 *
 * This interface defines the contract for rendering a view that displays the final time in the Akari Puzzle Game.
 */
public interface TimeDisplayView {
    /**
     * @brief Renders the time display view.
     *
     * @param finalTime The final time to be displayed.
     * @return The root node for the time display view.
     */
    Parent render(double finalTime);
}
