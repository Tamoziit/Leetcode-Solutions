/**
 * Time: O(N)
 * Space: O(1)
 */
public class ConcatenatingNonZero1 {

    public long sumAndMultiply(int n) {
        long x = 0, sum = 0;
        long place = 1;

        while (n > 0) {
            int d = n % 10;

            if (d != 0) {
                x += (long) d * place;
                place *= 10;
                sum += d;
            }

            n /= 10;
        }

        return x * sum;
    }

    public static void main(String[] args) {
        ConcatenatingNonZero1 ob = new ConcatenatingNonZero1();

        System.out.println("TEST CASE 1:");
        int n1 = 10203004;
        System.out.println("Input = " + n1 + ", Output = " + ob.sumAndMultiply(n1));

        System.out.println("TEST CASE 2:");
        int n2 = 100;
        System.out.println("Input = " + n2 + ", Output = " + ob.sumAndMultiply(n2));
    }
}
