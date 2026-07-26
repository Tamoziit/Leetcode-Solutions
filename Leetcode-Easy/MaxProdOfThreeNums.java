/**
 * 3 max, 2 min
 * Time: O(n)
 * Space: O(1)
 */
public class MaxProdOfThreeNums {

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // updating top 3 max
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            // updating bottom 2 min
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        // max(prod. of 3 maxes, [2 mins (smallest -ves -> -ve * -ve = largest +ve) * 1st max])
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
