package com.GameEngine;

import java.io.FileWriter;
import java.io.IOException;

/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
public class WriteCSV
{
    private static String csvFile = System.getProperty("user.dir") + "/src/com/Resources/SavedGames/saves.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // Method used to write to the save file
    public static void writeThis(String name, int wins)
    {
        FileWriter fileWriter = null;

        try
        {
            // Appends the save file to the end of the CSV file.
            fileWriter = new FileWriter(csvFile,true);
            fileWriter.append(name);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(wins));
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Successful print message
            System.out.println("CSV file was updated successfully !");
        }
        catch (Exception ex)
        {
            System.out.println("Error in CsvFileWriter !");
            ex.printStackTrace();
        }
        finally
        {
            // Closes the FileWriter.
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error while flushing/closing fileWriter !");
                ex.printStackTrace();
            }
        }

    }
}
