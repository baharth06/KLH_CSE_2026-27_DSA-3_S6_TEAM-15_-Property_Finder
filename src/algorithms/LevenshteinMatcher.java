package algorithms;

public class LevenshteinMatcher {

    /**
     * Calculates the Levenshtein distance between two strings using Dynamic Programming.
     * 
     * @param s1 First string
     * @param s2 Second string
     * @return The edit distance
     */
    public static int calculateDistance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings cannot be null");
        }
        
        // Convert to lowercase for case-insensitive distance
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int len1 = s1.length();
        int len2 = s2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialize dp table
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // Fill the dp table
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                
                dp[i][j] = Math.min(
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), // deletion, insertion
                    dp[i - 1][j - 1] + cost                       // substitution
                );
            }
        }
        
        return dp[len1][len2];
    }

    /**
     * Calculates the similarity percentage between two strings based on Levenshtein distance.
     * similarity = (1 - distance / maxLength) * 100
     * 
     * @param s1 First string
     * @param s2 Second string
     * @return Similarity percentage (0 to 100)
     */
    public static double calculateSimilarity(String s1, String s2) {
        int distance = calculateDistance(s1, s2);
        int maxLength = Math.max(s1.length(), s2.length());
        
        if (maxLength == 0) return 100.0; // Both strings are empty
        
        return (1.0 - (double) distance / maxLength) * 100.0;
    }
    
    /**
     * Checks if two strings are a fuzzy match based on a threshold percentage.
     */
    public static boolean isFuzzyMatch(String s1, String s2, double thresholdPercentage) {
        return calculateSimilarity(s1, s2) >= thresholdPercentage;
    }
}
