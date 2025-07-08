import java.util.Arrays;

public class MaxEvents2 {
    public int maxValue(int[][] events, int k) {
        // Sorting by End Date
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1])); // Time = O(NlgN)

        int i, j, l = events.length;
        int[] p = new int[l + 1];
        getCompatibleArray(events, p); // Time = O(lgN) --> Binary search approach
        int[][] dp = new int[l + 1][k + 1];

        /*
         * DP Memoization
         * Base cases dp[0][*] = dp[*][0] = 0 by default in Java
         */
        for (i = 1; i <= l; i++) { // Time = O(N*k)
            for (j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[p[i]][j - 1] + events[i - 1][2]);
            }
        }

        for (i = 0; i <= l; i++) {
            for (j = 0; j <= k; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[l][k]; // Max Value
    }

    // Finding Previous Compatible non-overlapping events: Binary-search-based p[]
    // builder
    public void getCompatibleArray(int[][] events, int[] p) {
        int n = events.length;
        for (int i = 1; i <= n; i++) {
            int lo = 0, hi = i - 1;
            // Finding the largest lo in [0..i-1] such that events[lo-1].end <
            // events[i-1].start
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                if (events[mid - 1][1] < events[i - 1][0]) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            p[i] = lo;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("p[" + i + "] = " + p[i]);
        }
    }

    public static void main(String[] args) {
        MaxEvents2 ob = new MaxEvents2();
        int[][] events = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
        int k = 2;
        System.out.println("Max Value = " + ob.maxValue(events, k));
    }
}

/*
 * Time = O(NlgN) + O(lgN) + O(N*k) = O(NlgN + N*k)
 * Space = O(N) + O(N*k) = O(N*k)
 */
