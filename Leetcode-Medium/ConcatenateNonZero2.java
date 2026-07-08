
import java.util.Arrays;

public class ConcatenateNonZero2 {

    /**
     * Brute Force (gives TLE)
     * Time: O(n × q); n = length of string, q = no. of queries
     * Space: O(k) extra space per query for the substring copy
     */
    public int[] sumAndMultiply1(String s, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String str = s.substring(queries[i][0], queries[i][1] + 1);
            int num = getNum(str);
            res[i] = num;
        }

        return res;
    }

    private int getNum(String str) {
        final int MOD = 1_000_000_007;
        long x = 0, sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != '0') {
                int d = Character.getNumericValue(ch);
                x = (x * 10 + d) % MOD; // keeping x bounded every step
                sum += d;
            }
        }

        return (int) ((x * sum) % MOD);
    }

    /**
     * Prefix Sum
     * Time: O(n + q) + O(MAX_N) [precomputing pow10[] in a static block - amortized to zero per call]
     * Space: O(n) for sum[], x[], cnt[] arrays, + O(MAX_N) static for pow10[]
     */
    private static final int MOD = 1000000007;
    private static final int MAX_N = 100001;
    private static final long[] pow10 = new long[MAX_N];

    // static runs only once for all test cases
    static {
        pow10[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply2(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        long[] x = new long[n + 1];
        int[] cnt = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            int d = s.charAt(i) - '0';
            sum[i + 1] = sum[i] + d;
            x[i + 1] = d > 0 ? (x[i] * 10 + d) % MOD : x[i];
            cnt[i + 1] = cnt[i] + (d > 0 ? 1 : 0);
        }

        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; ++i) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int length = cnt[r] - cnt[l];
            long val_x = (x[r] - ((x[l] * pow10[length]) % MOD) + MOD) % MOD;
            long val_sum = sum[r] - sum[l];

            res[i] = (int) ((val_x * val_sum) % MOD);
        }

        return res;
    }

    public static void main(String[] args) {
        ConcatenateNonZero2 ob = new ConcatenateNonZero2();

        System.out.println("TEST CASE 1:");
        String s1 = "10203004";
        int[][] queries1 = {{0, 7}, {1, 3}, {4, 6}};
        int[] res_11 = ob.sumAndMultiply1(s1, queries1);
        System.out.println("M1: " + Arrays.toString(res_11));
        int[] res_12 = ob.sumAndMultiply2(s1, queries1);
        System.out.println("M2: " + Arrays.toString(res_12));

        System.out.println("TEST CASE 2:");
        String s2 = "1000";
        int[][] queries2 = {{0, 3}, {1, 1}};
        int[] res_21 = ob.sumAndMultiply1(s2, queries2);
        System.out.println("M1: " + Arrays.toString(res_21));
        int[] res_22 = ob.sumAndMultiply2(s2, queries2);
        System.out.println("M2: " + Arrays.toString(res_22));

        System.out.println("TEST CASE 3:");
        String s3 = "9876543210";
        int[][] queries3 = {{0, 9}};
        int[] res_31 = ob.sumAndMultiply1(s3, queries3);
        System.out.println("M1: " + Arrays.toString(res_31));
        int[] res_32 = ob.sumAndMultiply2(s3, queries3);
        System.out.println("M2: " + Arrays.toString(res_32));
    }
}
