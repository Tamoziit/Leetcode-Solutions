/**
 * Construction
 * Time: O(mn)
 * Space: O(n) // temp row String for construction of each row
 */
public class GridWithOnePath {

    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        // inverted L movement
        grid[0] = ".".repeat(n); // moving along free cells from (0, n - 1) -> 1st row
        String row = "#".repeat(n - 1) + "."; // moving down along last column n - 1, from row (1, m - 1)

        for (int i = 1; i < m; i++) {
            grid[i] = row;
        }

        return grid;
    }
}
