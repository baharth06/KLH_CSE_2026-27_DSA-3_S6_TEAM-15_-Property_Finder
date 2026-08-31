import service.PropertySearchService;
import benchmark.PatternMatchingBenchmark;
import model.Property;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PropertySearchService service = new PropertySearchService();

        while (true) {
            System.out.println("\n========================================");
            System.out.println("         PROPERTY FINDER - DSA          ");
            System.out.println("========================================");
            System.out.println("1. Search Properties");
            System.out.println("2. KMP Search");
            System.out.println("3. Z Algorithm Search");
            System.out.println("4. Rabin-Karp Search");
            System.out.println("5. Boyer-Moore Search");
            System.out.println("6. Naive Search");
            System.out.println("7. Fuzzy Search (Location suggestion)");
            System.out.println("8. Compare All Algorithms (Benchmark)");
            System.out.println("9. Show All Properties");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            
            String choiceStr = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(choiceStr.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice == 10) {
                System.out.println("Exiting Property Finder...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter search pattern: ");
                    String pattern = scanner.nextLine();
                    
                    // Fuzzy matching location check
                    String suggested = service.getFuzzyLocationSuggestion(pattern);
                    if (suggested != null) {
                        System.out.print("Do you want to search for '" + suggested + "' instead? (y/n): ");
                        String ans = scanner.nextLine();
                        if (ans.equalsIgnoreCase("y")) {
                            pattern = suggested;
                        }
                    }

                    System.out.println("Select algorithm (1: Naive, 2: KMP, 3: Z, 4: Rabin-Karp, 5: Boyer-Moore): ");
                    int algo = Integer.parseInt(scanner.nextLine().trim());
                    if (algo < 1 || algo > 5) {
                        System.out.println("Invalid algorithm selection.");
                        break;
                    }
                    
                    List<PropertySearchService.SearchResult> results = service.search(pattern, algo);
                    if (results.isEmpty()) {
                        System.out.println("No matching properties found.");
                    } else {
                        System.out.println("Found " + results.size() + " matches:");
                        for (PropertySearchService.SearchResult result : results) {
                            result.printResult();
                        }
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    System.out.print("Enter search pattern: ");
                    String p = scanner.nextLine();
                    
                    // Map choice to algorithm ID in service
                    // 2: KMP(2), 3: Z(3), 4: RK(4), 5: BM(5), 6: Naive(1)
                    int algoId = (choice == 6) ? 1 : choice;
                    
                    List<PropertySearchService.SearchResult> res = service.search(p, algoId);
                    if (res.isEmpty()) {
                        System.out.println("No matching properties found.");
                    } else {
                        System.out.println("Found " + res.size() + " matches:");
                        for (PropertySearchService.SearchResult result : res) {
                            result.printResult();
                        }
                    }
                    break;
                case 7:
                    System.out.print("Enter misspelled location (e.g., Gachiboli, Hydrabad): ");
                    String fuzz = scanner.nextLine();
                    String suggestion = service.getFuzzyLocationSuggestion(fuzz);
                    if (suggestion == null) {
                        System.out.println("No suitable fuzzy match found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter search pattern to benchmark: ");
                    String bp = scanner.nextLine();
                    PatternMatchingBenchmark.runBenchmark(bp);
                    break;
                case 9:
                    System.out.println("--- All Properties in System ---");
                    for (Property prop : service.getAllProperties()) {
                        System.out.println(prop.getPropertyId() + " | " + prop.getTitle() + " | " + prop.getLocation());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
