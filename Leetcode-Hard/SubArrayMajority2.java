/**
 * Prefix Sum Frequency - Optimal: Fenwick Tree
 * Time: O(n)
 * Space: O(2n + 1) = O(n) [Frequency array]
 */
public class SubArrayMajority2 {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] pre = new int[2 * n + 1];

        pre[n] = 1;

        int cnt = n;
        long presum = 0;
        long ans = 0;

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
        SubArrayMajority2 ob = new SubArrayMajority2();

        System.out.println("TEST CASE 1:");
        int[] nums_1 = {1, 2, 2, 3};
        System.out.println("Majority Sub Arrays = " + ob.countMajoritySubarrays(nums_1, 2));

        System.out.println("\nTEST CASE 2:");
        int[] nums_2 = {1, 1, 1, 1};
        System.out.println("Majority Sub Arrays = " + ob.countMajoritySubarrays(nums_2, 1));

        System.out.println("\nTEST CASE 3:");
        int[] nums_3 = {1, 2, 3};
        System.out.println("Majority Sub Arrays = " + ob.countMajoritySubarrays(nums_3, 4));
    }
}
