/*
 * LC - 1695
 * Algo: HashSet Approach
 * Time = O(N)
 * Space = O(N)
 */
import java.util.HashSet;
import java.util.Set;

public class MaxErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, sum = 0, max = 0;

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            max = Math.max(max, sum);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        MaxErasureValue ob = new MaxErasureValue();
        System.out.println("Max sum 1 = " + ob.maximumUniqueSubarray(new int[] { 4, 2, 4, 5, 6 }));
        System.out.println("Max sum 2 = " + ob.maximumUniqueSubarray(new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 }));
    }
}
