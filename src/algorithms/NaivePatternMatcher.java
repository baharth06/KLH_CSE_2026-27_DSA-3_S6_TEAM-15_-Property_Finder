package algorithms;

import java.util.ArrayList;
import java.util.List;

public class NaivePatternMatcher {
    
    /**
     * Naive string matching algorithm.
     * Time Complexity: O(n * m) where n is text length and m is pattern length.
     * 
     * @param text The text to search in
     * @param pattern The pattern to search for
     * @return List of starting indices where pattern is found in text
     */
    public static List<Integer> search(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        if (text == null || pattern == null || pattern.length() == 0 || text.length() < pattern.length()) {
            return matches;
        }

        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                matches.add(i);
            }
        }

        return matches;
    }
}
