/**
 * LCA + DFS
 * Time: O(nlgn + mlgn)
 * Space: O(nlgn)
 * Where, n = no. of nodes in the tree, m = no. of queries
 */
import java.util.ArrayList;
import java.util.List;

class LCA {

    private final int n;
    private final int m;
    private final int[] d;
    private final List<Integer>[] e;
    private final int[][] f;

    @SuppressWarnings("unchecked")
    public LCA(int[][] edges, int root) {
        n = edges.length + 1;
        m = (int) (Math.log(n) / Math.log(2)) + 1;
        e = new ArrayList[n + 1];
        d = new int[n + 1];
        f = new int[n + 1][m];

        for (int i = 0; i <= n; i++) {
            e[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            e[u].add(v);
            e[v].add(u);
        }

        dfs(root, 0);

        for (int i = 1; i < m; i++) {
            for (int x = 1; x <= n; x++) {
                f[x][i] = f[f[x][i - 1]][i - 1];
            }
        }
    }

    private void dfs(int x, int fa) {
        f[x][0] = fa;

        for (int y : e[x]) {
            if (y == fa) {
                continue;
            }

            d[y] = d[x] + 1;
            dfs(y, x);
        }
    }

    public int lca(int x, int y) {
        if (d[x] > d[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        for (int i = m - 1; i >= 0; i--) {
            if (d[x] <= d[f[y][i]]) {
                y = f[y][i];
            }
        }

        if (x == y) {
            return x;
        }

        for (int i = m - 1; i >= 0; i--) {
            if (f[y][i] != f[x][i]) {
                x = f[x][i];
                y = f[y][i];
            }
        }

        return f[x][0];
    }

    public int dis(int x, int y) {
        return d[x] + d[y] - d[lca(x, y)] * 2;
    }
}

public class AssigningWeightsLCA {

    private static final int MOD = 1000000007;
    private static final int N = 100010;
    private static final int[] p2 = new int[N];

    static {
        p2[0] = 1;
        for (int i = 1; i < N; i++) {
            p2[i] = (int) (((long) p2[i - 1] * 2) % MOD);
        }
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        LCA lca = new LCA(edges, 1);
        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            if (x != y) {
                res[i] = p2[lca.dis(x, y) - 1];
            }
        }

        return res;
    }

    private void display(int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        AssigningWeightsLCA ob = new AssigningWeightsLCA();

        System.out.println("TEST CASE 1:");
        int[][] edges_1 = {{1, 2}};
        int[][] queries_1 = {{1, 1}, {1, 2}};
        int[] res_1 = ob.assignEdgeWeights(edges_1, queries_1);
        System.out.print("Res: ");
        ob.display(res_1);

        System.out.println("TEST CASE 2:");
        int[][] edges_2 = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        int[][] queries_2 = {{1, 4}, {3, 4}, {2, 5}};
        int[] res_2 = ob.assignEdgeWeights(edges_2, queries_2);
        System.out.print("Res: ");
        ob.display(res_2);
    }
}
