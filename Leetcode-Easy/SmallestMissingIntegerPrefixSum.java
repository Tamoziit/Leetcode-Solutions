/**
 * Prefix Sum + HashSet
 * Time: O(n)
 * Space: O(n)
 */
import java.util.HashSet;
import java.util.Set;

public class SmallestMissingIntegerPrefixSum {

    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }

            prefixSum += nums[i];
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        while (seen.contains(prefixSum)) {
            prefixSum++;
        }

        return prefixSum;
    }
}
