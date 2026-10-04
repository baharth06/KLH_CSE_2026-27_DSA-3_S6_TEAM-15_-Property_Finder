package CO2;

import java.util.ArrayList;
import java.util.List;

public class StringMatching {

    public static void main(String[] args) {
        System.out.println("--- CO2: String Algorithms (KMP Pattern Matching) ---");
        
        String description = "Spacious 3 BHK apartment in Gachibowli with Pool, Gym, and 24/7 Security. Close to IT Park.";
        String pattern1 = "Pool";
        String pattern2 = "Garden";
        
        System.out.println("Property Description: " + description);
        
        System.out.println("\nSearching for: '" + pattern1 + "'");
        List<Integer> matches1 = kmpSearch(description, pattern1);
        if (matches1.isEmpty()) {
            System.out.println("=> '" + pattern1 + "' not found.");
        } else {
            System.out.println("=> '" + pattern1 + "' found at indices: " + matches1);
        }

        System.out.println("\nSearching for: '" + pattern2 + "'");
        List<Integer> matches2 = kmpSearch(description, pattern2);
        if (matches2.isEmpty()) {
            System.out.println("=> '" + pattern2 + "' not found.");
        } else {
            System.out.println("=> '" + pattern2 + "' found at indices: " + matches2);
        }
    }

    // KMP Search Implementation
    public static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) return result;
        
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPS(pattern);
        
        int i = 0; // index for text
        int j = 0; // index for pattern
        
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;
        
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
