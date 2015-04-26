package com.GameEngine;


/*
 * Name:        David McFall
 * Instructor:  Dr. Jones
 * Date:        3/30/15
 * Assignment:  HighCard Game
 * Purpose:
 */
import jdk.nashorn.api.scripting.URLReader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSV {

    public  Map<String, Integer> maps = new HashMap<String, Integer>();
    public  List<SaveGame> ArraySaveList = new ArrayList<>();

    public ReadCSV()
    {

    }

    @SuppressWarnings("unchecked")
    public  void run()
    {
        // File path to the CSV universal to any operating system.
        //String csvFile = System.getProperty("user.dir") + "/src/com/Resources/SavedGames/saves.csv";
        InputStream csvFile = this.getClass().getClassLoader().getResourceAsStream("com/Resources/SavedGames/saves.csv");

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try
        {
            br = new BufferedReader(new InputStreamReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] save = line.split(cvsSplitBy);
                if(maps.containsKey(save[0]))
                {
                    int current = maps.get(save[0])+ Integer.parseInt(save[1]);
                    maps.replace(save[0],current);
                }
                else
                {
                    maps.put(save[0], Integer.valueOf(save[1]));
                }
            }

            //loop map
            for (Map.Entry<String, Integer> entry : maps.entrySet())
            {
                ArraySaveList.add(new SaveGame(entry.getKey(),entry.getValue()));

                System.out.println("Save [name= " + entry.getKey() + " , wins="
                        + entry.getValue() + "]");
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }

    public  List<SaveGame> getList()
    {
        return ArraySaveList;
    }

    public  void clear()
    {
        maps.clear();
        ArraySaveList.clear();
    }
}