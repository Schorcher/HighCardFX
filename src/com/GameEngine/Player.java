package com.GameEngine;

import com.GameEngine.Card;

import java.util.ArrayList;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class Player
{
    private int wins;
    private ArrayList<Card> cards;
    private boolean roundWinner;
    private String playerName;
    private int playerID;
    private int finalWins=0;
    private int totalGames=0;
    private int trueTotalGames=0;
    private int winRatio=0;
    private int trueTotalWins=0;

    // Default computer player constructor
    Player(int playerID)
    {
        playerName = "Player";
        this.playerID = playerID;
        setUp();
    }

    // Human person constructor
    Player(String playerName, int playerID)
    {
        this.playerName = playerName;
        this.playerID = playerID;
        setUp();
    }

    // Initial setup of the player
    private void setUp()
    {
        resetWins();
        setRoundWinner(false);
        this.cards = new ArrayList<Card>();
    }

    // sets the players current card
    public void setCurrentCard(Card c)
    {
        this.cards.add(c);
    }

    // returns the players current card
    public Card getCurrentCard()
    {
        return cards.get(cards.size()-1);
    }

    // Increases the "win" score of the player
    public void win()
    {
        this.wins++;
    }

    // Returns the current number of wins
    public int getWins()
    {
        return this.wins;
    }

    // Returns the players name
    public String getPlayerName()
    {
        return this.playerName;
    }

    // Sets the players name
    public void setPlayerName(String name)
    {
        this.playerName=name;
    }

    // returns the players unique ID, not the name.
    public int getPlayerID()
    {
        return this.playerID;
    }

    // Resets the players win count
    public void resetWins()
    {
        this.wins=0;
    }

    // Return players round winner state
    public boolean isRoundWinner()
    {
        return this.roundWinner;
    }

    // Sets the player as the round winner
    public void setRoundWinner(boolean v)
    {
        this.roundWinner = v;
    }

    // Gets number of Final game wins
    public int getFinalWins()
    {
        return this.finalWins;
    }

    // Increases the number of final wins for player
    public void setFinalWins()
    {
        this.finalWins++;
    }

    // Returns the number of total games the player has played
    public int getTotalGames()
    {
        return this.totalGames;
    }

    // Increases the number of rounds the player has played by 1.
    public void setTotalGames()
    {
        this.totalGames++;
    }

    // Sets the players true total games from the loaded save file
    public void setTrueTotalGames(int totalLoad)
    {
        this.trueTotalGames=totalGames+totalLoad;
    }

    // Returns the ratio of wins / games played. (After loaded from save file)
    public int getWinRatio()
    {
        return trueTotalWins/trueTotalGames;
    }

    // Returns the true total win value for the player
    public int getTrueTotalWins()
    {
        return trueTotalWins;
    }

    // Sets the true number of wins (loaded from save file and combined with current wins)
    public void setTrueTotalWins(int wins)
    {
        this.trueTotalWins = this.wins+wins;
    }


}
