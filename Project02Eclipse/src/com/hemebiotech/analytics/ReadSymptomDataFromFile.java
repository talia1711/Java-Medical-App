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
     * this method receives the filepath in the input file
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


}




