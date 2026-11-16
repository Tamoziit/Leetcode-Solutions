/**
 * Simulation
 * Time: O(n) [Amortized]
 * Space: O(n)
 */
public class DigitSumOfAString {
    public String digitSum(String s, int k) {
        String cpy = s;

        while (cpy.length() > k) {
            StringBuilder curr = new StringBuilder();

            for (int start = 0; start < cpy.length(); start += k) {
                int end = Math.min(start + k, cpy.length());
                int sum = 0;

                for (int i = start; i < end; i++) {
                    sum += cpy.charAt(i) - '0';
                }

                curr.append(sum);
            }

            cpy = curr.toString();
        }

        return cpy;
    }
}
