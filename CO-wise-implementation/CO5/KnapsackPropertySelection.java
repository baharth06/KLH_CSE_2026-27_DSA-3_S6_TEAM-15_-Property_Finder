package CO5;

public class KnapsackPropertySelection {

    public static void main(String[] args) {
        System.out.println("--- CO5: NP-Completeness & Approximation (0/1 Knapsack) ---");
        System.out.println("Selecting properties to maximize total square footage within a budget.\n");
        
        // Let's say an investor has a budget and wants to maximize total area bought.
        int budget = 15000000; // 1.5 Crores
        
        String[] properties = {"P1 (Gachibowli)", "P2 (Madhapur)", "P3 (Kondapur)", "P4 (Jubilee Hills)"};
        int[] prices = {6000000, 5000000, 4500000, 8000000}; // Prices in INR
        int[] areas = {1200, 1000, 950, 1800}; // Areas in sq ft
        int n = prices.length;
        
        System.out.println("Budget: ₹" + budget);
        System.out.println("Available Properties:");
        for (int i = 0; i < n; i++) {
            System.out.println(properties[i] + " - Cost: ₹" + prices[i] + " - Area: " + areas[i] + " sqft");
        }
        
        System.out.println("\nSolving 0/1 Knapsack using DP...");
        int maxArea = knapsackDP(budget, prices, areas, n, properties);
        
        System.out.println("\n=> Maximum Area achievable within budget: " + maxArea + " sqft");
    }

    // 0/1 Knapsack algorithm
    static int knapsackDP(int W, int wt[], int val[], int n, String[] properties) {
        // Due to large budget values, we scale down prices by 100,000 for DP table size
        int scale = 100000;
        int scaledW = W / scale;
        int[] scaledWt = new int[n];
        for (int i = 0; i < n; i++) {
            scaledWt[i] = wt[i] / scale;
        }

        int[][] K = new int[n + 1][scaledW + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= scaledW; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (scaledWt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - scaledWt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        
        // To find which properties are included
        int res = K[n][scaledW];
        int w = scaledW;
        System.out.println("\nProperties Selected:");
        for (int i = n; i > 0 && res > 0; i--) {
            if (res == K[i - 1][w]) {
                continue;
            } else {
                System.out.println("- " + properties[i - 1]);
                res = res - val[i - 1];
                w = w - scaledWt[i - 1];
            }
        }

        return K[n][scaledW];
    }
}
