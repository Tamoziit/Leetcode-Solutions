import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RotateFunction {
    /**
     * Time: O(n ^ 2)
     * Space: O(1)
     */
    public int maxRotateFunction1(int[] nums) {
        int l = nums.length;
        int max = Integer.MIN_VALUE;

        for (int k = 0; k < l; k++) {
            int fn = 0;

            for (int i = 0; i < l; i++) {
                fn += nums[(i + k) % l] * i;
            }

            if (fn > max)
                max = fn;
        }

        return max;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int maxRotateFunction2(int[] nums) {
        int n = nums.length;
        int sum = 0, Fn = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            Fn += i * nums[i];
        }
        int max = Fn;

        for (int k = 1; k < n; k++) {
            Fn = Fn + sum - n * nums[n - k];
            max = Math.max(max, Fn);
        }

        return max;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public int[] readTestCase() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("../testCases/LC3742.txt"));
        String line = br.readLine();
        br.close();

        String[] parts = line.trim().split("\\s+");

        int n = parts.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        return nums;
    }

    public static void main(String[] args) throws IOException {
        RotateFunction ob = new RotateFunction();

        int[] nums = { 4, 3, 2, 6 };
        int[] nums_TLE = ob.readTestCase();
        int max;

        max = ob.maxRotateFunction1(nums);
        System.out.println("Method 1: " + max);

        max = ob.maxRotateFunction2(nums);
        System.out.println("Method 2: " + max);

        max = ob.maxRotateFunction1(nums_TLE);
        System.out.println("Method 1 for TLE test case: " + max);

        max = ob.maxRotateFunction2(nums_TLE);
        System.out.println("Method 2 for TLE test case: " + max);
    }
}
