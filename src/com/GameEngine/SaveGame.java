package com.GameEngine;

/**
 * Created by Server on 4/19/2015.
 */
public class SaveGame
{
    public String itemID;
    public String itemWins;

    SaveGame(String name, String wins)
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

    public String getItemWins()
    {
        return itemWins;
    }

    public void setItemWins(String itemWins)
    {
        this.itemWins = itemWins;
    }

}
