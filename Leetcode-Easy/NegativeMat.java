/**
 * Time: O(n + m)
 * Mem: O(1)
 */
class NegativeMat {

    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int r = 0, c = cols - 1;
        int count = 0;

        while (r < rows && c >= 0) {
            if (grid[r][c] < 0) {
                count += (rows - r); // cumulative count
                c--; // moving left
            } else {
                r++; // moving down
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NegativeMat ob = new NegativeMat();

        int[][] mat = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };

        System.out.println(ob.countNegatives(mat)); // 8
    }
}
