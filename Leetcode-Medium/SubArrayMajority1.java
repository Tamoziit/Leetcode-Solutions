
public class SubArrayMajority1 {

    /**
     * Brute force
     * Time: O(n^2)
     * Space: O(1)
     */
    public int countMajoritySubarrays_1(int[] nums, int target) {
        int res = 0, i, j;

        for (i = 0; i < nums.length; i++) {
            int len = 0, targetCount = 0;

            for (j = i; j < nums.length; j++) {
                len++;
                if (nums[j] == target) {
                    targetCount++;
                }

                if (targetCount > (len / 2)) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * Prefix Sum Enumaration
     * Time: O(n^2)
     * Space: O(n)
     */
    public long countMajoritySubarrays_2(int[] nums, int target) {
        int n = nums.length;

        int[] pref = new int[n + 1];

        // Prefix sum calculation
        // target -> +1
        // others -> -1
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        long ans = 0;

        // sum = targetCount - nonTargetCount
        // For target to be the majority: targetCount > nonTargetCount
        // So, sum > 0
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                if (pref[r + 1] - pref[l] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * Prefix Sum Frequency - Optimal: Fenwick Tree
     * Time: O(n)
     * Space: O(2n + 1) = O(n) [Frequency array]
     */
    public long countMajoritySubarrays_3(int[] nums, int target) {
        int n = nums.length;

        // Using an offset of n: prefix sum 0 -> index n
        int[] pre = new int[2 * n + 1];

        pre[n] = 1;

        int cnt = n; // the current prefix sum position.
        long presum = 0; // stores the number of valid prefix pairs ending at the current position.
        long ans = 0;

        // pref[r + 1] - pref[l] > 0, hence
        // pref[l] < pref[r + 1]
        // Now the problem becomes: Count how many previous prefix sums are smaller than the current prefix sum.
        for (int x : nums) {
            if (x == target) {
                presum += pre[cnt];

                cnt++;
                pre[cnt]++;
            } else {
                cnt--;

                presum -= pre[cnt];
                pre[cnt]++;
            }

            ans += presum;
        }

        return ans;
    }

    public static void main(String[] args) {
        SubArrayMajority1 ob = new SubArrayMajority1();

        System.out.println("TEST CASE 1:");
        int[] nums_1 = {1, 2, 2, 3};
        System.out.println("M1: Majority Sub Arrays = " + ob.countMajoritySubarrays_1(nums_1, 2));
        System.out.println("M2: Majority Sub Arrays = " + ob.countMajoritySubarrays_2(nums_1, 2));
        System.out.println("M3: Majority Sub Arrays = " + ob.countMajoritySubarrays_3(nums_1, 2));

        System.out.println("\nTEST CASE 2:");
        int[] nums_2 = {1, 1, 1, 1};
        System.out.println("M1: Majority Sub Arrays = " + ob.countMajoritySubarrays_1(nums_2, 1));
        System.out.println("M2: Majority Sub Arrays = " + ob.countMajoritySubarrays_2(nums_2, 1));
        System.out.println("M3: Majority Sub Arrays = " + ob.countMajoritySubarrays_3(nums_2, 1));

        System.out.println("\nTEST CASE 3:");
        int[] nums_3 = {1, 2, 3};
        System.out.println("M1: Majority Sub Arrays = " + ob.countMajoritySubarrays_1(nums_3, 4));
        System.out.println("M2: Majority Sub Arrays = " + ob.countMajoritySubarrays_2(nums_3, 4));
        System.out.println("M3: Majority Sub Arrays = " + ob.countMajoritySubarrays_3(nums_3, 4));
    }
}
