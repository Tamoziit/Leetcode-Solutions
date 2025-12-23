import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SmallerArray {

    // Brute Force: O(N^2)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i, j;

        for (i = 0; i < n; i++) {
            res[i] = 0;
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (nums[i] > nums[j]) {
                    res[i]++;
                }
            }
        }

        return res;
    }

    // Sorting + Hashmap: O(NlgN)
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        // Storing first occurrence index
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(sorted[i], i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    // Counting Sort: O(N)
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] count = new int[101]; // since 0 <= nums[i] <= 100

        // Frequency count
        for (int num : nums) {
            count[num]++;
        }

        // Prefix sum
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        SmallerArray ob = new SmallerArray();
        int[] nums = {8, 1, 2, 2, 3};
        int[] res1 = ob.smallerNumbersThanCurrent(nums);
        int[] res2 = ob.smallerNumbersThanCurrent2(nums);
        int[] res3 = ob.smallerNumbersThanCurrent3(nums);
        int i;

        for (i = 0; i < nums.length; i++) {
            System.out.print(res1[i] + " ");
        }
        System.out.println();
        for (i = 0; i < nums.length; i++) {
            System.out.print(res2[i] + " ");
        }
        System.out.println();
        for (i = 0; i < nums.length; i++) {
            System.out.print(res3[i] + " ");
        }
        System.out.println();

        int[] nums2 = {7, 7, 7, 7};
        res1 = ob.smallerNumbersThanCurrent(nums2);
        res2 = ob.smallerNumbersThanCurrent2(nums2);
        res3 = ob.smallerNumbersThanCurrent3(nums2);

        for (i = 0; i < nums2.length; i++) {
            System.out.print(res1[i] + " ");
        }
        System.out.println();
        for (i = 0; i < nums2.length; i++) {
            System.out.print(res2[i] + " ");
        }
        System.out.println();
        for (i = 0; i < nums2.length; i++) {
            System.out.print(res3[i] + " ");
        }
        System.out.println();
    }
}
