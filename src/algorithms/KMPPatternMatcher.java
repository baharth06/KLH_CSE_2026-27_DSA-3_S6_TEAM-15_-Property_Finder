package algorithms;

import java.util.ArrayList;
import java.util.List;

public class KMPPatternMatcher {

    /**
     * Knuth-Morris-Pratt (KMP) string matching algorithm.
     * Time Complexity: O(n + m) where n is text length and m is pattern length.
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
        
        // Build LPS (Longest Prefix Suffix) array
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                matches.add(i - j);
                j = lps[j - 1]; // Reset j using LPS
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Fallback to previous LPS
                } else {
                    i = i + 1;
                }
            }
        }
        return matches;
    }

    /**
     * Helper method to compute the LPS array for the KMP algorithm.
     */
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // Calculate lps[i] for i = 1 to m-1
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
