/**
 * Greedy
 * Time: O(1)
 * Space: O(1)
 */
public class MinCostToAquireItems {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long totalCost = 0;
        int minNeed = Math.min(need1, need2);

        totalCost += (long) Math.min(costBoth, cost1 + cost2) * minNeed;
        totalCost += (long) Math.min(costBoth, cost1) * (need1 - minNeed);
        totalCost += (long) Math.min(costBoth, cost2) * (need2 - minNeed);

        return totalCost;
    }
}
