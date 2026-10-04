package CO3;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println("--- CO3: Advanced Dynamic Programming (Edit Distance) ---");
        
        String[] validLocations = {"Gachibowli", "Madhapur", "Kondapur", "Jubilee Hills", "Banjara Hills"};
        String userQuery = "Gachiboli"; // Typo
        
        System.out.println("User searched for: '" + userQuery + "'");
        
        String bestMatch = null;
        int minDistance = Integer.MAX_VALUE;
        
        System.out.println("\nCalculating Levenshtein Distance (DP):");
        for (String loc : validLocations) {
            int dist = calculateLevenshteinDistance(userQuery, loc);
            System.out.println("Distance to '" + loc + "': " + dist);
            
            if (dist < minDistance) {
                minDistance = dist;
                bestMatch = loc;
            }
        }
        
        // Threshold for typo correction
        if (minDistance <= 3) {
            System.out.println("\n=> Did you mean: '" + bestMatch + "'? (Distance: " + minDistance + ")");
        } else {
            System.out.println("\n=> No valid location found.");
        }
    }

    public static int calculateLevenshteinDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // Min operations = j insertions
                } else if (j == 0) {
                    dp[i][j] = i; // Min operations = i deletions
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],        // Insert
                                   Math.min(dp[i - 1][j],        // Remove
                                            dp[i - 1][j - 1]));  // Replace
                }
            }
        }
        
        return dp[m][n];
    }
}
