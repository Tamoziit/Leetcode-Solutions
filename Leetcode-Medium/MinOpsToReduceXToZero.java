/**
 * Max Subarray with Two-Pointer + Sliding Window
 * Time: O(n)
 * Space: O(1)
 */
public class MinOpsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int S = 0, n = nums.length;

        for (int num : nums) {
            S = S + num;
        }

        int k = S - x; // target sum for the remaining subarray
        if (k < 0) {
            return -1; // even removing everything can't reduce sum enough
        }
        if (k == 0) {
            return n; // removing nothing already works
        }

        // To get the min ops required to make x = 0, ie, eliminate nums from arr such that sum = x
        // Or, we can find max subarray with sum = total sum (S) - x = k (max subarray -> least eles. eliminated)
        // Total ops = n - len(max subarray)
        int best = 0, i = 0, sum = 0;
        boolean found = false;

        for (int j = 0; j < n; j++) {
            sum += nums[j];

            while (sum > k) {
                sum -= nums[i++]; // shrinking the window
            }

            if (sum == k) {
                found = true;
                best = Math.max(best, j - i + 1);
            }
        }

        return found ? n - best : -1;
    }
}
