package com.UserInterface;

import com.GameEngine.Player;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/*
        * Name:        David McFall
        * Instructor:  Dr. Jones
        * Date:        3/30/15
        * Assignment:  HighCard Game
        * Purpose:
*/
public class PlayerBox extends VBox
{
    // Initialize Members
    public Label playerName, cardName, score, winner;
    public ImageView cardImage;
    public Player player;
    public VBox box;
    private DropShadow borderGlow= new DropShadow();
    private int current =0;

    // Constructor for class
    PlayerBox(Player player)
    {
        this.player = player;
        //run setup
        setUp();
    }

    // Initial setup for the box
    private void setUp()
    {
        try {
            // sets initial values for all members
            try {
                this.playerName = new Label(this.player.getPlayerName());
                try {
                    this.cardImage = new ImageView(this.player.getCurrentCard().getImage());
                }
                catch (Exception ex)
                {
                    System.out.println("Error No Image!");
                }
                this.cardName = new Label(this.player.getCurrentCard().toString());
                this.score = new Label("Wins: " + this.player.getWins());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            this.winner = new Label("WINNER!");
            this.box = new VBox();

            // Sets the borderglow effect properties
            this.borderGlow.setOffsetY(0f);
            this.borderGlow.setOffsetX(0f);
            this.borderGlow.setColor(Color.TURQUOISE);
            this.borderGlow.setWidth(70);
            this.borderGlow.setHeight(70);

            // Sets the card image properties
            try {
                this.cardImage.setPreserveRatio(true);
                this.cardImage.setSmooth(true);
                this.cardImage.setCache(true);
                this.cardImage.setFitHeight(150);
                this.cardImage.setFitWidth(200);
                this.cardImage.setPickOnBounds(true);
            }
            catch (Exception ex)
            {
                System.out.println("Error No Image to update!");
            }

            // Sets all text as default white color
            this.playerName.setStyle("-fx-text-fill: white");
            this.cardName.setStyle("-fx-text-fill: white");
            this.score.setStyle("-fx-text-fill: white");

            // Sets up winner label and hides it for later use
            this.winner.setStyle("-fx-text-fill: turquoise");
            this.winner.setVisible(false);

            // sets alignment of box and adds all nodes to VBox(this)
            this.setAlignment(Pos.CENTER);
            try {
                this.getChildren().addAll(this.playerName, this.cardImage, this.cardName, this.score, this.winner);
            }
            catch (Exception ex)
            {
                System.out.println("Error No Image!");
                this.getChildren().addAll(this.playerName,this.cardName,this.score,this.winner);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error during playerBox setup!");
        }

    }

    // Updates all the members of box to their current values
    public void update()
    {
        try {
            this.playerName.setText(player.getPlayerName());
            this.score.setStyle("-fx-text-fill: white");
            try {
                this.cardImage.setOpacity(.5);
                this.cardImage.setImage(player.getCurrentCard().getImage());
            }
            catch (Exception ex)
            {
                System.out.println("Error No Image!");
            }
            this.cardName.setText(player.getCurrentCard().toString());
            if (this.player.getWins() > this.current) {
                this.current = this.player.getWins();
                this.score.setStyle("-fx-text-fill: turquoise");
                try {
                    this.cardImage.setOpacity(1.0);
                }
                catch (Exception ex)
                {
                    System.out.println("Error No Image to update!");
                }
            }
            this.score.setText("Wins: " + this.player.getWins());
        }
        catch (Exception ex)
        {
            System.out.println("Error during update!");
        }
    }

    // Visually emphasises the final winner
    public void setWinner()
    {
        this.player.setFinalWins();
        this.winner.setVisible(true);
        try {
            this.cardImage.setOpacity(1.0);
            this.cardImage.setEffect(borderGlow);
        }
        catch (Exception ex)
        {
            System.out.println("Error No Image to update in setWinner!");
        }
    }

    // resets the final winner back to normal
    public void resetWinner()
    {
        this.current=0;
        this.winner.setVisible(false);
        this.cardImage.setEffect(null);
    }

    // The card flip animation
    public void cardFlip()
    {
        ScaleTransition stHideFront = new ScaleTransition(Duration.millis(300), this.cardImage);
        stHideFront.setFromX(1);
        stHideFront.setToX(0);

        final ScaleTransition stShowBack = new ScaleTransition(Duration.millis(300), this.cardImage);
        stShowBack.setFromX(0);
        stShowBack.setToX(1);

        stHideFront.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stShowBack.play();
                update();
            }
        });

        stHideFront.play();
    }


}
