/**
 * Memoization DP + DFS
 * Time: O(N³)
 * Space: O(N²)
 */
public class StoneGame2 {

    public int stoneGameII(int[] piles) {
        int N = piles.length;
        int[] suffixSum = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        Integer[][] memo = new Integer[N][N + 1];
        return dfs(0, 1, piles, suffixSum, memo, N);
    }

    private int dfs(int i, int M, int[] piles, int[] suffixSum, Integer[][] memo, int N) {
        if (i >= N) {
            return 0;
        }
        if (i + 2 * M >= N) {
            return suffixSum[i]; // take all remaining piles
        }
        int cappedM = Math.min(M, N); // cap for array indexing
        if (memo[i][cappedM] != null) {
            return memo[i][cappedM];
        }

        int best = 0;
        for (int x = 1; x <= 2 * M; x++) {
            best = Math.max(best, suffixSum[i] - dfs(i + x, Math.max(M, x), piles, suffixSum, memo, N));
        }

        memo[i][cappedM] = best;
        return best;
    }
}
