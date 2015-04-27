package com.GameEngine;

import javafx.scene.image.Image;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class Card
{

    private String suit;
    private String value;
    private int s;
    private int v;

    // Default card constructor
    Card(int suit, int val)
    {
        this.setSuit(suit);
        this.setValue(val);
        this.s=suit;
        this.v=val;
    }

    // Sets the suit for the current card
    public void setSuit(int num)
    {
        switch (num)
        {
            case 1:
                suit="Clubs";
                break;
            case 2:
                suit="Hearts";
                break;
            case 3:
                suit="Diamonds";
                break;
            case 4:
                suit="Spades";
                break;
        }
    }

    // Returns the suit for the card
    public String getSuit()
    {
        return suit;
    }

    // Sets the value "number" or "face" of the card
    public void setValue(int num)
    {
        switch (num)
        {
            case 2:
                value="Two";
                break;
            case 3:
                value="Three";
                break;
            case 4:
                value="Four";
                break;
            case 5:
                value="Five";
                break;
            case 6:
                value="Six";
                break;
            case 7:
                value="Seven";
                break;
            case 8:
                value="Eight";
                break;
            case 9:
                value="Nine";
                break;
            case 10:
                value="Ten";
                break;
            case 11:
                value="Jack";
                break;
            case 12:
                value="Queen";
                break;
            case 13:
                value="King";
                break;
            case 14:
                value="Ace";
                break;
        }



        if(num==13)
        {
            value="King";
        }
    }

    // Returns the image for the card
    public Image getImage()
    {
        String str="";
        if(v==1 || v>10)
        {
            str = ("/com/Resources/PNG-cards/" + getValue().toLowerCase() + "_of_" + getSuit().toLowerCase() + ".png");
        }
        else
        {
            str = ("/com/Resources/PNG-cards/" + v + "_of_" + getSuit().toLowerCase() + ".png");
        }
        return new Image(str);
    }

    // Returns the value of the card
    public String getValue()
    {
        return value;
    }

    // Ranks the card as a double value, Whole number is value, decimal is the suit.
    public double rankCard()
    {
        String str = (v+ "."+s);
        double rank = Double.parseDouble(str);
        return rank;
    }

    // Returns the String "name" of the card
    public String toString()
    {
        return (getValue() + " of " + getSuit());
    }
}
