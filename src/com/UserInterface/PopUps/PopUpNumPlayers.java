package com.UserInterface.PopUps;

import com.GameEngine.Controller;
import com.UserInterface.GameUI;
import com.UserInterface.PopUps.PopUpButton;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
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

@SuppressWarnings("unchecked")
public class PopUpNumPlayers
{
    private static final Stage dialogStage = new Stage();
    public static TextField nameField = new TextField("Player 1");
    public static PopUpButton startBtn = new PopUpButton("Start");
    final static ChoiceBox listOfNumPlayers = new ChoiceBox(FXCollections
            .observableArrayList(3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    private static boolean hasRun=false;

    // Initial setup of the popup
    public static void firstRun()
    {
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(GameUI.mainStage);
        hasRun=true;
    }

    public static void start()
    {
        // Sets the modality of the window
        if(hasRun==false)
        {
            firstRun();
        }

        Label numLabel = new Label("How many players?");
        numLabel.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(50.0);
        hBox.getChildren().addAll(listOfNumPlayers, startBtn);

        Label nameLabel = new Label("Player Name: ");
        nameField.setPrefWidth(100);

        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(25.0);
        hBox2.getChildren().addAll(nameLabel, nameField);


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25.0);
        vBox.getChildren().addAll(numLabel, hBox, hBox2);
        dialogStage.setHeight(175);
        dialogStage.setWidth(250);
        dialogStage.setScene(new Scene(vBox));
        dialogStage.show();
    }

    // Sets the number of plays in game to current selection
    public static void setNum()
    {
        if(listOfNumPlayers.getSelectionModel().getSelectedIndex()>=0) {
            dialogStage.close();
            Controller.game.setNumOfPlayers(listOfNumPlayers.getSelectionModel().getSelectedIndex() + 3);
            Controller.playGame();
            Controller.game.getPlayer(0).setPlayerName(nameField.getText());
        }

    }

    // Closes the stage
    public static void closeThis()
    {
        dialogStage.close();
    }

    // Returns the stage
    public static Stage getStage()
    {
        return dialogStage;
    }
}
