package benchmark;

import algorithms.*;
import service.PropertySearchService;

import java.util.List;

public class PatternMatchingBenchmark {

    public static void runBenchmark(String pattern) {
        System.out.println("\n==================================================");
        System.out.println("PATTERN MATCHING BENCHMARK");
        System.out.println("==================================================");
        System.out.println("Search Pattern: " + pattern);
        System.out.println();
        
        PropertySearchService service = new PropertySearchService();
        String normalizedPattern = pattern.toLowerCase();
        
        // Combine all text data into a single huge text to see the real difference
        StringBuilder sb = new StringBuilder();
        service.getAllProperties().forEach(p -> {
            sb.append(p.getTitle()).append(" ")
              .append(p.getLocation()).append(" ")
              .append(p.getDistrict()).append(" ")
              .append(p.getPropertyType()).append(" ")
              .append(p.getAmenities()).append(" ")
              .append(p.getDescription()).append(" ");
        });
        String text = sb.toString().toLowerCase();
        
        System.out.println("Text Size (Total Characters): " + text.length());
        System.out.println();
        System.out.printf("%-20s | %-10s | %-15s\n", "Algorithm", "Matches", "Time (ns)");
        System.out.println("--------------------------------------------------");

        // 1. Naive
        long start = System.nanoTime();
        List<Integer> naiveMatches = NaivePatternMatcher.search(text, normalizedPattern);
        long naiveTime = System.nanoTime() - start;
        System.out.printf("%-20s | %-10d | %-15d\n", "Naive", naiveMatches.size(), naiveTime);

        // 2. KMP
        start = System.nanoTime();
        List<Integer> kmpMatches = KMPPatternMatcher.search(text, normalizedPattern);
        long kmpTime = System.nanoTime() - start;
        System.out.printf("%-20s | %-10d | %-15d\n", "KMP", kmpMatches.size(), kmpTime);

        // 3. Z Algorithm
        start = System.nanoTime();
        List<Integer> zMatches = ZPatternMatcher.search(text, normalizedPattern);
        long zTime = System.nanoTime() - start;
        System.out.printf("%-20s | %-10d | %-15d\n", "Z Algorithm", zMatches.size(), zTime);

        // 4. Rabin-Karp
        start = System.nanoTime();
        List<Integer> rkMatches = RabinKarpMatcher.search(text, normalizedPattern);
        long rkTime = System.nanoTime() - start;
        System.out.printf("%-20s | %-10d | %-15d\n", "Rabin-Karp", rkMatches.size(), rkTime);

        // 5. Boyer-Moore
        start = System.nanoTime();
        List<Integer> bmMatches = BoyerMooreMatcher.search(text, normalizedPattern);
        long bmTime = System.nanoTime() - start;
        System.out.printf("%-20s | %-10d | %-15d\n", "Boyer-Moore", bmMatches.size(), bmTime);
        
        System.out.println("==================================================\n");
    }
}
