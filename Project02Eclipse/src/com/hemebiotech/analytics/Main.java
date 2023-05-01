package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/***
 * main class that starts the program
 * @author Talia
 * @version 1.0
 * @since 2023-03
 */

public class Main {

    public static void main(String args[]) throws Exception {

        ReadSymptomDataFromFile symptomProcessor = new ReadSymptomDataFromFile("symptoms.txt");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        List<String> symptomList = symptomProcessor.GetSymptoms();
        Map<String, Integer> symptomMap = analyticsCounter.GetSymptomsMap(symptomList);
        analyticsCounter.writeResult(symptomMap);


    }
}
