/**
 * Simulation
 * Time: O(N.lnM), N = len(nums), M = max integer length in nums
 * Space: O(1)
 */
public class SmallestIndexWithDigitSum {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = getSum(nums[i]);

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }

    private int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            int d = n % 10;
            sum += d;
            n /= 10;
        }

        return sum;
    }
}
