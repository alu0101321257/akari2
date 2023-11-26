package com.comp301.a09akari.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TimeDisplayViewImpl implements TimeDisplayView {
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

    private int calcularPuntos(double finalTime) {
        // Ejemplo de lógica de puntuación: inversamente proporcional al tiempo
        // Puedes ajustar esta lógica según tus necesidades
        return (int) (100000 / (finalTime + 1));
    }
}