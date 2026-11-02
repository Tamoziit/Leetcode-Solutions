/**
 * Math (Median & Absolute val)
 * Time: O(nlgn)
 * Space: O(1)
 */
import java.util.Arrays;

public class MinMovesToEqualArray2 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        long moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return (int) moves;
    }
}
