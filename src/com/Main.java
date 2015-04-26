package com;

import com.GameEngine.Controller;
import com.UserInterface.GameUI;
import javafx.application.Application;
import javafx.stage.Stage;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try {
            // Runs the load screen
            startSplash(primaryStage);
            Controller.run();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Error Loading Splash.");
            GameUI.run();
        }

    }

    // Runs the load screen (the load screen is just for visual effect)
    private void startSplash(Stage initStage) throws Exception
    {
        try {
            // Shows the load screen
            Splash.showSplash(initStage, Splash.friendTask);

            // Once load screen is finished, runs the main GameUI class
            Splash.friendTask.setOnSucceeded(evt -> GameUI.run());

            // Starts the load screen as a runnable on a new thread
            new Thread(Splash.friendTask).start();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
