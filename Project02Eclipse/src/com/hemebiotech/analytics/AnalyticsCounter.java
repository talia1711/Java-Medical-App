package com.hemebiotech.analytics;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/***
 * Class that contains the GetSymptomsMap and write result method
 * @author Talia
 * @version 1.0
 * @since 2023-03
 */
public class AnalyticsCounter {

    /***
     * this function receives a list of symptoms and returns a map that represents a symptoms with the number of occurrences
     * @author Talia
     * @version 1.0
     * @since 2023-03
     */

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