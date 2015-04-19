package com.UserInterface.PopUps;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class PopUpOptions
{
    private static final Stage dialogStage = new Stage();
    private static Label titleLabel, backgroundLabel, newLabel;
    private final static ChoiceBox listOfBackgrounds = new ChoiceBox(FXCollections
            .observableArrayList("Original", "New Card", "Plain"));

    public static void run()
    {

        titleLabel = new Label("Select options for the game.");
        titleLabel.setAlignment(Pos.CENTER);

        HBox backgroundBox = new HBox();
        backgroundBox.setSpacing(20);
        backgroundLabel = new Label("Choose a background.");
        backgroundBox.getChildren().addAll(listOfBackgrounds,backgroundLabel);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25.0);
        vBox.getChildren().addAll(titleLabel);



        dialogStage.setHeight(150);
        dialogStage.setWidth(250);
        dialogStage.setScene(new Scene(vBox));
        dialogStage.show();

    }
}
