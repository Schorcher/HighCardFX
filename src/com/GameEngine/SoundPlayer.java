package com.GameEngine;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by Server on 4/23/2015.
 */
public class SoundPlayer
{

    public Media drawSound = new Media(getClass().getResource("/com/Resources/Sounds/draw.wav").toString());
    public Media errorSound = new Media(getClass().getResource("/com/Resources/Sounds/error.wav").toString());
    public Media shuffleSound = new Media(getClass().getResource("/com/Resources/Sounds/shuffle.wav").toString());
    public Media newGameSound = new Media(getClass().getResource("/com/Resources/Sounds/newGame.wav").toString());

    SoundPlayer()
    {

    }

    public void playDrawCard()
    {
        MediaPlayer mp = new MediaPlayer(drawSound);
        mp.play();
    }

    public void playError()
    {
        MediaPlayer mp = new MediaPlayer(errorSound);
        mp.play();
    }

    public void playShuffle()
    {
        MediaPlayer mp = new MediaPlayer(shuffleSound);
        mp.play();
    }

    public void playGameStart()
    {
        MediaPlayer mp = new MediaPlayer(newGameSound);
        mp.play();
    }
}
