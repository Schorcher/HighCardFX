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
    public static SoundPlayer sounds = new SoundPlayer();
    public static HighCard game;

    // Sets up the initial highcard game
    public static void run()
    {
        game = new HighCard();
    }

    // Starts the highcard game or continues if there is a current game in play
    public static void playGame()
    {
        try {
            if (game.hasStarted()) {
                GameUI.playButton.setDisable(true);
                GameUI.dealButton.setDisable(false);
                GameUI.endButton.setDisable(false);
                reset();
                game.play();
                updateCardBox();
                sounds.playShuffle();
            } else {
                GameUI.playButton.setDisable(true);
                GameUI.dealButton.setDisable(false);
                GameUI.endButton.setDisable(false);
                GameUI.logo.setVisible(false);
                Controller.game.resetWins();
                game.play();
                GameUISetUp.setUpCenter();
                updateCardBox();
                sounds.playShuffle();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Deals a round of cards and updates the images and label for each player
    public static void dealCard() {
        try {
            if (game.cardDeck.cardCount() >= game.getNumOfPlayers()) {
                game.dealRound();
                updateCardBox();
                sounds.playDrawCard();
            } else {
                GameUI.dealButton.setDisable(true);
                GameUI.playButton.setDisable(false);
                updateCardBox();
                finishGame();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Updates the players in the game with current card image and information
    public static void updateCardBox()
    {
        try {
            for (int i = 0; i < game.getNumOfPlayers(); i++) {
                if (game.cardDeck.cardCount() < game.getNumOfPlayers()) {
                    GameUI.boxList.get(i).update();
                } else {
                    GameUI.boxList.get(i).cardFlip();
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Runs the game winner methods and finishes the current game
    public static void finishGame()
    {
        Controller.game.tieSituation();
        for(int i=0; i<Controller.game.winners.size(); i++)
        {
            GameUI.boxList.get(Controller.game.winners.get(i)).setWinner();
        }
        //GameUI.boxList.get(Controller.game.finalWinner()).setWinner();
    }

    // Resets the game to default values
    public static void reset()
    {
        for(int i=0; i<game.getNumOfPlayers(); i++) {
            GameUI.boxList.get(i).resetWinner();
        }
        Controller.game.resetWins();
    }

    // Resets the game and goes back to the main menu
    public static void endGame()
    {
        resetEverything();
        GameUISetUp.run();
        GameUI.setMainStage();
    }

    // Resets everything to default values (null)
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
