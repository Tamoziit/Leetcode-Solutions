/**
 * Maths: Transitivity of Heights
 * Time: O(mlg m); m = length of restrictions[n][2]
 * Memory: O(lg m)
 */
import java.util.ArrayList;
import java.util.List;

public class MaxBuildingHeight {

    public int maxBuilding(int n, int[][] restrictions) {
        // Convert the constraints to a list for manipulation
        List<int[]> r = new ArrayList<>();
        for (int[] res : restrictions) {
            r.add(new int[]{res[0], res[1]});
        }

        // Add restriction (1, 0)
        r.add(new int[]{1, 0});
        // Sort by position
        r.sort((a, b) -> Integer.compare(a[0], b[0]));
        // Add restriction (n, n-1)
        if (r.get(r.size() - 1)[0] != n) {
            r.add(new int[]{n, n - 1});
        }

        int m = r.size();

        // Pass restrictions from left to right
        for (int i = 1; i < m; ++i) {
            int dist = r.get(i)[0] - r.get(i - 1)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i - 1)[1] + dist);
        }

        // Pass restrictions from right to left
        for (int i = m - 2; i >= 0; --i) {
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i + 1)[1] + dist);
        }

        int ans = 0;
        for (int i = 0; i < m - 1; ++i) {
            // Calculate the maximum height of the buildings between r[i][0] and r[i][1]
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            int best = (dist + r.get(i)[1] + r.get(i + 1)[1]) / 2;
            ans = Math.max(ans, best);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxBuildingHeight ob = new MaxBuildingHeight();

        System.out.println("TEST CASE 1:");
        int[][] restrictions_1 = {{2, 1}, {4, 1}};
        System.out.println("Max height = " + ob.maxBuilding(5, restrictions_1));

        System.out.println("TEST CASE 2:");
        int[][] restrictions_2 = {};
        System.out.println("Max height = " + ob.maxBuilding(6, restrictions_2));

        System.out.println("TEST CASE 3:");
        int[][] restrictions_3 = {{5, 3}, {2, 5}, {7, 4}, {10, 3}};
        System.out.println("Max height = " + ob.maxBuilding(10, restrictions_3));
    }
}
