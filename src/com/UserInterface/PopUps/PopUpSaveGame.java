package com.UserInterface.PopUps;

import com.GameEngine.Controller;
import com.GameEngine.ReadCSV;
import com.GameEngine.SaveGame;
import com.GameEngine.WriteCSV;
import com.UserInterface.GameUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class PopUpSaveGame
{
    private static final Stage dialogStage = new Stage();
    public static TextField nameField = new TextField("");
    public static TableView<SaveGame> saveTable = new TableView<>();
    private static boolean hasRun=false;
    private static ObservableList<SaveGame> saveList;
    private static Button saveBtn = new Button("Save");
    private static TableColumn<SaveGame,String> nameCol = new TableColumn<>("Player Name");
    private static TableColumn<SaveGame,Integer> winCol = new TableColumn<>("Wins");


    public static void firstRun()
    {
        // Sets modality properties on first run.
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(GameUI.mainStage);

        // Calls the methods to make the table.
        ReadCSV.run();
        saveTable.getColumns().addAll(nameCol, winCol);

        // Makes sure this is not called again.
        hasRun=true;
    }

    public static void start()
    {
        // Sets the modality of the window
        if(!hasRun)
        {
            firstRun();
        }


        // Sets the label for the window
        Label numLabel = new Label("Would you like to save the game?");
        numLabel.setAlignment(Pos.CENTER);

        // Sets the label for the name box
        Label nameLabel = new Label("Player Name: ");
        nameField.setPrefWidth(100);
        if(Controller.game.hasStarted())
        {
            nameField.setText(Controller.game.getPlayer(0).getPlayerName());
        }
        else
        {
            nameField.setText("Player 1");
        }

        // Sets the HBox that contains the label and text area
        HBox saveBox = new HBox();
        saveBox.setAlignment(Pos.CENTER);
        saveBox.setSpacing(25.0);
        saveBox.getChildren().addAll(nameLabel, nameField);

        makeSavesList();
        makeTable();

        // Sets the VBox for the window.
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25.0);
        vBox.getChildren().addAll(numLabel, saveBox, saveBtn, saveTable);

        // Sets On Action for save button.
        saveBtn.setOnAction(evt -> saveBtnEvent());

        // Sets the properties for the stage.
        dialogStage.setHeight(400);
        dialogStage.setWidth(315);
        dialogStage.setScene(new Scene(vBox));
        dialogStage.show();
    }

    // Makes a list of previous saves from a CSV file.
    public static void makeSavesList()
    {
        saveList = FXCollections.observableArrayList(ReadCSV.getList());
    }

    // Makes a table from the List of Values
    public static void makeTable()
    {
        // Sets the properties for name column
        nameCol.setMinWidth(150);
        nameCol.setResizable(false);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemID"));

        // Sets the properties for wins column
        winCol.setMinWidth(150);
        winCol.setResizable(false);
        winCol.setCellValueFactory(new PropertyValueFactory<>("itemWins"));

        // Makes the table un-editable
        saveTable.setEditable(false);

        // Sets the list of save items as parts of the table.
        saveTable.setItems(saveList);

        // Sets when row is click the player name text field changes to it.
        saveTable.setOnMouseClicked(evt -> clickEvt());
        saveTable.setOnKeyPressed(evt -> clickEvt());
    }

    public static void saveBtnEvent()
    {
        // Save the game
        saveGame();
        // Close the dialog box
        closeThis();
    }

    public static void saveGame()
    {
        if(Controller.game.numOfPlayers>0) {
            WriteCSV.writeThis(nameField.getText(), Controller.game.getPlayer(0).getFinalWins());
        }
        else
        {
            // do nothing
        }
    }

    public static void clickEvt()
    {
        nameField.setText(saveTable.getSelectionModel().getSelectedItem().getItemID());
    }

    public static void closeThis()
    {
        dialogStage.close();
    }

    public static Stage getStage()
    {
        return dialogStage;
    }
}
