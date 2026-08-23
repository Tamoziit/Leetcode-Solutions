/**
 * Mathematical Induction
 * Time: O(n)
 * Space: O(n) [substrings for both halves]
 */
public class SumGame {

    public boolean sumGame(String num) {
        int n = num.length();
        int[] left = get(num.substring(0, n / 2));
        int[] right = get(num.substring(n / 2, n));

        int n0 = left[0], q0 = left[1]; // known digits sum (n0) & qs marks (q0) in left half
        int n1 = right[0], q1 = right[1]; // known digits sum (n1) & qs marks (q1) in right half

        // if total qs marks (q0 + q1) is odd --> Alice is guaranteed to win, as Alice starts first & ends last --> guaranteed to make leftSum != rightSum
        // if (q0 + q1) is even --> leftSum != rightSum iff;
        // n0 - n1 != ((q1 - q0) * 9) / 2, for q0 <= q1 (can be mathematically induced for Alice)
        return (q0 + q1) % 2 == 1 || n0 - n1 != ((q1 - q0) * 9) / 2;
    }

    private int[] get(String s) {
        int nn = 0, qq = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '?') {
                qq++;
            } else {
                nn += ch - '0';
            }
        }

        return new int[] {nn, qq};
    }
}
