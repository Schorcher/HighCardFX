package com.GameEngine;

/**
 * Created by Server on 4/19/2015.
 */
public class SaveGame
{
    public String itemID;
    public int itemWins;

    SaveGame(String name, int wins)
    {
        this.itemID = name;
        this.itemWins = wins;
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

}
