/**
 * Greedy:
 * - No subarray can have a larger max than globalMax of the whole array, & smaller min than globalMin.
 * - Diff. b/w max & min of any subarray of the whole array is maximized by (globalMax - globalMin).
 * - So best strategy is picking the whole subarray 'k' times to maximize (k * maxDiff)
 *
 * Time: O(N)
 * Space: O(1)
 */
public class MaxTotalSubarray {

    public long maxTotalValue(int[] nums, int k) {
        int globalMin = Integer.MAX_VALUE;
        int globalMax = Integer.MIN_VALUE;
        long maxDiff;

        for (int i = 0; i < nums.length; i++) {
            globalMin = Math.min(globalMin, nums[i]);
            globalMax = Math.max(globalMax, nums[i]);
        }

        maxDiff = (long) k * (globalMax - globalMin);
        return maxDiff;
    }

    public static void main(String[] args) {
        MaxTotalSubarray ob = new MaxTotalSubarray();

        System.out.println("TEST CASE 1:");
        int[] nums_1 = {1, 3, 2};
        System.out.println("Result = " + ob.maxTotalValue(nums_1, 2));

        System.out.println("TEST CASE 2:");
        int[] nums_2 = {4, 2, 5, 1};
        System.out.println("Result = " + ob.maxTotalValue(nums_2, 3));

        System.out.println("TEST CASE 3:");
        int[] nums_3 = {0, Integer.MAX_VALUE};
        System.out.println("Result = " + ob.maxTotalValue(nums_3, 2));
    }
}
