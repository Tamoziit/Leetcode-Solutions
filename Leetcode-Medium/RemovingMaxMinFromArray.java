/**
 * Enumeration + Classification
 * Time: O(n)
 * Space: O(1)
 */
public class RemovingMaxMinFromArray {

    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int maxN = Integer.MIN_VALUE, minN = Integer.MAX_VALUE, maxi = -1, mini = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxN) {
                maxN = nums[i];
                maxi = i;
            }

            if (nums[i] < minN) {
                minN = nums[i];
                mini = i;
            }
        }

        // removing both from front
        int front1 = Math.max(maxi, mini) + 1;

        // removing both from back
        int back1 = nums.length - Math.min(maxi, mini);

        // removing one from front & another from back
        int front2 = Math.min(maxi, mini) + 1;
        int back2 = nums.length - Math.max(maxi, mini);

        return Math.min(front1, Math.min(back1, front2 + back2));
    }
}
