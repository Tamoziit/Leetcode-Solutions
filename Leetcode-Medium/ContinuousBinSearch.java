/**
 * Algo: Binary Search over Continuous Interval (Real nos., not integers)
 * Time = O(nlog(LU)) where U = max(yi + li), L = 10^5 for each element in the array = (xi, yi, li)
 * Space = O(1)
 */
class ContinuousBinSearch {

    public double separateSquares(int[][] squares) {
        double max_y = 0;
        double total_area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            total_area += (double) l * l;
            max_y = Math.max(max_y, (double) (y + l));
        }

        double lo = 0;
        double hi = max_y;
        double eps = 1e-5;
        while (Math.abs(hi - lo) > eps) {
            double mid = (hi + lo) / 2;
            if (check(mid, squares, total_area)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

    private Boolean check(double limit_y, int[][] squares, double total_area) {
        double area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            if (y < limit_y) {
                area += (double) l * Math.min(limit_y - y, (double) l);
            }
        }

        return area >= total_area / 2;
    }

    public static void main(String[] args) {
        ContinuousBinSearch ob = new ContinuousBinSearch();
        int[][] squares = {{0, 0, 2}, {1, 1, 1}};
        double res = ob.separateSquares(squares);
        System.out.println(res);
    }
}
