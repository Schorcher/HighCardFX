package com.UserInterface;

import com.UserInterface.PopUps.PopUpButton;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class GameUI
{
    // Declare Members
    public static Stage mainStage;
    public static BorderPane borderPane;
    public static FlowPane cardBox;
    public static VBox top;
    public static HBox buttonBox;
    public static GameMenuBar menuBar;
    public static GameButton playButton, dealButton, endButton;
    public static ImageView background, logo;
    public static ArrayList<PlayerBox> boxList;

    //run the UI
    public static void run()
    {
        mainStage = new Stage();
        mainStage.setTitle("HighCard");
        GameUISetUp.run();
        setMainStage();
        setUpMainStage();
        mainStage.show();

    }

    public static void setUpMainStage()
    {
        mainStage.setMinHeight(400);
        mainStage.setMinWidth(500);
    }

    public static Scene setMainScene()
    {
        return new Scene(borderPane);
    }

    public static void setMainStage()
    {
        mainStage.setScene(setMainScene());
    }

}
