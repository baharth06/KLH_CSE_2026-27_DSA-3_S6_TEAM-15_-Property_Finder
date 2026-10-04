package CO1;

public class AlgorithmSelector {

    public static void main(String[] args) {
        System.out.println("--- CO1: Advanced Algorithm Selection for Property Finder ---");
        
        String[] sampleTexts = {
            "Short property title: 2 BHK Flat",
            "A very long property description spanning multiple paragraphs with lots of amenities like Pool, Gym, Security, and more. This requires a much more efficient search approach to avoid performance bottlenecks..."
        };
        
        String pattern = "Pool";
        
        for (String text : sampleTexts) {
            System.out.println("\nAnalyzing text of length: " + text.length());
            selectAlgorithm(text, pattern);
        }
    }

    public static void selectAlgorithm(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        System.out.println("Criteria: Text size (N) = " + n + ", Pattern size (M) = " + m);
        
        if (n < 50) {
            System.out.println("=> Selected Algorithm: Naive String Matching");
            System.out.println("=> Reason: For very short texts, the O(N*M) overhead is negligible and avoids pre-processing time (like LPS array).");
        } else if (n > 50 && m < 10) {
            System.out.println("=> Selected Algorithm: KMP or Z-Algorithm");
            System.out.println("=> Reason: For larger texts, linear O(N+M) complexity is required to prevent performance degradation.");
        } else {
            System.out.println("=> Selected Algorithm: Rabin-Karp or Boyer-Moore");
            System.out.println("=> Reason: For large texts and long patterns, hash-based or heuristic-based skipping (Boyer-Moore) is optimal.");
        }
    }
}
