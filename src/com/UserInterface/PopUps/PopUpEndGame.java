package com.UserInterface.PopUps;

import com.UserInterface.GameUI;
import com.UserInterface.PopUps.PopUpButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by davidmcfall on 3/25/15.
 */
public class PopUpEndGame {
    public static PopUpButton yesBtn = new PopUpButton("Yes");
    public static PopUpButton noBtn = new PopUpButton("No");
    public static Stage dialogStage = new Stage();
    public static Scene endGame;
    private static boolean hasRun=false;

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

        Label exitLabel = new Label("Are you sure you want to end the game?");
        exitLabel.setAlignment(Pos.BASELINE_CENTER);


        noBtn.setOnAction(evt -> dialogStage.close());
        //yesBtn.setOnAction(evt -> endGame());

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setSpacing(40.0);
        hBox.getChildren().addAll(yesBtn, noBtn);

        VBox vBox = new VBox();
        vBox.setSpacing(40.0);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(exitLabel, hBox);

        dialogStage.setHeight(150);
        dialogStage.setWidth(250);

        endGame = new Scene(vBox);

        dialogStage.setScene(endGame);
        dialogStage.show();
    }

    public static void endGame()
    {
        dialogStage.close();

        // Code to end game

    }

    public static Scene getScene()
    {
        return endGame;
    }

    public static Stage getStage()
    {
        return dialogStage;
    }

}