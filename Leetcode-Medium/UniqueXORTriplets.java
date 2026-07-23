/**
 * Pattern Intuition
 * Time: O(lgn)
 * Space: O(1)
 */
public class UniqueXORTriplets {

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }

        return ans;
    }
}
