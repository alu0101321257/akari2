/*! \mainpage Akari Game Documentation
 *
 * \section intro_sec Introduction
 *
 * Welcome to the Akari Game documentation! This page provides information about the Akari game, a single-player logic puzzle implemented in Java using the model-view-controller (MVC) design pattern with the JavaFX UI library.
 *
 * The source code is hosted on GitHub at [Akari Game Repo](https://github.com/SamuelToledoHdez/Akari-DAP). 
 * 
 * The main code resides in the directory [src/main/java/com/comp301/a09akari](https://github.com/SamuelToledoHdez/Akari-DAP/tree/main/src/main/java/com/comp301/a09akari)
 * 
 * The tests resides in the directory [src/test/java/com/comp301/a09akari](https://github.com/SamuelToledoHdez/Akari-DAP/tree/main/src/test/java/com/comp301/a09akari).
 *
 * The project is supported by Maven, and continuous integration is performed with Jenkins.
 *
 * \section application_sec Running the Application
 *
 * To run the Akari game application, ensure Maven is installed. You can find the main code in [src/main/java/com/comp301/a09akari](https://github.com/SamuelToledoHdez/Akari-DAP/tree/main/src/main/java/com/comp301/a09akari). Explore the features and functionalities through the user interface.
 *
 * For more details, refer to the [GitHub repository](https://github.com/SamuelToledoHdez/Akari-DAP) or contact the development team for assistance.
 */

/**
 * @file Main.java
 * The entry point for the Akari puzzle game application.
 */
package com.comp301.a09akari;

import com.comp301.a09akari.view.AppLauncher;
import javafx.application.Application;


public class Main {
  /**
   * The main method that launches the JavaFX application using AppLauncher.
   *
   * @param args Command-line arguments (not used in this application).
   */
  public static void main(String[] args) {
    Application.launch(AppLauncher.class); // Launch the JavaFX application using AppLauncher
  }
}
