package com.UserInterface;

import com.GameEngine.Controller;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

/**
 * Created by davidmcfall on 3/23/15.
 */
public class CardBoxSetUp
{
    // Sets up the initial box
    public static void run()
    {
        GameUI.boxList = new ArrayList<PlayerBox>();

        GameUI.cardBox = new FlowPane();
        GameUI.cardBox.setAlignment(Pos.CENTER);
        GameUI.cardBox.setHgap(25);
        GameUI.cardBox.setVgap(10);
        GameUI.cardBox.setPrefWrapLength(4);

        addPlayerBoxes();

        resizeMainStage();

    }

    public static void resizeMainStage()
    {
        // Size if greater than 4 players
        if(GameUI.boxList.size()>4)
        {
            GameUI.mainStage.setHeight(600);
            GameUI.background.setFitHeight(600);
        }
        // Size if greater than 8 players
        if(GameUI.boxList.size()>8)
        {
            GameUI.mainStage.setHeight(800);
            GameUI.background.setFitHeight(800);
        }
    }

    // Adds children to the box
    public static void addPlayerBoxes()
    {
        // Add playerBoxes to arrayList
        for(int i=0; i< Controller.game.numOfPlayers; i++)
        {
            GameUI.boxList.add(new PlayerBox(Controller.game.getPlayer(i)));
            GameUI.boxList.get(i).setMaxSize(100,100);
        }
        // Adds children to flow pane
        GameUI.cardBox.getChildren().addAll(GameUI.boxList);
    }
}
