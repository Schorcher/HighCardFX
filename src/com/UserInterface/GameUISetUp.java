package com.UserInterface;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */

public class GameUISetUp
{
    // Initial setup of the GameUI
    public static void run()
    {
        GameUI.borderPane = new BorderPane();

        GameUI.mainStage.setWidth(600);
        GameUI.mainStage.setHeight(400);

        setUpBackground();
        setUpTop();
        setUpBottom();


    }

    // Sets the initial background for the game
    private static void setUpBackground()
    {
        // Sets up the background
        GameUI.background = new ImageView(new Image("/com/Resources/Misc/poker-table-background.jpg"));
        GameUI.background.setSmooth(true);
        GameUI.background.toBack();
        GameUI.background.fitWidthProperty().bind(GameUI.borderPane.widthProperty());
        GameUI.background.fitHeightProperty().bind(GameUI.borderPane.heightProperty());
        GameUI.borderPane.getChildren().add(GameUI.background);

        // Sets up the HighCard Logo
        GameUI.logo = new ImageView(new Image("/com/Resources/Misc/HighCardLogo.png"));
        GameUI.logo.setSmooth(true);
        GameUI.logo.setVisible(true);
        GameUI.logo.setPreserveRatio(true);

        GameUI.logo.xProperty().bind(GameUI.borderPane.widthProperty().divide(2).subtract(400));
        GameUI.logo.yProperty().bind(GameUI.borderPane.heightProperty().divide(4).subtract(100));
        //GameUI.logo.setLayoutX(-100);
        //GameUI.logo.setLayoutY(0);
        GameUI.logo.setScaleX(.5);
        GameUI.logo.setScaleY(.5);
        GameUI.borderPane.getChildren().add(GameUI.logo);

    }

    // Sets top with MenuBar and buttons
    private static void setUpTop()
    {
        // Set up the top menu bar(File, Edit, Help)
        GameUI.menuBar = new GameMenuBar();

        // Set up the game buttons
            // Play Button
            GameUI.playButton = new GameButton("Play");
            GameUI.playButton.setAlignment(Pos.CENTER_LEFT);

            // Deal Button
            GameUI.dealButton = new GameButton("Deal");
            GameUI.dealButton.setAlignment(Pos.CENTER_RIGHT);

            // End Button
            GameUI.endButton = new GameButton("End Game");
            GameUI.endButton.setAlignment(Pos.CENTER);

        // Add buttons to HBox (ButtonBox)
        GameUI.buttonBox = new HBox();
        GameUI.buttonBox.getChildren().addAll(GameUI.playButton,GameUI.dealButton,GameUI.endButton);

        // Sets the properties for the buttonBox
        GameUI.buttonBox.setAlignment(Pos.CENTER);
        GameUI.buttonBox.setPrefSize(600,0);
        GameUI.buttonBox.setSpacing(150);

        // Add MenuBar and buttonBox to VBox(top)
        GameUI.top = new VBox();
        GameUI.top.setSpacing(10);
        GameUI.top.getChildren().addAll(GameUI.menuBar,GameUI.buttonBox);

        // Add VBox(top) to the BorderPane at the top.
        GameUI.borderPane.setTop(GameUI.top);
    }

    // Sets center with cardBoxes
    public static void setUpCenter()
    {
        // Set up the CardBox
        CardBoxSetUp.run();

        /*
         *
         * Run fast sanic
         *
         */
        GameUI.borderPane.setCenter(GameUI.cardBox);
    }

    private static void setUpBottom()
    {
        // TBD
    }
}
