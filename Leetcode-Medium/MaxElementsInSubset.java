/**
 * Hash Table + Enumeration
 * Time: O(nloglogM)
 * Space: O(n)
 */
import java.util.HashMap;
import java.util.Map;

public class MaxElementsInSubset {

    public int maximumLength(int[] nums) {
        Map<Long, Integer> cnt = new HashMap<>();

        for (int num : nums) {
            cnt.merge((long) num, 1, Integer::sum);
        }

        // ans is at least the number of occurrences of 1, rounded down to an odd number
        int oneCnt = cnt.getOrDefault(1L, 0);
        int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;

        cnt.remove(1L);

        // We then repeatedly check whether x^2, x^4, x^8, and so on appear at least twice in the array, since one occurrence is needed on the increasing side and the other on the decreasing side.
        // Because a mountain array contains exactly one peak element, its length is always odd.
        // For every value below the peak, we count pairs of identical elements.
        // After constructing all possible pairs, if the peak value still exists in the array, we can place one occurrence at the peak and increase the total length by 1.
        // Otherwise, one element from the last pair must be used as the peak, reducing the total length by 1.
        for (long num : cnt.keySet()) {
            int res = 0;
            long x = num;

            while (cnt.containsKey(x) && cnt.get(x) > 1) {
                res += 2;
                x *= x;
            }

            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxElementsInSubset ob = new MaxElementsInSubset();

        System.out.println("TEST CASE 1:");
        int[] nums_1 = {5, 4, 1, 2, 2};
        System.out.println("Max elements in subset = " + ob.maximumLength(nums_1));

        System.out.println("TEST CASE 2:");
        int[] nums_2 = {1, 3, 2, 4};
        System.out.println("Max elements in subset = " + ob.maximumLength(nums_2));
    }
}
