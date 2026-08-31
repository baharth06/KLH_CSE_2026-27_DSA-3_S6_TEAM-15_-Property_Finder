package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BoyerMooreMatcher {
    
    private final static int NO_OF_CHARS = 256;

    /**
     * Boyer-Moore pattern matching algorithm using the Bad Character Heuristic.
     * Best Case Time Complexity: O(n/m), Worst Case: O(n * m)
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

        int m = pattern.length();
        int n = text.length();

        int[] badchar = new int[NO_OF_CHARS];

        // Fill the bad character array
        badCharHeuristic(pattern, m, badchar);

        int s = 0; // s is shift of the pattern with respect to text
        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing index j of pattern while characters of pattern and text are matching
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            // If the pattern is present at current shift, then index j will become -1
            if (j < 0) {
                matches.add(s);
                // Shift the pattern so that the next character in text aligns with the last occurrence of it in pattern
                s += (s + m < n) ? m - badchar[text.charAt(s + m)] : 1;
            } else {
                // Shift the pattern so that the bad character in text aligns with the last occurrence of it in pattern.
                // max function is used to make sure that we get a positive shift.
                s += Math.max(1, j - badchar[text.charAt(s + j)]);
            }
        }
        return matches;
    }

    /**
     * Preprocessing function for Boyer Moore's bad character heuristic
     */
    private static void badCharHeuristic(String str, int size, int[] badchar) {
        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++) {
            badchar[i] = -1;
        }
        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < size; i++) {
            badchar[str.charAt(i)] = i;
        }
    }
}
