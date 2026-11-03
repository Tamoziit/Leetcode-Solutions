/**
 * Maths
 * Time: O(n)
 * Space: O(1)
 */
public class MinMovesToEqualArray3 {

    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        long moves = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int num : nums) {
            moves += max - num; // to make all eles. equal by ONLY INCREMENTING by +1, we need all eles. to move up to max.
        }

        return (int) moves;
    }
}
