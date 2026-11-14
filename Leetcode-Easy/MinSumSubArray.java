/**
 * Sliding window
 * Time: O(n^2)
 * Space: O(1)
 */
import java.util.List;

public class MinSumSubArray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int currMin = Integer.MAX_VALUE;
        int sum;

        for (int i = 0; i < nums.size(); i++) {
            sum = 0;

            for (int j = i; j < nums.size() && j - i + 1 <= r; j++) {
                sum += nums.get(j);

                if (j - i + 1 >= l && sum > 0) {
                    currMin = Math.min(currMin, sum);
                }
            }
        }

        return currMin == Integer.MAX_VALUE ? -1 : currMin;
    }
}
