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

    SaveGame(String name, int wins)
    {
        this.itemID = name;
        this.winsInt = wins;
        this.name = new SimpleStringProperty(name);
        this.wins = new SimpleIntegerProperty(wins);
    }

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

    public String getItemID()
    {
        return itemID;
    }

    public void setItemID(String itemID)
    {
        this.itemID = itemID;
    }
    public Integer getWins()
    {
        return this.winsInt;
    }
    public Integer getTotalGames()
    {
        return this.totalGamesInt;
    }

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
