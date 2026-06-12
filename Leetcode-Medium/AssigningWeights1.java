/**
 * DFS
 * Time: O(n)
 * Space: O(n)
 * n = no. of nodes in the tree
 */
import java.util.ArrayList;
import java.util.List;

public class AssigningWeights1 {

    private static final int MOD = 1_000_000_007;

    private int qpow(int x, int y) {
        long res = 1;
        long base = x;

        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            y >>= 1;
        }

        return (int) res;
    }

    private int dfs(List<List<Integer>> g, int x, int f) {
        int maxDep = 0;

        for (int y : g.get(x)) {
            if (y == f) {
                continue;
            }

            maxDep = Math.max(maxDep, dfs(g, y, x) + 1);
        }

        return maxDep;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int maxDep = dfs(g, 1, 0);
        return qpow(2, maxDep - 1);
    }

    public static void main(String[] args) {
        AssigningWeights1 ob = new AssigningWeights1();

        System.out.println("TEST CASE 1:");
        int[][] edges_1 = {{1, 2}};
        System.out.println("Res: " + ob.assignEdgeWeights(edges_1));

        System.out.println("TEST CASE 2:");
        int[][] edges_2 = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        System.out.println("Res: " + ob.assignEdgeWeights(edges_2));
    }
}
