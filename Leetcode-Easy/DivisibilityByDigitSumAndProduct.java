/**
 * Simulation
 * Time: O(n)
 * Space: O(1)
 */
public class DivisibilityByDigitSumAndProduct {

    public boolean checkDivisibility(int n) {
        int sum = 0, prod = 1;
        int numCpy = n;

        while (numCpy > 0) {
            int d = numCpy % 10;
            sum += d;
            prod *= d;
            numCpy /= 10;
        }

        return (n % (sum + prod)) == 0;
    }
}
