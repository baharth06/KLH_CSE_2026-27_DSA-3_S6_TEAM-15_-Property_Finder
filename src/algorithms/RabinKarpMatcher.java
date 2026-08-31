package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpMatcher {
    
    // Number of characters in the input alphabet
    public final static int d = 256;
    
    /**
     * Rabin-Karp pattern matching algorithm using rolling hash.
     * Average/Best Time Complexity: O(n + m), Worst: O(n * m)
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
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text window
        int h = 1;
        int q = 101; // A prime number for modulo arithmetic

        // The value of h would be "pow(d, m-1)%q"
        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= n - m; i++) {

            // Check the hash values of current window of text and pattern.
            // If the hash values match then only check for characters one by one
            if (p == t) {
                // Check for characters one by one (collision handling)
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    matches.add(i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit,
            // add trailing digit
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // We might get negative value of t, converting it to positive
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
        return matches;
    }
}
