package com.UserInterface.PopUps;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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

    public static void run()
    {

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

