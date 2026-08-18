/**
 * Frequency Map + Simulation
 * Time: O(n)
 * Space: O(1) [const. 51 sized array]
 */
public class LargestAlmostMissingInteger {

    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // k = n; nearly missing = max(nums)
        if (k == n) {
            int res = nums[0];
            for (int x : nums) {
                res = Math.max(res, x);
            }

            return res;
        }

        // k = 1; nearly missing = max(nums), such that freq(max) = 1
        int[] count = new int[51]; // given constraint, 0 <= nums[i] <= 50
        for (int x : nums) {
            count[x]++;
        }

        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (count[i] == 1) {
                    return i; // max ele with count = 1
                }
            }

            return -1;
        }

        // 1 < k < n; all eles. in nums appear in subarray of size k > 1 times except nums[0], nums[n - 1]
        // nearly missing = max(nums[0], nums[n - 1]), provided both have count = 1
        //  else, missing = nums[0] or nums[n - 1], whichever has count = 1
        // else, missing = -1
        int res = -1;
        if (count[nums[0]] == 1) {
            res = Math.max(res, nums[0]);
        }

        if (count[nums[n - 1]] == 1) {
            res = Math.max(res, nums[n - 1]);
        }

        return res;
    }
}
