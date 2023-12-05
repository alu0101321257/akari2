/**
 * @file TimeDisplayViewImpl.java
 * @brief Implementation of the TimeDisplayView interface for rendering the final time in the Akari Puzzle Game.
 *
 * This class provides an implementation of the TimeDisplayView interface to render a view displaying the final time
 * and associated score in the Akari Puzzle Game.
 *
 * @package com.comp301.a09akari.view
 */
package com.comp301.a09akari.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
/**
 * @brief Implementation of the TimeDisplayView interface for rendering the final time in the Akari Puzzle Game.
 *
 * This class provides an implementation of the TimeDisplayView interface to render a view displaying the final time
 * and associated score in the Akari Puzzle Game.
 */
public class TimeDisplayViewImpl implements TimeDisplayView {
    /**
     * @brief Renders the time display view.
     *
     * @param finalTime The final time to be displayed.
     * @return The root node for the time display view.
     */
    @Override
    public Parent render(double finalTime) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        // Lógica de puntuación: a más tiempo, menos puntos
        int puntos = calcularPuntos(finalTime);

        // Formatear el mensaje
        String mensaje = String.format("¡Bien hecho!\nTiempo Final: %.1f segundos\nPuntuación: %d puntos", finalTime, puntos);

        Label label = new Label(mensaje);
        label.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        root.getChildren().add(label);
        return root;
    }
    /**
     * @brief Calculates the score based on the final time.
     *
     * This method implements an example scoring logic that is inversely proportional to the time.
     * You can adjust this logic according to your specific scoring requirements.
     *
     * @param finalTime The final time for which the score is calculated.
     * @return The calculated score.
     */
    private int calcularPuntos(double finalTime) {
        // Ejemplo de lógica de puntuación: inversamente proporcional al tiempo
        // Puedes ajustar esta lógica según tus necesidades
        return (int) (100000 / (finalTime + 1));
    }
}
