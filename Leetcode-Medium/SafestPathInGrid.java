/**
 * Multisource-BFS + Modified non-accumulating Dijkstra's with Max Heap Priority Queue
 * Time: O(N² log N)
 * Space: O(N²)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SafestPathInGrid {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int N = grid.size();

        // Step 1: Multi-source BFS to compute min distance to nearest thief
        int[][] minDist = new int[N][N];
        for (int[] row : minDist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid.get(r).get(c) == 1) { // getting all 1s for multi-source BFS
                    q.offer(new int[]{r, c});
                    minDist[r][c] = 0; // dist = 0, for all 1s
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // allowed directions

        // calculating distances with BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                // neighbours
                int r2 = r + d[0], c2 = c + d[1];

                if (inBounds(r2, c2, N) && minDist[r2][c2] == -1) { // not visited
                    minDist[r2][c2] = minDist[r][c] + 1;
                    q.offer(new int[]{r2, c2}); // adding to queue for next neighbours
                }
            }
        }

        // Step 2: Max-heap Dijkstra-like BFS to maximize the minimum safeness on path
        // heap entries: {safeness, r, c} — max-heap by safeness
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // condition inversion to flip default minHeap to maxHeap
        boolean[][] visited = new boolean[N][N];

        maxHeap.offer(new int[]{minDist[0][0], 0, 0}); // 1st heap entry minDist for coord. (0, 0)
        visited[0][0] = true;

        // tracking min with modified obstacle-avoiding Dijkstra, instead of accumulating path cost
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            int dist = cur[0], r = cur[1], c = cur[2];

            if (r == N - 1 && c == N - 1) {
                return dist; // greedy return
            }

            for (int[] d : dirs) {
                int r2 = r + d[0], c2 = c + d[1];

                if (inBounds(r2, c2, N) && !visited[r2][c2]) {
                    visited[r2][c2] = true;
                    int dist2 = Math.min(dist, minDist[r2][c2]); // tracking min(curr, neighbour)
                    maxHeap.offer(new int[]{dist2, r2, c2}); // adding neighbour to maxHeap
                }
            }
        }

        return 0;
    }

    private boolean inBounds(int r, int c, int N) {
        return r >= 0 && r < N && c >= 0 && c < N;
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
        SafestPathInGrid ob = new SafestPathInGrid();

        int[][][] testGrids = {
            {{1, 0, 0}, {0, 0, 0}, {0, 0, 1}},
            {{0, 0, 1}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}}
        };

        for (int i = 0; i < testGrids.length; i++) {
            List<List<Integer>> grid = toList(testGrids[i]);
            int result = ob.maximumSafenessFactor(grid);
            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }
}
