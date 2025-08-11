/*
 * LC - 2438
 * Algo: Bit Manipulation
 * Time = O(lgN + QlgN) [Q = length of queries]
 *      = O(QlgN)
 * Space = O(Q + lgN)
 */
import java.util.ArrayList;
import java.util.List;

public class RangeProdQueries {
    private static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> bins = new ArrayList<>();
        int rep = 1;
        while (n > 0) { // O(lgN)
            if (n % 2 == 1) {
                bins.add(rep);
            }
            n /= 2;
            rep *= 2;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long cur = 1;
            int start = queries[i][0];
            int end = queries[i][1];
            for (int j = start; j <= end; j++) { // O(Q)
                cur = (cur * bins.get(j)) % MOD; // O(lgN)
            }
            ans[i] = (int) cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        RangeProdQueries ob = new RangeProdQueries();
        int[][] queries = { { 0, 0 } };
        int n = 2;

        int[] res = new int[queries.length];
        res = ob.productQueries(n, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}