/**
 * Enumeration
 * Time: O(10lgn)
 * Space: O(1)
 */
public class SmallestDivisibleDigitProd1 {

    public int smallestNumber(int n, int t) {
        while (true) {
            int prod = getProduct(n);
            if (prod % t == 0) {
                return n;
            }
            n++;
        }
    }

    private int getProduct(int n) {
        int prod = 1;

        while (n > 0) {
            int d = n % 10;
            prod *= d;
            n = n / 10;

            if (prod == 0) {
                break;
            }
        }

        return prod;
    }
}
