/**
 * Brute Force
 * Time: O(num2 * log num2)
 *      Worst cast traversal in range [num1, num2] = num2 => O(num2)
 *      Calculating fluctuation value(waviness) for each no. takes O(log num2) in worst case [here, log base 10]
 *      So, Total = O(num2) * O(log num2) = O(num2 * log num2)
 * Space = O(log num2) --> The string representation of a number contains O(log num2) digits
 */
public class Waviness {

    private int getWaviness(int x) {
        String num = Integer.toString(x);
        int waviness = 0;

        for (int i = 1; i < num.length() - 1; i++) {
            boolean isPeak = num.charAt(i) > num.charAt(i - 1) && num.charAt(i) > num.charAt(i + 1);
            boolean isValley = num.charAt(i) < num.charAt(i - 1) && num.charAt(i) < num.charAt(i + 1);

            if (isPeak || isValley) {
                waviness++;
            }
        }

        return waviness;
    }

    public int totalWaviness(int num1, int num2) {
        int start, i, waviness = 0;

        if (num1 <= 100) {
            start = 101;
        } else {
            start = num1;
        }

        for (i = start; i <= num2; i++) {
            waviness += getWaviness(i);
        }

        return waviness;
    }

    public static void main(String[] args) {
        Waviness ob = new Waviness();
        int num1, num2;

        num1 = 120;
        num2 = 130;
        System.out.println("Test 1:");
        System.out.println("num1 = " + num1 + " num2 = " + num2);
        System.out.println("Waviness = " + ob.totalWaviness(num1, num2) + "\n");

        num1 = 198;
        num2 = 202;
        System.out.println("Test 2:");
        System.out.println("num1 = " + num1 + " num2 = " + num2);
        System.out.println("Waviness = " + ob.totalWaviness(num1, num2) + "\n");

        num1 = 4012;
        num2 = 65123;
        System.out.println("Test 3:");
        System.out.println("num1 = " + num1 + " num2 = " + num2);
        System.out.println("Waviness = " + ob.totalWaviness(num1, num2) + "\n");

        num1 = 4848;
        num2 = 4848;
        System.out.println("Test 4:");
        System.out.println("num1 = " + num1 + " num2 = " + num2);
        System.out.println("Waviness = " + ob.totalWaviness(num1, num2) + "\n");

        num1 = 20;
        num2 = 100;
        System.out.println("Test 5:");
        System.out.println("num1 = " + num1 + " num2 = " + num2);
        System.out.println("Waviness = " + ob.totalWaviness(num1, num2) + "\n");
    }
}
