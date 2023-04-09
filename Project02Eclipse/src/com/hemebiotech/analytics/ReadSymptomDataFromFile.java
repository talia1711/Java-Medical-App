package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/***
 * this class has the implementation of the methods defined in the iSymptomReader
 * @author Talia
 * @version 1.0
 * @since 2023-03
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * this method recieves the filepath in the input file
     *
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */

    public ReadSymptomDataFromFile(String filepath) {

        this.filepath = filepath;

    }

    /***
     * this method reads the input file defined by the filepath and stores each line that represents a symptom in the list of strings
     * returns a list of symptoms (String)
     * @author Talia
     * @version 1.0
     * @since 2023-03
     */
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

    /***
     * this function receives a list of symptoms and returns a map that represents a symptoms with the number of occurrences
     * @author Talia
     * @version 1.0
     * @since 2023-03
     */
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

        return result;
    }

    /***
     * this writes the symptoms and the number of occurrences to a text file
     * @author Talia
     * @version 1.0
     * @since 2023-03
     */
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




