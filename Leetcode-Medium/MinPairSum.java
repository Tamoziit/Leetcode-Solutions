/**
 * Algo: Optimizing(Minimizing) Max Pair-Sum --> Sorting & 2-pointer to get (nth min, nth max) pairs
 * Time: O(NlgN + N/2) = O(NlgN)
 * Space: O(1) [in logic], O(lgN) [in sorting]
 */
import java.util.Arrays;

class MinPairSum {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums); // O(NlgN)

        int l = nums.length;
        int max = nums[0] + nums[l - 1]; // default max pair-sum = min ele. + max ele. (1st min + 1st max)
        int i, sum;

        for (i = 1; i < l / 2; i++) { // O(N/2)
            // minimizing max pair-sums (ie. nth min + nth max)
            sum = nums[i] + nums[l - 1 - i]; // 2-pointer --> (2nd min, 2nd max), (3rd min, 3rd max),...
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        MinPairSum ob = new MinPairSum();
        int[] nums = {3, 5, 4, 2, 4, 6};
        int res = ob.minPairSum(nums);

        System.out.println("Optimal Max Pair-Sum = " + res);
    }
}
