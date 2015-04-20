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

    public static Map<String, Integer> maps = new HashMap<String, Integer>();
    public static List<SaveGame> ArraySaveList = new ArrayList<>();
    public static File f;

    public static void run() {


        String csvFile = System.getProperty("user.dir") + "\\src\\com\\Resources\\SavedGames\\saves.csv";


        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {



            br = new BufferedReader(new FileReader(csvFile));
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

    public static void clear()
    {
        maps.clear();
        ArraySaveList.clear();
    }
}