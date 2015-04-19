package com;

import com.GameEngine.Controller;
import com.UserInterface.GameUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        // Runs the load screen
        startSplash(primaryStage);
        Controller.run();

    }

    // Runs the load screen (the load screen is just for visual effect)
    private void startSplash(Stage initStage)
    {
        // Shows the load screen
        Splash.showSplash(initStage, Splash.friendTask);

        // Once load screen is finished, runs the main GameUI class
        Splash.friendTask.setOnSucceeded(evt -> GameUI.run());

        // Starts the load screen as a runnable on a new thread
        new Thread(Splash.friendTask).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
