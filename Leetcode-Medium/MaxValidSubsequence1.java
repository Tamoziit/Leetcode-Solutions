/*
 * LC - 3201
 * Algo: Greedy (Either max length of all same parity, or max alternating parity)
 * Time = O(N)
 * Space = O(1)
 */
public class MaxValidSubsequence1 {
    public int maximumLength(int[] nums) {
        // Count of even and odd numbers
        int countEven = 0, countOdd = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                countEven++;
            else
                countOdd++;
        }

        // building alternating subsequence starting with even (0) and odd (1)
        int altStartEven = getAlternatingLength(nums, 0); // starting with even
        int altStartOdd = getAlternatingLength(nums, 1); // starting with odd

        /*
         * Returning Max of (Greedy Choice):
         * All same parity (max of count(odd), count(even))
         * Alternating parity (alternate even/odd/even...) → max such alternating
         * sequence
         */
        return Math.max(Math.max(altStartEven, altStartOdd), Math.max(countEven, countOdd));

    }

    // Helper to get length of alternating parity subsequence
    private int getAlternatingLength(int[] nums, int startParity) {
        int expectedParity = startParity;
        int count = 0;

        for (int num : nums) {
            if (num % 2 == expectedParity) {
                count++;
                expectedParity ^= 1; // flip parity: 0 → 1, 1 → 0
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaxValidSubsequence1 ob = new MaxValidSubsequence1();
        System.out.println(ob.maximumLength(new int[] { 1, 2, 3, 4 })); // Output: 4
        System.out.println(ob.maximumLength(new int[] { 1, 2, 1, 1, 2, 1, 2 })); // Output: 6
        System.out.println(ob.maximumLength(new int[] { 1, 3 })); // Output: 2
    }
}
