package com.GameEngine;

import com.GameEngine.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by davidmcfall on 3/23/15.
 */
public class Deck
{
    private ArrayList<Card> cardDeck;
    private ArrayList<Card> usedCards;
    private int topCard=0;

    Deck()
    {
        this.cardDeck = new ArrayList<Card>();
        this.usedCards = new ArrayList<Card>();
        setDeck();
    }

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

    public int cardCount()
    {
        return cardDeck.size();
    }

    public void resetDeck()
    {
        cardDeck.clear();
        usedCards.clear();
        setDeck();
    }
}
