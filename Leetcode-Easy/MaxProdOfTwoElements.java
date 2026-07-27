/**
 * Time: O(n)
 * Space: O(1)
 */
public class MaxProdOfTwoElements {

    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE, maxj = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > maxi) {
                maxj = maxi;
                maxi = num;
            } else if (num > maxj) {
                maxj = num;
            }
        }

        return (maxi - 1) * (maxj - 1);
    }
}
