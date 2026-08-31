package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ZPatternMatcher {

    /**
     * Z Algorithm for pattern matching.
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

        // Create concatenated string: pattern + specialDelimiter + text
        // Delimiter should not be present in text or pattern.
        String concat = pattern + "$" + text;
        int l = concat.length();

        // Construct Z array
        int[] Z = new int[l];
        getZArray(concat, Z);

        // Iterate over Z array to find matches
        // If Z value is equal to pattern length, then match is found
        for (int i = 0; i < l; i++) {
            if (Z[i] == pattern.length()) {
                // Adjust index: i minus pattern length minus 1 (for delimiter)
                matches.add(i - pattern.length() - 1);
            }
        }
        return matches;
    }

    /**
     * Fills Z array for given string.
     */
    private static void getZArray(String str, int[] Z) {
        int n = str.length();
        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && str.charAt(R - L) == str.charAt(R)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (Z[k] < R - i + 1) {
                    Z[i] = Z[k];
                } else {
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}
