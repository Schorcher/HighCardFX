package com.UserInterface;

import com.GameEngine.Controller;
import com.UserInterface.PopUps.PopUpEndGame;
import com.UserInterface.PopUps.PopUpNumPlayers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class GameButton extends Button implements EventHandler<ActionEvent>
{
    // Initialize members
    public String buttonID;

    // Build Constructor
    GameButton(String title)
    {
        super(title);
        this.buttonID=title;
        run();
    }

    private void run()
    {
        setUp();
    }

    // Sets up the OnAction events
    private void setUp()
    {
        // Calls the handle method on button press.
        this.setOnAction(evt -> handle(evt));
        // Sets the deal button as default disabled.
        if(this.buttonID.equals("Deal"))
        {
            this.setDisable(true);
        }
        if(this.buttonID.equals("End Game"))
        {
            this.setDisable(true);
        }
    }


    @Override
    public void handle(ActionEvent event)
    {
        String s = ((GameButton) event.getSource()).buttonID;
        // Switch based on the 3 buttons
        switch (s)
        {
            // Play button
            case "Play":
                playEvent();
                break;
            // End button
            case "End Game":
                endEvent();
                break;
            // Deal button
            case "Deal":
                dealEvent();
                break;
            default:
                break;
        }
    }

    // Play button events
    private static void playEvent()
    {

        if (!Controller.game.hasStarted()) {
            PopUpNumPlayers.start();
        } else {
            Controller.playGame();
        }
    }

    // End button events
    private static void endEvent()
    {
        PopUpEndGame.start();
    }

    // Deal button events
    private static void dealEvent()
    {
        Controller.dealCard();
    }

    @Override
    public String toString()
    {
        return buttonID;
    }
}
