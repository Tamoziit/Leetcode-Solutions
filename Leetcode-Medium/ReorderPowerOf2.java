/*
 * LC - 869
 * Algo: Bit Manipulation, Math
 * Time = O(D) [D = no. of Digits]
 * Space = O(1)
 */
public class ReorderPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        int target = counter(n);

        for (int i = 0; i < 31; i++) { // O(1)
            if (counter(1 << i) == target)
                return true;
        }
        return false;
    }

    private int counter(int n) {
        int count = 0;

        while (n > 0) {
            count += Math.pow(10, n % 10); // O(D) [D = no. of digits]
            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        ReorderPowerOf2 ob = new ReorderPowerOf2();
        int[] testValues = { 1, 10, 16, 24, 46, 128, 812, 218, 4201, 125, 521, 31 };

        for (int val : testValues) {
            System.out.println(val + " → " + ob.reorderedPowerOf2(val));
        }
    }
}
