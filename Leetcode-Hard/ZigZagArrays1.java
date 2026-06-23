/**
 * Dynammic Programming (Memoization - 2D DP) + Prefix Sum
 * Time: O(m² + n·m), where m = r - l + 1 & n = length of array
 * - Base case (n = 2) = O(m²)
 * - DP loop (n = 3...n) = O(n·m)
 * - Answer accumulation = O(m) [doesn't dominate]
 * So, T = O(m² + n·m)
 * Space: O(n·m)
 */
public class ZigZagArrays1 {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1; // range shifting

        // 1-indexed up & down DP
        int[][] up = new int[n + 1][m];
        int[][] down = new int[n + 1][m];

        // Base case: n = 2
        for (int x = 0; x < m; x++) { // O(m²)
            for (int y = 0; y < m; y++) {
                if (x == y) {
                    continue;
                }
                if (x < y) {
                    up[2][y] = (up[2][y] + 1) % MOD;
                } else {
                    down[2][y] = (down[2][y] + 1) % MOD;
                }
            }
        }

        // for array length = 3...n := O(n·m)
        for (int i = 3; i <= n; i++) { // for 1-indexed DP
            // prefix sums for fast range queries
            int[] prefUp = new int[m + 1];
            int[] prefDown = new int[m + 1];

            // prefix sum calculation
            for (int v = 0; v < m; v++) {
                prefUp[v + 1] = (prefUp[v] + up[i - 1][v]) % MOD;
                prefDown[v + 1] = (prefDown[v] + down[i - 1][v]) % MOD;
            }

            for (int y = 0; y < m; y++) {
                // up[i][y] = sum of all down[i-1][x], for x < y
                up[i][y] = prefDown[y];

                // down[i][y] = sum of all up[i-1][x], for x > y
                down[i][y] = ((prefUp[m] - prefUp[y + 1]) % MOD + MOD) % MOD;
            }
        }

        long ans = 0;
        if (n == 1) {
            ans = m; // Single element arrays are always valid
        } else {
            // ans of DP = Summation(up[n][y] + down[n][y]) in y = [0, m]
            for (int y = 0; y < m; y++) { // O(m)
                ans = (ans + up[n][y] + down[n][y]) % MOD;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        ZigZagArrays1 ob = new ZigZagArrays1();

        System.out.println("TEST CASE 1:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(3, 4, 5));

        System.out.println("TEST CASE 2:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(3, 1, 3));

        System.out.println("TEST CASE 3:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(100, 1000, 10109));
    }
}
