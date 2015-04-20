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
public class PopUpExitApp
{
    public static Stage dialogStage = new Stage();
    public static Scene exitScene;
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

        dialogStage.initModality(Modality.WINDOW_MODAL);

        Label exitLabel = new Label("Are you sure you want to exit?");
        exitLabel.setAlignment(Pos.BASELINE_CENTER);

        PopUpButton yesBtn = new PopUpButton("Yes");
        yesBtn.setOnAction(evt -> close());

        PopUpButton noBtn = new PopUpButton("No");

        noBtn.setOnAction(evt -> dialogStage.close());

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

        exitScene = new Scene(vBox);

        dialogStage.setScene(exitScene);
        dialogStage.show();
    }

    public static void close()
    {
        dialogStage.close();
        System.exit(0);
    }

    public static Scene getScene()
    {
        return exitScene;
    }

    public static Stage getStage()
    {
        return dialogStage;
    }
}
