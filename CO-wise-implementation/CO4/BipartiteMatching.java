package CO4;

import java.util.Arrays;

public class BipartiteMatching {
    
    // M buyers and N properties
    static final int M = 4;
    static final int N = 4;

    public static void main(String[] args) {
        System.out.println("--- CO4: Network Flow (Maximum Bipartite Matching) ---");
        System.out.println("Matching Buyers to Properties based on budget and preference.\n");
        
        // bpGraph[i][j] is 1 if Buyer i can afford and wants Property j
        // Buyers: 0 (Alice), 1 (Bob), 2 (Charlie), 3 (David)
        // Properties: 0 (P1), 1 (P2), 2 (P3), 3 (P4)
        boolean bpGraph[][] = new boolean[][]{
            {true, true, false, false},
            {false, true, true, false},
            {true, false, false, true},
            {false, false, true, false}
        };

        String[] buyers = {"Alice", "Bob", "Charlie", "David"};
        String[] properties = {"Villa in Gachibowli", "3BHK in Madhapur", "2BHK in Kondapur", "Penthouse in Jubilee Hills"};

        int[] match = maxBPM(bpGraph);
        
        System.out.println("Maximum Number of assignments: " + countMatches(match));
        System.out.println("\nAssignments:");
        for (int i = 0; i < N; i++) {
            if (match[i] != -1) {
                System.out.println(buyers[match[i]] + " gets assigned to '" + properties[i] + "'");
            }
        }
    }

    // A DFS based recursive function that returns true if a
    // matching for vertex u is possible
    static boolean bpm(boolean bpGraph[][], int u, boolean seen[], int matchR[]) {
        for (int v = 0; v < N; v++) {
            if (bpGraph[u][v] && !seen[v]) {
                seen[v] = true; 
                
                // If property 'v' is not assigned to an applicant OR
                // previously assigned applicant for property v (which is matchR[v]) 
                // has an alternate property available.
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Returns maximum number of matching from M to N
    static int[] maxBPM(boolean bpGraph[][]) {
        // An array to keep track of the buyers assigned to properties.
        // The value of matchR[i] is the buyer ID assigned to property i,
        // the value -1 indicates nobody is assigned.
        int matchR[] = new int[N];
        Arrays.fill(matchR, -1);

        int result = 0; 
        for (int u = 0; u < M; u++) {
            boolean seen[] = new boolean[N];
            Arrays.fill(seen, false);

            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return matchR;
    }
    
    static int countMatches(int[] matchR) {
        int count = 0;
        for (int m : matchR) {
            if (m != -1) count++;
        }
        return count;
    }
}
