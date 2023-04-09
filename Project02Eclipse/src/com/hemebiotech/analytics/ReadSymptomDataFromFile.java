package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */

    public ReadSymptomDataFromFile(String filepath) {

        this.filepath = filepath;

    }

    @Override
    public List<String> GetSymptoms() {
        ArrayList<String> result = new ArrayList<String>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                result.add(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be read");
        } catch (IOException e) {
            System.out.println("The line cannot be read");
        }

        return result;

    }

    @Override
    public Map<String, Integer> GetSymptomsMap(List<String> input) {
        Map<String, Integer> result = new TreeMap<String, Integer>();

        for (String currentSymptoms : input) {

            if (result.containsKey(currentSymptoms)) {
                Integer value = result.get(currentSymptoms);
                result.put(currentSymptoms, ++value);
            } else {
                result.put(currentSymptoms, 1);

            }
        }

        System.out.println(result);


        //Receive a list of String from input
        //Create for loop on the input list to gain every symptom
        //Inside the loop logic
        //Check if the symptom exists in result
        //if yes = Get the integer value then increment
        //Then put the symptom and incremented value in the map

        //If no = else statement to add the symptom with the value 1


        return result;
    }


    @Override
    public void writeResult(Map<String, Integer> input) {

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("result.out"));

            for (Map.Entry<String, Integer> entry : input.entrySet()) {

                writer.write(entry.getKey() + ":" + entry.getValue());

                writer.newLine();

            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//Create a for loop to get the values from the TreeMap
//input represents the values from the TreeMap
//Get the key and value from each iteration of the map and write to the file




