/**
 * HashMap
 * Time: O(n)
 * Space: O(n)
 */
import java.util.HashMap;
import java.util.Map;

public class SmallestMissingMultipleOfK {

    public int missingMultiple(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int multiple = k;
        while (true) {
            if (!map.containsKey(multiple)) {
                return multiple;
            }

            multiple += k;
        }
    }
}
