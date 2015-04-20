package com.UserInterface.PopUps;

import com.UserInterface.GameUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.jnlp.ServiceManager;
import java.awt.*;
import java.net.URI;

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

        Label authorLabel = new Label("Author: David McFall");
        authorLabel.setAlignment(Pos.CENTER);

        HBox webLabels = new HBox();
        Label visitLabel = new Label("Website: ");
        Hyperlink link = new Hyperlink("http://google.com/");
        //link.setOnAction(evt -> linkAction());
        webLabels.setAlignment(Pos.CENTER);
        webLabels.getChildren().addAll(visitLabel,link);


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25.0);
        vBox.getChildren().addAll(authorLabel,webLabels);
        dialogStage.setHeight(150);
        dialogStage.setWidth(250);
        dialogStage.setScene(new Scene(vBox));
        dialogStage.show();
    }

    public static void linkAction()
    {

    }
}

