/**
 * 2-Arrays
 * Time: O(m.n)
 * Space: O(m + n)
 */
public class CountCommunicableServers {

    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[] colCounts = new int[grid[0].length]; // per-column totals
        int[] rowCounts = new int[grid.length]; // per-row totals

        // Count servers in each row and each column
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rowCounts[row]++;
                    colCounts[col]++;
                }
            }
        }

        int communicableServersCount = 0;

        // Count servers that can communicate (in the same row or column)
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    if (rowCounts[row] > 1 || colCounts[col] > 1) {
                        communicableServersCount++;
                    }
                }
            }
        }

        return communicableServersCount;
    }
}
