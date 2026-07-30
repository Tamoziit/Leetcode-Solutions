
public class MinPushesToTypeWord1 {
    /**
     * Greedy
     * ith key is assigned to a pos. requiring floor(i / 8) + 1 presses [for each 8-character group for 8 allowed keys]
     * Time: O(n)
     * Space: O(1)
     */
    public int minimumPushes1(String word) {
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i / 8 + 1;
        }

        return ans;
    }

    /**
     * Greedy + Mathematics
     * the total number of key presses is
     * = 4m(m−1)+(n−8(m−1))⋅m, where
     * m = floor(n - 1 / 8) + 1; the maximum number of key presses required for any letter in a string of n characters
     * Time: O(1)
     * Space: O(1)
     */
    public int minimumPushes2(String word) {
        int n = word.length();
        int m = (n - 1) / 8 + 1;
        return m * (m - 1) * 4 + (n - (m - 1) * 8) * m;
    }
}
