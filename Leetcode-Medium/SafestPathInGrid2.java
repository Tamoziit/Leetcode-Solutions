/**
 * 0-1 BFS with Deque optimization
 * Time: O(m x n)
 * Space: O(m x n)
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SafestPathInGrid2 {

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] minCost = new int[m][n]; // visited array replaced with cost as we need min cost at (m-1, n-1)

        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>(); // to optimize minimal health with: 0 -> processed first to optimize cost (inserted at head), 1 -> processed last to not decrease health of path (inserted at end)
        minCost[0][0] = grid.get(0).get(0); // src init.
        deque.offerFirst(new int[]{0, 0});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // allowed directions

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1) {
                return minCost[r][c] < health; // greedy return
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (inBounds(nr, nc, m, n)) {
                    int cost = grid.get(nr).get(nc); // cost of neighbour cell

                    // greedy choice: minimizing path cost
                    if (minCost[r][c] + cost < minCost[nr][nc]) {
                        minCost[nr][nc] = minCost[r][c] + cost;

                        if (cost == 0) {
                            deque.offerFirst(new int[]{nr, nc});
                        } else {
                            deque.offerLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return minCost[m - 1][n - 1] < health;
    }

    private boolean inBounds(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    private static List<List<Integer>> toList(int[][] arr) {
        List<List<Integer>> grid = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> r = new ArrayList<>();
            for (int val : row) {
                r.add(val);
            }
            grid.add(r);
        }
        return grid;
    }

    public static void main(String[] args) {
        SafestPathInGrid2 ob = new SafestPathInGrid2();

        int[][][] testGrids = {
            {{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}},
            {{0, 1, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 0}, {0, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 1, 0}},
            {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}
        };
        int[] healths = {1, 3, 5};

        for (int i = 0; i < testGrids.length; i++) {
            List<List<Integer>> grid = toList(testGrids[i]);
            int health = healths[i];
            boolean result = ob.findSafeWalk(grid, health);
            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }
}
