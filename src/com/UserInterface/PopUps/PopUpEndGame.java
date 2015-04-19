package com.UserInterface.PopUps;

import com.UserInterface.PopUps.PopUpButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by davidmcfall on 3/25/15.
 */
public class PopUpEndGame {
    public static PopUpButton yesBtn = new PopUpButton("Yes");
    public static PopUpButton noBtn = new PopUpButton("No");
    public static Stage dialogStage = new Stage();
    public static Scene endGame;

    public static void start()
    {


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