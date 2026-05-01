/**
 * Time: O(mnk)
 * Space: O(mnk)
 * Algo: Dynamic Programming in 3-D
 */
import java.util.Arrays;

public class MaxPathScoreGrid {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        int i, j, c;

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = 0; // initial state

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                for (c = 0; c <= k; c++) {
                    if (dp[i][j][c] == Integer.MIN_VALUE)
                        continue;

                    if (i + 1 < m) { // down
                        int cost = grid[i + 1][j] == 0 ? 0 : 1;

                        if (c + cost <= k) { // not exceeding cost
                            dp[i + 1][j][c + cost] = Math.max(dp[i + 1][j][c + cost], dp[i][j][c] + grid[i + 1][j]);
                        }
                    }

                    if (j + 1 < n) { // right
                        int cost = grid[i][j + 1] == 0 ? 0 : 1;

                        if (c + cost <= k) { // not exceeding cost
                            dp[i][j + 1][c + cost] = Math.max(dp[i][j + 1][c + cost], dp[i][j][c] + grid[i][j + 1]);
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]); // max cost is present along dp[m-1][n-1] by principle of dp
        }

        return ans < 0 ? -1 : ans; // checking for invalid
    }

    public static void main(String[] args) {
        MaxPathScoreGrid ob = new MaxPathScoreGrid();

        int[][] grid1 = { { 0, 1 }, { 2, 0 } };
        int[][] grid2 = { { 0, 1 }, { 1, 2 } };

        System.out.println("For Grid 1 & cost 1: " + ob.maxPathScore(grid1, 1));
        System.out.println("For Grid 2 & cost 1: " + ob.maxPathScore(grid2, 1));
        System.out.println("For Grid 2 & cost 4: " + ob.maxPathScore(grid2, 4));
    }
}
