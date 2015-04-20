package com.UserInterface.PopUps;

import com.GameEngine.Controller;
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
public class PopUpButton extends Button implements EventHandler<ActionEvent>
{
    // Initialize members
    public String buttonID;

    PopUpButton(String title)
    {
        super(title);
        this.buttonID=title;
        run();
    }

    private void run()
    {
        setUp();
    }

    private void setUp()
    {
        // Calls the handle method on button press.
        this.setOnAction(evt -> handle(evt));

    }

    @Override
    public void handle(ActionEvent event)
    {
        String s = ((PopUpButton) event.getSource()).buttonID;
        // Switch based on the 3 buttons
        switch (s)
        {
            // Deal button
            case "Yes":
                yesEvent();
                break;
            case "Okay":
                okayEvent();
                break;
            case "No":
                noEvent();
                break;
            case "Start":
                startEvent();
                break;
            default:
                break;
        }
    }

    public void startEvent()
    {
        PopUpNumPlayers.setNum();
    }

    public void yesEvent()
    {
        if(this.getScene().equals(PopUpEndGame.getScene()))
        {
            Controller.endGame();
            PopUpEndGame.getStage().close();
        }
        else if(this.getScene().equals(PopUpExitApp.getScene()))
        {
            System.exit(0);
        }
    }

    public void okayEvent()
    {
        // sanic was heree
    }

    public void noEvent()
    {
        if(this.getScene().equals(PopUpEndGame.getScene()))
        {
            PopUpEndGame.getStage().close();
        }
        else if(this.getScene().equals(PopUpExitApp.getScene()))
        {
            PopUpExitApp.getStage().close();
        }
    }

    @Override
    public String toString()
    {
        return buttonID;
    }
}
