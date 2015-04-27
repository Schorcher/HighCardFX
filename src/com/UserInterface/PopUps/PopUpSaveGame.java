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
    public static TableView<SaveGame> saveTable;
    private static boolean hasRun=false;
    private static ObservableList<SaveGame> saveList;
    private static Button saveBtn = new Button("Save");
    private static TableColumn<SaveGame,String> nameCol;
    private static TableColumn<SaveGame,Integer> winCol;
    private static ReadCSV csv = new ReadCSV();


    public static void firstRun()
    {
        // Sets modality properties on first run.
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(GameUI.mainStage);

        // Calls the methods to make the table.
        saveTable = new TableView<>();
        csv.run();
        nameCol = new TableColumn<>("Player Name");
        winCol = new TableColumn<>("Wins");
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
        else
        {
            saveTable=null;
            saveTable=new TableView<>();
            saveList.removeAll(saveList);
            csv.clear();
            csv.run();
            nameCol.getColumns().clear();
            winCol.getColumns().clear();
            saveTable.getColumns().clear();
            saveTable.getColumns().addAll(nameCol, winCol);

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

        makeSavesList();
        makeTable();

        // Sets the HBox that contains the label and text area
        HBox saveBox = new HBox();
        saveBox.setAlignment(Pos.CENTER);
        saveBox.setSpacing(25.0);
        saveBox.getChildren().addAll(nameLabel, nameField);



        // Sets the VBox for the window.
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25.0);
        vBox.getChildren().addAll(numLabel, saveBox, saveBtn, saveTable);

        // Sets On Action for save button.
        saveBtn.setOnAction(evt -> saveBtnEvent());

        // Checks stuff
        loadSave();

        // Sets the properties for the stage.
        dialogStage.setHeight(400);
        dialogStage.setWidth(315);
        dialogStage.setScene(new Scene(vBox));
        dialogStage.show();
    }

    // Makes a list of previous saves from a CSV file.
    public static void makeSavesList()
    {
        saveList = FXCollections.observableArrayList(csv.getList());
    }

    // Makes a table from the List of Values
    public static void makeTable()
    {
        // Sets the properties for name column
        nameCol.setMinWidth(150);
        nameCol.setResizable(false);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Sets the properties for wins column
        winCol.setMinWidth(150);
        winCol.setResizable(false);
        winCol.setCellValueFactory(new PropertyValueFactory<>("wins"));

        // Makes the table un-editable
        //saveTable.setEditable(false);

        // Sets the list of save items as parts of the table.
        saveTable.setItems(saveList);

        // Sets when row is click the player name text field changes to it.
        saveTable.setOnMouseClicked(evt -> clickEvt());
        saveTable.setOnKeyPressed(evt -> clickEvt());
    }

    // Runs when save button is clicked
    public static void saveBtnEvent()
    {
        // Save the game
        saveGame();
        // Close the dialog box
        closeThis();
    }

    // Saves the game to the save file
    public static void saveGame()
    {
        if(Controller.game.numOfPlayers>0) {
            WriteCSV.writeThis(nameField.getText(), Controller.game.getPlayer(0).getFinalWins(),
                    Controller.game.getPlayer(0).getTotalGames());
        }
        else
        {
            // do nothing
        }
    }

    // When item in table is clicked, replace nameField with the name.
    public static void clickEvt()
    {
        nameField.setText(saveTable.getSelectionModel().getSelectedItem().getItemID());
    }

    // Closes the stage
    public static void closeThis()
    {
        dialogStage.close();
    }

    // Returns the stage
    public static Stage getStage()
    {
        return dialogStage;
    }

    // Loads the save
    public static void loadSave()
    {
        if(Controller.game.hasStarted())
        {
            for(int i=0; i<saveTable.getItems().size(); i++)
            {
                if(saveTable.getItems().get(i).itemID.equals(nameField.getText()))
                {
                    Controller.game.getPlayer(0).setTrueTotalGames(saveTable.getItems().get(i).getTotalGames());
                    Controller.game.getPlayer(0).setTrueTotalWins(saveTable.getItems().get(i).getWins());
                }
            }

        }
    }
}
