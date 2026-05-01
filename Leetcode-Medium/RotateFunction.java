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

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 6 };
        int max;

        RotateFunction ob = new RotateFunction();

        max = ob.maxRotateFunction1(nums);
        System.out.println("Method 1: " + max);

        max = ob.maxRotateFunction2(nums);
        System.out.println("Method 2: " + max);
    }
}
