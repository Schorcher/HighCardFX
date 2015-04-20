package com.GameEngine;


/**
 * Created by Server on 4/19/2015.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSV {

    public static Map<String, String> maps = new HashMap<String, String>();
    public static List<SaveGame> ArraySaveList = new ArrayList<>();

    public static void run() {

        String csvFile = "C:\\Users\\Server\\IdeaProjects\\HighCardFX2.0\\src\\com\\Resources\\SavedGames\\saves.csv";


        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {



            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] save = line.split(cvsSplitBy);

                maps.put(save[0], save[1]);

            }

            //loop map
            for (Map.Entry<String, String> entry : maps.entrySet())
            {
                ArraySaveList.add(new SaveGame(entry.getKey(),entry.getValue()));

                System.out.println("Save [name= " + entry.getKey() + " , wins="
                        + entry.getValue() + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }

    public static List<SaveGame> getList()
    {
        return ArraySaveList;
    }

}