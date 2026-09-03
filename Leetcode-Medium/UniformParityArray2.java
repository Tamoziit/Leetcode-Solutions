
/**
 * Classification
 * Time: O(n)
 * Space: O(1)
 */
public class UniformParityArray2 {

    // let mn = min in nums1[]
    // If mn is odd, return true directly.
    // If mn is even, return true only if there are no odd numbers in the array, otherwise return false.
    public boolean uniformArray(int[] nums1) {
        int mn = nums1[0];
        boolean hasOdd = false;

        for (int v : nums1) {
            if (v < mn) {
                mn = v;
            }

            if (v % 2 == 1) {
                hasOdd = true;
            }
        }

        if (mn % 2 == 1) {
            return true;
        }

        return !hasOdd;
    }
}
