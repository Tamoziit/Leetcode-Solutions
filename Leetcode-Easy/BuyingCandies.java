/**
 * Algo: Greedy
 * Time Complexity  : O(n log n) — dominated by sorting
 * Space Complexity : O(log n)  — implicit call stack from Java's dual-pivot quicksort
 */
import java.util.Arrays;

public class BuyingCandies {

    public int minimumCost(int[] cost) {
        // Sort ascending; we'll traverse from the end to simulate descending order.
        // Goal: greedily maximize the value of free candies.
        // Strategy: in every group of 3 (pay, pay, free), the cheapest is free.
        // Sorting descending ensures the 3rd candy in each group is the cheapest
        // possible, which maximizes total savings.
        Arrays.sort(cost);
        int res = 0;
        int n = cost.length;

        // Traverse from the most expensive candy downward.
        // Within each group of 3, positions (relative to start) are: 0 → pay, 1 → pay, 2 → free.
        // (n - 1 - i) gives the 0-based offset from the most expensive end.
        // Offset % 3 == 2 marks the free candy in each group → skip it.
        for (int i = n - 1; i >= 0; i--) {
            if ((n - 1 - i) % 3 != 2) {
                res += cost[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BuyingCandies ob = new BuyingCandies();

        int[] cost_1 = {6, 5, 7, 9, 2, 2};
        System.out.println("Min. Cost from case 1: " + ob.minimumCost(cost_1));

        int[] cost_2 = {5, 5};
        System.out.println("Min. Cost from case 2: " + ob.minimumCost(cost_2));
    }
}
