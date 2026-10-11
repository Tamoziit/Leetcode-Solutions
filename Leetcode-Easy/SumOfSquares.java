/**
 * Simulation
 * Time: O(n)
 * Space: O(1)
 */
public class SumOfSquares {

    public int sumOfSquares(int[] nums) {
        int res = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                res += (nums[i] * nums[i]);
            }
        }

        return res;
    }
}
