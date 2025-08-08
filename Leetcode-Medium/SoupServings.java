/*
 * LC - 808
 * Algo: Dynamic Programming
 * Time = O(N^2)
 * Space = O(N^2)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoupServings {
    // Memoization map to cache computed results
    private final Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        // Optimization: For large n, result approaches 1
        if (n >= 4800)
            return 1.0;

        int units = (int) Math.ceil(n / 25.0);
        return dp(units, units);
    }

    private double dp(int a, int b) {
        // Base cases
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0)
            return 1.0;
        if (b <= 0)
            return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursively calculate using all 4 operations
        double probability = 0.25 * (dp(a - 4, b) +
                dp(a - 3, b - 1) +
                dp(a - 2, b - 2) +
                dp(a - 1, b - 3));

        memo.put(key, probability);
        return probability;
    }

    public static void main(String[] args) {
        SoupServings ob = new SoupServings();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no:");
        int n = sc.nextInt();

        double result = ob.soupServings(n);
        System.out.println("Probability: " + result);
        sc.close();
    }
}
