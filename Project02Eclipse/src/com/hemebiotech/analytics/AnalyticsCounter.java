package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String args[]) throws Exception {
        // object of the class ReadSymptomDataFromFile with the filepath
        ReadSymptomDataFromFile symptomProcessor = new ReadSymptomDataFromFile("symptoms.txt");

        List<String> symptomList = symptomProcessor.GetSymptoms();
        Map<String, Integer> symptomMap = symptomProcessor.GetSymptomsMap(symptomList);
        symptomProcessor.writeResult(symptomMap);


    }

}