
import java.util.Arrays;

public class MaxProductOfTwoDigits {
    /**
     * Sorting
     * Time: O(nlgn)
     * Space: O(n)
     */
    public int maxProduct1(int n) {
        String num = Integer.toString(n);
        char[] digits = num.toCharArray();
        Arrays.sort(digits);

        if (digits.length < 2) {
            return digits[0] - '0';
        }

        return (digits[digits.length - 2] - '0') * (digits[digits.length - 1] - '0');
    }

    /**
     * 2-max technique
     * Time: O(n)
     * Space: O(1)
     */
    public int maxProduct2(int n) {
        int max1 = 0, max2 = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }

            n /= 10;
        }

        return max1 * max2;
    }
}
