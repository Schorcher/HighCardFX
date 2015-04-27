package com.GameEngine;

import com.GameEngine.Card;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class Deck
{
    private ArrayList<Card> cardDeck;
    private ArrayList<Card> usedCards;
    private int topCard=0;

    Deck()
    {
        this.cardDeck = new ArrayList<>();
        this.usedCards = new ArrayList<>();
        setDeck();
    }

    // Deals the card at the top of the deck and moves it to used cards.
    public Card dealCard()
    {
        usedCards.add(cardDeck.get(topCard));
        Card current = cardDeck.get(topCard);
        cardDeck.remove(topCard);
        return current;
    }

    private void shuffle()
    {
        Collections.shuffle(cardDeck);
    }

    // Creates a deck of 52 unique cards
    public void setDeck()
    {
        for(int i=1; i<=4; i++)
        {
            for(int j=2; j<=14; j++)
            {
                cardDeck.add(new Card(i,j));
            }
        }
        shuffle();
    }

    // Returns the number of cards left in the deck
    public int cardCount()
    {
        return cardDeck.size();
    }

    // Resets the deck
    public void resetDeck()
    {
        cardDeck.clear();
        usedCards.clear();
        setDeck();
    }
}
