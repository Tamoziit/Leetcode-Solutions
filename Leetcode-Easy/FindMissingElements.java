
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingElements {
    /**
     * Sorting + Enumeration
     * Time: O(nlgn + D); D = max - min
     * Space: O(1)
     */
    public List<Integer> findMissingElements1(int[] nums) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        int i = 1, lastSeen = nums[0];
        while (i < nums.length) {
            if (nums[i] == lastSeen) {
                i++;
            } else {
                lastSeen++;
                if (nums[i] == lastSeen) {
                    i++; // it matched after incrementing — not missing
                } else {
                    list.add(lastSeen); // still doesn't match — truly missing
                }
            }
        }

        return list;
    }

    /**
     * HashSet + Enumeration
     * Time: O(n + D); D = max - min
     * Space: O(n)
     */
    public List<Integer> findMissingElements2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int num : nums) {
            st.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int num = min + 1; num < max; num++) {
            if (!st.contains(num)) {
                list.add(num);
            }
        }

        return list;
    }
}
