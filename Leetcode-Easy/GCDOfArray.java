/**
 * Time: O(N)
 * Space: O(1)
 */
public class GCDOfArray {

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int gcd = 1;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = 1; i < min; i++) {
            if (min % i == 0 && max % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
