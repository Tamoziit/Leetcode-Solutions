import java.util.Arrays;

public class HouseRobber {
    /**
     * Algo: Recursive
     * Time: O(2^n) [TLE]
     * Space: O(n)
     */
    public int rob1(int[] nums) {
        return rob1(nums, nums.length - 1);
    }

    private int rob1(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob1(nums, i - 2) + nums[i], rob1(nums, i - 1));
    }

    /**
     * Algo: Recursive + memoization (top-down DP)
     * Time: O(n)
     * Space: O(n)
     */
    int[] memo;

    public int rob2(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob2(nums, nums.length - 1);
    }

    private int rob2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        if (memo[i] >= 0) {
            return memo[i];
        }

        int result = Math.max(rob2(nums, i - 2) + nums[i], rob2(nums, i - 1));
        memo[i] = result;
        return result;
    }

    public static void main(String[] args) {
        HouseRobber ob = new HouseRobber();

        System.out.println("TEST CASE 1\n---------------");
        int[] nums1 = { 2, 7, 9, 3, 1 };
        System.out.println("Max Amt. Robbed [using TLE] = " + ob.rob1(nums1));
        System.out.println("Max Amt. Robbed [using DP] = " + ob.rob2(nums1));

        System.out.println("TEST CASE 2\n---------------");
        int[] nums2 = { 1, 2, 3, 1 };
        System.out.println("Max Amt. Robbed [using TLE] = " + ob.rob1(nums2));
        System.out.println("Max Amt. Robbed [using DP] = " + ob.rob2(nums2));

        System.out.println("TEST CASE 3\n---------------");
        int[] nums3 = { 40, 2, 4, 10 };
        System.out.println("Max Amt. Robbed [using TLE] = " + ob.rob1(nums3));
        System.out.println("Max Amt. Robbed [using DP] = " + ob.rob2(nums3));
    }
}
