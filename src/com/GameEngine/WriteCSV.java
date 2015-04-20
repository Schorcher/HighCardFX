package com.GameEngine;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Server on 4/20/2015.
 */
public class WriteCSV
{
    public static String csvFile = System.getProperty("user.dir") + "\\src\\com\\Resources\\SavedGames\\saves.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void run()
    {

    }

    public static void writeThis(String name, int wins)
    {
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter(csvFile);
            fileWriter.append(name);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(wins));
            fileWriter.append(NEW_LINE_SEPARATOR);

            System.out.println("CSV file was created successfully !!!");
        }
        catch (Exception ex)
        {
            System.out.println("Error in CsvFileWriter !!!");
            ex.printStackTrace();
        }
        finally
        {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                ex.printStackTrace();
            }
        }

    }
}
