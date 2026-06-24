/**
 * Dynammic Programming + Matrix exponentiation & Matrix Transition
 * Time: O(m³ log n), where m = r - l + 1 & n = length of array
 * Space: O(m²)
 */
public class ZigZagArrays2 {

    private static final long MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m % (int) MOD;
        }

        int size = 2 * m;

        //  [0, m)  : "next compare DOWN" (up,x  arrived by going up)
        //  [m, 2m) : "next compare UP"   (down,x arrived by going down)
        long[][] T = new long[size][size];

        // up,x (m+x) → pick y > x → land in down,y (y)
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                T[y][m + x] = 1;
            }
        }

        // down,x (x) → pick y < x → land in up,y (m+y)
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                T[m + y][x] = 1;
            }
        }

        // T^(n-1) applied to all-ones = sum all entries of T^(n-1)
        long[][] Tn = matPow(T, n - 1, size);

        long ans = 0;
        for (long[] row : Tn) {
            for (long v : row) {
                ans = (ans + v) % MOD;
            }
        }

        return (int) ans;
    }

    private long[][] matMul(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[][] matPow(long[][] mat, long p, int size) {
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (p > 0) {
            if ((p & 1) == 1) {
                result = matMul(result, mat, size);
            }
            mat = matMul(mat, mat, size);
            p >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagArrays1 ob = new ZigZagArrays1();

        System.out.println("TEST CASE 1:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(3, 4, 5));

        System.out.println("TEST CASE 2:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(3, 1, 3));

        System.out.println("TEST CASE 3:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(100, 1000, 10109));

        System.out.println("TEST CASE 4:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(29, 1, 5));

        System.out.println("TEST CASE 5:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(5890648, 49, 51));

        System.out.println("TEST CASE 6:");
        System.out.println("Valid arrays = " + ob.zigZagArrays(789888, 2, 40));
    }
}
