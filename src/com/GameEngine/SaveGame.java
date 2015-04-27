package com.GameEngine;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */

public class SaveGame
{
    public String itemID;
    public Integer winsInt,totalGamesInt;
    public SimpleStringProperty name;
    public SimpleIntegerProperty wins, winRatio, totalGames;

    // Default constructor
    SaveGame(String name, int wins)
    {
        this.itemID = name;
        this.winsInt = wins;
        this.name = new SimpleStringProperty(name);
        this.wins = new SimpleIntegerProperty(wins);
    }

    // Wins ratio constructor
    SaveGame(String name, int wins, int totalGames)
    {
        this.itemID = name;
        this.winsInt = wins;
        this.totalGamesInt = totalGames;
        this.name = new SimpleStringProperty(name);
        this.totalGames = new SimpleIntegerProperty(totalGames);
        this.wins = new SimpleIntegerProperty(wins);
        this.winRatio = new SimpleIntegerProperty((wins/totalGames));
    }

    // Returns the ItemID (player name)
    public String getItemID()
    {
        return itemID;
    }

    // Sets the itemID (player name)
    public void setItemID(String itemID)
    {
        this.itemID = itemID;
    }

    // returns the integer of wins
    public Integer getWins()
    {
        return this.winsInt;
    }

    // Returns the total games value
    public Integer getTotalGames()
    {
        return this.totalGamesInt;
    }

    /*
     *
     * Experimental Observable values from the file
     *
     */
    public SimpleStringProperty nameProperty()
    {
        return this.name;
    }
    public SimpleIntegerProperty winsProperty()
    {
        return this.wins;
    }
    public SimpleIntegerProperty winRatioProperty()
    {
        return winRatio;
    }

}
