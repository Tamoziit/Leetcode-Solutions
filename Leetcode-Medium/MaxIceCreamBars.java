
import java.util.Arrays;

public class MaxIceCreamBars {
    /**
     * Quick Sort + Greedy Selection
     * Time: O(nlgn) + O(n) = O(nlgn)
     * Space: O(1)
     */
    public int maxIceCream_1(int[] costs, int coins) {
        Arrays.sort(costs); // O(nlgn)

        int maxIceCreams = 0;

        for (int i = 0; i < costs.length; i++) { // O(n)
            if (coins < costs[i]) {
                break;
            } else {
                maxIceCreams++;
                coins -= costs[i];
            }
        }

        return maxIceCreams;
    }

    /**
     * Counting Sort + Greedy Selection
     * Time: O(n + maxCost)
     * Space: O(maxCost)
     */
    public int maxIceCream_2(int[] costs, int coins) {
        int maxCost = 0;

        // Counting sort - O(n)
        for (int c : costs) {
            maxCost = Math.max(maxCost, c);
        }

        int[] cnt = new int[maxCost + 1];
        for (int c : costs) {
            cnt[c]++;
        }

        // Greedy selection - O(maxCost)
        int ans = 0;
        for (int c = 1; c <= maxCost; c++) {
            if (cnt[c] == 0) {
                continue;
            }
            int buy = Math.min(cnt[c], coins / c);
            ans += buy;
            coins -= buy * c;
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxIceCreamBars ob = new MaxIceCreamBars();

        System.out.println("TEST CASE 1:");
        int[] costs_1 = {1, 3, 2, 4, 1};
        System.out.println("Max Ice Creams = " + ob.maxIceCream_1(costs_1, 7));

        System.out.println("TEST CASE 2:");
        int[] costs_2 = {10, 6, 8, 7, 7, 8};
        System.out.println("Max Ice Creams = " + ob.maxIceCream_1(costs_2, 5));

        System.out.println("TEST CASE 3:");
        int[] costs_3 = {1, 6, 3, 1, 2, 5};
        System.out.println("Max Ice Creams = " + ob.maxIceCream_1(costs_3, 20));
    }
}
