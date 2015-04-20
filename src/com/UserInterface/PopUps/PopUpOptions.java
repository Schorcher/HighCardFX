package com.UserInterface.PopUps;

import com.UserInterface.GameUI;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
public class PopUpOptions
{
    private static final Stage dialogStage = new Stage();
    private static Label titleLabel, backgroundLabel, newLabel;
    private final static ChoiceBox listOfBackgrounds = new ChoiceBox(FXCollections
            .observableArrayList("Original", "New Card", "Plain"));
    private static Button okayBtn, cancelBtn;
    private static boolean hasRun = false;

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
        // Sets the title of the window
        titleLabel = new Label("Select options for the game.");
        titleLabel.setAlignment(Pos.CENTER);

        // Sets up the options for different backgrounds
        HBox backgroundBox = new HBox();
        backgroundBox.setAlignment(Pos.CENTER);
        backgroundBox.setSpacing(20);
        backgroundLabel = new Label("Choose a background.");
        backgroundBox.getChildren().addAll(listOfBackgrounds,backgroundLabel);

        // Sets up the confirmation buttons
        HBox btnBox = new HBox();
        okayBtn = new Button("Okay");
        okayBtn.setOnAction(evt -> setBackground());
        cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(evt -> dialogStage.close());
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setSpacing(20);
        btnBox.getChildren().addAll(okayBtn,cancelBtn);

        // Sets up the main VBox for the items
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25.0);
        vBox.getChildren().addAll(titleLabel, backgroundBox, btnBox);


        // Sets up the window options
        dialogStage.setHeight(175);
        dialogStage.setWidth(275);
        dialogStage.setScene(new Scene(vBox));
        dialogStage.show();

    }

    public static void setBackground()
    {
        if(listOfBackgrounds.getSelectionModel().getSelectedIndex() == 0)
        {
            GameUI.background.setImage(new Image("/com/Resources/Misc/poker-table-background.jpg"));
        }
        if(listOfBackgrounds.getSelectionModel().getSelectedIndex() == 1)
        {
            GameUI.background.setImage(new Image("/com/Resources/Misc/bg-background-theme-1.jpg"));
        }
        if(listOfBackgrounds.getSelectionModel().getSelectedIndex() == 2)
        {
            GameUI.background.setImage(null);
        }
        dialogStage.close();
    }

    public void setSoundEffects()
    {

    }
}
