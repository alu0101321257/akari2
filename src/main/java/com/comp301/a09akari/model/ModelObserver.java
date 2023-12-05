/**
 * @file ModelObserver.java
 * @brief Interface for observing changes in a puzzle model.
 *
 * This interface defines a method that should be implemented by classes interested in observing changes in a puzzle model.
 * When a model value is changed, the `update()` method is called on all active ModelObserver objects.
 *
 * @package com.comp301.a09akari.model
 */
package com.comp301.a09akari.model;
/**
 * @brief Interface for observing changes in a puzzle model.
 *
 * This interface defines a method that should be implemented by classes interested in observing changes in a puzzle model.
 * When a model value is changed, the `update()` method is called on all active ModelObserver objects.
 */
public interface ModelObserver {
  /**
   * @brief Notifies the observer that a change has occurred in the puzzle model.
   *
   * This method is called by the puzzle model when a change occurs, allowing the observer to react accordingly.
   *
   * @param model The puzzle model that has been updated.
   */
  void update(Model model);
}
