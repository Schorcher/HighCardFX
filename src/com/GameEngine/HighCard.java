package com.GameEngine;


import com.GameEngine.Deck;
import com.GameEngine.Player;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class HighCard
{

    public ArrayList<Player> players;
    public ArrayList<Integer> winners;
    public Deck cardDeck;
    public boolean started = false;
    public int numOfPlayers;

    // Runs initial set up of game before it is played.
    HighCard()
    {
        setUp();
    }

    // Sets up the games variables
    public void setUp()
    {
        this.numOfPlayers=0;
        this.players = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.cardDeck = new Deck();
        this.started = false;
    }

    // When play is called it sets up the players and deals a round of cards
    public void play()
    {
        currentGameReset();
        if(!started)
        {
            setUpPlayers();
        }
        dealRound();
        this.started=true;
    }

    // Sets the number of players in the game
    public void setNumOfPlayers(int num)
    {
        this.numOfPlayers=num;
    }

    // Creates the players themselves
    public void setUpPlayers()
    {
        for(int i=1; i<=this.numOfPlayers; i++)
        {
            this.players.add(new Player(i));
        }
    }

    // Deals a card to each player
    public void dealRound()
    {
        resetRoundWinner();
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).setCurrentCard(this.cardDeck.dealCard());

        }
        checkRoundWinner();
    }

    // Checks who won the round of cards dealt
    public void checkRoundWinner()
    {
        int count=0;
        double max=0, current;
        for(int i=0; i<this.players.size(); i++)
        {
            current = this.players.get(i).getCurrentCard().rankCard();
            if(current > max)
            {
                max=current;
                resetRoundWinner();
                count=i;
            }
        }
        this.players.get(count).win();
    }

    // Checks who won at the end of the game
    public int finalWinner()
    {
        double max=0, current;
        int winner=0;
        for(int i=0; i<this.players.size(); i++)
        {
            current = this.players.get(i).getWins();
            if(current > max)
            {
                max = current;
                winner=this.players.get(i).getPlayerID()-1;
            }
        }
        return winner;
    }

    // Checks for a tie and adds them as final winners
    public void tieSituation()
    {
        this.winners.clear();
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).setTotalGames();
            if(this.players.get(finalWinner()) != this.players.get(i))
            {
                if (this.players.get(i).getWins() == this.players.get(finalWinner()).getWins())
                {
                    this.winners.add(this.players.get(i).getPlayerID()-1);
                }
            }
        }
        this.winners.add(finalWinner());
    }

    // Resets everything
    public void newGameReset()
    {
        this.cardDeck.resetDeck();
        this.players.clear();
        this.started=false;
        this.numOfPlayers=0;
    }

    // Resets current game
    public void currentGameReset()
    {
        this.cardDeck.resetDeck();
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).resetWins();
        }
    }

    // Resets the current round winner
    public void resetRoundWinner()
    {
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).setRoundWinner(false);
        }
    }

    // gets player
    public Player getPlayer(int i)
    {
        return this.players.get(i);
    }

    // checks whether or not the game has started
    public boolean hasStarted()
    {
        return started;
    }

    // Returns the number of players in the game
    public int getNumOfPlayers()
    {
        return numOfPlayers;
    }

    // resets the players wins
    public void resetWins()
    {
        for(int i=0; i<this.players.size(); i++)
        {
            this.players.get(i).resetWins();
        }
    }
}
