package com.UserInterface;

import com.UserInterface.PopUps.PopUpAbout;
import com.UserInterface.PopUps.PopUpExitApp;
import com.UserInterface.PopUps.PopUpOptions;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class GameMenuBar extends MenuBar implements EventHandler<ActionEvent>
{
    GameMenuBar()
    {
        // Get constructor from super
        super();
        run();
    }

    public void run()
    {
        // run setUp
        setUp();
    }

    public void setUp()
    {
        // Add File menu
        this.getMenus().add(new Menu("File"));
            // Add the save button
            this.getMenus().get(0).getItems().add(0, new MenuItem("Save"));
            this.getMenus().get(0).getItems().get(0).setOnAction(evt -> saveEvent());
            // Add the close button
            this.getMenus().get(0).getItems().add(1, new MenuItem("Close"));
            this.getMenus().get(0).getItems().get(1).setOnAction(evt -> closeEvent());

        // Add Edit menu
        this.getMenus().add(new Menu("Edit"));
            // Add the options button
            this.getMenus().get(1).getItems().add(0, new MenuItem("Options"));
            this.getMenus().get(1).getItems().get(0).setOnAction(evt -> optionsEvent());

        // Add Help menu
        this.getMenus().add(new Menu("Help"));
            // Add the about button
            this.getMenus().get(2).getItems().add(0, new MenuItem("About"));
            this.getMenus().get(2).getItems().get(0).setOnAction(evt -> aboutEvent());

    }


    @Override
    public void handle(ActionEvent event)
    {
        // Handle event for save button
        if(event.getSource() == this.getMenus().get(0).getItems().get(0) )
        {
            saveEvent();
        }
        //Handle event for close button
        if(event.getSource() == this.getMenus().get(0).getItems().get(1) )
        {
            closeEvent();
        }
        // Handle event for options button
        if(event.getSource() == this.getMenus().get(1).getItems().get(0) )
        {
            optionsEvent();
        }
        // Handle event for about button
        if(event.getSource() == this.getMenus().get(2).getItems().get(0) )
        {
            aboutEvent();
        }

    }

    protected static void closeEvent()
    {
        PopUpExitApp.start();
        /*
         *
         *  Pop up the close window dialog.
         *
         */
    }

    protected static void saveEvent()
    {
        /*
         *
         *  Pop up the save window.
         *
         */
    }

    protected static void optionsEvent()
    {
        /*
         *
         *  Pop up the options window.
         *
         */
        PopUpOptions.run();
    }

    protected static void aboutEvent()
    {
        PopUpAbout.run();
        /*
         *
         *  Pop up the about window.
         *
         */
    }
}
