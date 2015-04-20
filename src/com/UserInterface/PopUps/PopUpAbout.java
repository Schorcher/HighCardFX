package com.UserInterface.PopUps;

import com.UserInterface.GameUI;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */

public class PopUpAbout
{
    private static final Stage dialogStage = new Stage();
    private static boolean hasRun=false;

    public static void firstRun()
    {
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(GameUI.mainStage);
        hasRun=true;
    }
    public static void run()
    {
        // Sets the modality of the window
        if(hasRun==false)
        {
            firstRun();
        }

        Label exitLabel = new Label("Author: David McFall");
        exitLabel.setAlignment(Pos.CENTER);


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25.0);
        vBox.getChildren().addAll(exitLabel);
        dialogStage.setHeight(150);
        dialogStage.setWidth(250);
        dialogStage.setScene(new Scene(vBox));
        dialogStage.show();
    }
}

