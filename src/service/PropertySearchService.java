package service;

import algorithms.*;
import data.TelanganaPropertyData;
import model.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertySearchService {

    private List<Property> properties;

    public PropertySearchService() {
        this.properties = TelanganaPropertyData.generateData();
    }
    
    public List<Property> getAllProperties() {
        return properties;
    }

    public static class SearchResult {
        public Property property;
        public String matchedField;
        public int matchPosition;
        public String algorithmUsed;

        public SearchResult(Property p, String field, int pos, String algo) {
            this.property = p;
            this.matchedField = field;
            this.matchPosition = pos;
            this.algorithmUsed = algo;
        }
        
        public void printResult() {
            System.out.println("----------------------------------------");
            System.out.println(property.toString());
            System.out.println("Matched Field: " + matchedField);
            System.out.println("Match Position: " + matchPosition);
            System.out.println("Algorithm Used: " + algorithmUsed);
        }
    }

    /**
     * Searches all properties across multiple fields using the specified algorithm.
     */
    public List<SearchResult> search(String pattern, int algorithmChoice) {
        List<SearchResult> results = new ArrayList<>();
        // Normalize pattern for case-insensitive search
        String normalizedPattern = pattern.toLowerCase();
        
        String algoName = getAlgorithmName(algorithmChoice);

        for (Property p : properties) {
            // Search in various fields
            searchInField(p, "Title", p.getTitle(), normalizedPattern, algorithmChoice, algoName, results);
            searchInField(p, "Location", p.getLocation(), normalizedPattern, algorithmChoice, algoName, results);
            searchInField(p, "District", p.getDistrict(), normalizedPattern, algorithmChoice, algoName, results);
            searchInField(p, "Property Type", p.getPropertyType(), normalizedPattern, algorithmChoice, algoName, results);
            searchInField(p, "Amenities", p.getAmenities(), normalizedPattern, algorithmChoice, algoName, results);
            searchInField(p, "Description", p.getDescription(), normalizedPattern, algorithmChoice, algoName, results);
        }

        return results;
    }

    private void searchInField(Property p, String fieldName, String fieldValue, String pattern, 
                               int algorithmChoice, String algoName, List<SearchResult> results) {
        if (fieldValue == null) return;
        
        String normalizedText = fieldValue.toLowerCase();
        List<Integer> matches = new ArrayList<>();

        switch (algorithmChoice) {
            case 1:
                matches = NaivePatternMatcher.search(normalizedText, pattern);
                break;
            case 2:
                matches = KMPPatternMatcher.search(normalizedText, pattern);
                break;
            case 3:
                matches = ZPatternMatcher.search(normalizedText, pattern);
                break;
            case 4:
                matches = RabinKarpMatcher.search(normalizedText, pattern);
                break;
            case 5:
                matches = BoyerMooreMatcher.search(normalizedText, pattern);
                break;
        }

        // Add all distinct matches
        for (int pos : matches) {
            // Check if we already added this property for the same field (to avoid duplicates if matched multiple times)
            // But requirement says "return all matches", we'll just add the first match found in a field for simplicity
            // or add all. Let's add all.
            results.add(new SearchResult(p, fieldName, pos, algoName));
            break; // Just one match per field is enough to show it matched
        }
    }

    private String getAlgorithmName(int choice) {
        switch (choice) {
            case 1: return "Naive";
            case 2: return "KMP";
            case 3: return "Z Algorithm";
            case 4: return "Rabin-Karp";
            case 5: return "Boyer-Moore";
            default: return "Unknown";
        }
    }

    /**
     * Fuzzy matching for location correction.
     * Finds the closest matching location from the existing properties if no exact match is found.
     */
    public String getFuzzyLocationSuggestion(String inputLocation) {
        String bestMatch = null;
        double highestSimilarity = 0.0;
        
        // Extract unique locations
        List<String> uniqueLocations = new ArrayList<>();
        for (Property p : properties) {
            if (!uniqueLocations.contains(p.getLocation())) {
                uniqueLocations.add(p.getLocation());
            }
        }
        
        for (String loc : uniqueLocations) {
            double similarity = LevenshteinMatcher.calculateSimilarity(inputLocation, loc);
            if (similarity > highestSimilarity) {
                highestSimilarity = similarity;
                bestMatch = loc;
            }
        }
        
        // Let's set a minimum threshold to suggest
        if (highestSimilarity >= 50.0 && highestSimilarity < 100.0) {
            System.out.printf("\nDid you mean: '%s'? (Similarity: %.1f%%)\n", bestMatch, highestSimilarity);
            return bestMatch;
        }
        
        return null;
    }
}
