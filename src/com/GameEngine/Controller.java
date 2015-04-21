package com.GameEngine;

import com.UserInterface.GameUI;
import com.UserInterface.GameUISetUp;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:     Controller Class that controls the game.
 */

public class Controller
{
    public static HighCard game;

    public static void run()
    {
        game = new HighCard();
    }

    public static void playGame()
    {
        if(game.hasStarted()) {
            GameUI.playButton.setDisable(true);
            GameUI.dealButton.setDisable(false);
            GameUI.endButton.setDisable(false);
            reset();
            game.play();
            updateCardBox();
        } else {
            GameUI.playButton.setDisable(true);
            GameUI.dealButton.setDisable(false);
            GameUI.endButton.setDisable(false);
            GameUI.logo.setVisible(false);
            Controller.game.resetWins();
            game.play();
            GameUISetUp.setUpCenter();
            updateCardBox();
        }
    }

    public static void dealCard() {
        if(game.cardDeck.cardCount()>=game.getNumOfPlayers()) {
            game.dealRound();
            updateCardBox();
        } else {
            GameUI.dealButton.setDisable(true);
            GameUI.playButton.setDisable(false);
            updateCardBox();
            finishGame();
        }
    }

    public static void updateCardBox()
    {
        for(int i=0; i< game.getNumOfPlayers(); i++) {
            if(game.cardDeck.cardCount()<game.getNumOfPlayers()) {
                GameUI.boxList.get(i).update();
            } else {
                GameUI.boxList.get(i).cardFlip();
            }
        }
    }

    public static void finishGame()
    {
        Controller.game.tieSituation();
        for(int i=0; i<Controller.game.winners.size(); i++)
        {
            GameUI.boxList.get(Controller.game.winners.get(i)).setWinner();
        }
        //GameUI.boxList.get(Controller.game.finalWinner()).setWinner();
    }

    public static void reset()
    {
        for(int i=0; i<game.getNumOfPlayers(); i++) {
            GameUI.boxList.get(i).resetWinner();
        }
        Controller.game.resetWins();
    }

    public static void endGame()
    {
        resetEverything();
        GameUISetUp.run();
        GameUI.setMainStage();
    }

    public static void resetEverything()
    {
        GameUI.playButton.setDisable(false);
        GameUI.endButton.setDisable(true);
        GameUI.dealButton.setDisable(true);
        GameUI.borderPane.getChildren().clear();
        GameUI.cardBox.getChildren().clear();
        GameUI.boxList.clear();
        GameUI.menuBar.getMenus().clear();
        game = null;
        game = new HighCard();
    }
}
