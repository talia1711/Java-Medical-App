package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomReader {
    /**
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
     */
    List<String> GetSymptoms();

}
