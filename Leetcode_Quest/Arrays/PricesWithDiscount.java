import java.util.Stack;

class PricesWithDiscount {

    /**
     * Brute Force
     * Time(Avg): O(N^2)
     * Space: O(N)
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length, x = 0, i, j, f;
        int[] finalAmt = new int[n];

        for (i = 0; i < n - 1; i++) {
            f = 0;
            for (j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    f = 1;
                    finalAmt[x++] = prices[i] - prices[j];
                    break;
                }
            }

            if (f == 0) {
                finalAmt[x++] = prices[i];
            }
        }
        finalAmt[x] = prices[n - 1]; // default

        return finalAmt;
    }

    /**
     * Monotonic Stack
     * Time: O(N)
     * Space: O(N)
     */
    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            ans[i] = prices[i]; // default (no discount)

            // Next Smaller or Equal Element to the Right Problem
            while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                int idx = st.pop();
                ans[idx] = prices[idx] - prices[i];
            }

            st.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        PricesWithDiscount ob = new PricesWithDiscount();
        int[] prices = {8, 4, 6, 2, 3};

        int[] res1 = ob.finalPrices(prices);
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i] + " ");
        }
        System.out.println();

        int[] res2 = ob.finalPrices2(prices);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + " ");
        }
        System.out.println();
    }
}
