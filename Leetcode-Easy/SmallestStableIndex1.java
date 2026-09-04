
public class SmallestStableIndex1 {
    /**
     * Enumeration / Simulation
     * Time: O(n^2)
     * Space: O(1)
     */
    public int firstStableIndex1(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int maxValue = nums[i];
            int minValue = nums[i];

            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, nums[j]);
            }

            for (int j = i + 1; j < n; j++) {
                minValue = Math.min(minValue, nums[j]);
            }

            if (maxValue - minValue <= k) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Prefix Max + Suffix Min
     * Time: O(n)
     * Space: O(n)
     */
    public int firstStableIndex2(int[] nums, int k) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (prefixMax[i] - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
