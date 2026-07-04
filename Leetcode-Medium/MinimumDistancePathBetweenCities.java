/**
 * Disjoint Set Union - DSU (Union Find)
 * Time: O((n+m)×α(n))
 * Space: O(n)
 * Where,
 * n — number of cities (nodes in the graph).
 * m — number of roads (edges in the graph).
 * α(n) — the inverse Ackermann function of n. It comes from the DSU implementation with path compression + union by rank. It grows so slowly (practically ≤ 4 for any realistic input size) that it's treated as a constant.
 */
public class MinimumDistancePathBetweenCities {

    int find(int[] root, int i) {
        if (root[i] == i) {
            return i;
        }
        return root[i] = find(root, root[i]);
    }

    public int minScore(int n, int[][] roads) {
        int[] root = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }

        for (int[] r : roads) {
            root[find(root, r[0])] = find(root, r[1]);
        }

        int res = 10001;
        for (int[] r : roads) {
            if (find(root, r[0]) == find(root, 1)) {
                res = Math.min(res, r[2]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumDistancePathBetweenCities ob = new MinimumDistancePathBetweenCities();

        System.out.println("TEST CASE 1:");
        int[][] roads_1 = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        System.out.println("Min. path = " + ob.minScore(4, roads_1));

        System.out.println("TEST CASE 2:");
        int[][] roads_2 = {{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        System.out.println("Min. path = " + ob.minScore(4, roads_2));
    }
}
