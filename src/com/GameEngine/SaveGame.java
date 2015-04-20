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
    public int itemWins;
    public SimpleStringProperty name;
    public SimpleIntegerProperty wins;

    SaveGame(String name, int wins)
    {
        this.itemID = name;
        this.itemWins = wins;
        this.name = new SimpleStringProperty(name);
        this.wins = new SimpleIntegerProperty(wins);
    }

    public String getItemID()
    {
        return itemID;
    }

    public void setItemID(String itemID)
    {
        this.itemID = itemID;
    }

    public int getItemWins()
    {
        return itemWins;
    }

    public void setItemWins(int itemWins)
    {
        this.itemWins = itemWins;
    }

    public SimpleStringProperty nameProperty()
    {
        return this.name;
    }
    public SimpleIntegerProperty winsProperty()
    {
        return this.wins;
    }

}
