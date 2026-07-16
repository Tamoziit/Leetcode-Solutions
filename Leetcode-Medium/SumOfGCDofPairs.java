/**
 * Sorting + Two-Pointer
 * Time: O(n log n + n log(maxVal))
 * Space: O(n)
 */
import java.util.Arrays;

public class SumOfGCDofPairs {

    public long gcdSum(int[] nums) {
        int mxi = Integer.MIN_VALUE, n = nums.length;
        long sum = 0l;
        int[] prefixGcd = new int[n];

        for (int i = 0; i < n; i++) { // O(nlog(maxVal))
            mxi = Math.max(mxi, nums[i]); // mxi = max(nums[0], nums[1], ..., nums[i]) [cumulatively stored in mxi for each i at each iteration]
            prefixGcd[i] = gcd(nums[i], mxi);
        }

        // ascending sort
        Arrays.sort(prefixGcd); // O(nlogn)

        int left = 0, right = n - 1;
        // O(nlog(maxVal))
        while (left < right) { // ignoring mid ele (left = right) for odd length
            sum += gcd(prefixGcd[left], prefixGcd[right]); // pairwise gcd of min & max.
            left++;
            right--;
        }

        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) { // O(log(maxVal))
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
