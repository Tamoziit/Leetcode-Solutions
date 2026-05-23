import java.util.Arrays;

public class IsSortedAndRotated {

    /**
     * Brute Force
     * Time: O(n^2)
     * Space: O(n)
     */
    public boolean check_1(int[] nums) {
        int isSorted, i, x = 0, n = nums.length;

        if (n <= 1) {
            return true;
        }

        while (x < n) {
            isSorted = 1;
            int[] rotated = Arrays.copyOf(nums, nums.length);

            for (i = 0; i < n; i++) {
                rotated[i] = nums[(i + x) % n];
            }

            for (i = 0; i < n - 1; i++) {
                if (rotated[i] > rotated[i + 1]) {
                    isSorted = 0;
                    break;
                }
            }

            if (isSorted == 1) {
                return true;
            }

            x++;
        }

        return false;
    }

    /**
     * Minimum ele. Inversion Count
     * Time: O(n)
     * Space: O(1)
     */
    public boolean check_2(int[] nums) {
        int inversionCounts = 0, n = nums.length, i;

        if (n <= 1) {
            return true;
        }

        // For every pair, counting the number of inversions. (i > i+1 th ele)
        for (i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                inversionCounts++;
            }

            if (inversionCounts > 1) {
                return false;
            }
        }

        // Also checking between the last and the first element due to rotation
        if (nums[0] < nums[n - 1]) {
            inversionCounts++;
        }

        // A valid rotation if inversion count <= 1, i.e, only one inversion allowed --> max ele > min ele. eg: [3,4,5,1,2] --> only 1 valid inversion: 5(max) > 1(min); for all other ele. i > i + 1
        return inversionCounts <= 1;
    }

    public static void main(String[] args) {
        IsSortedAndRotated ob = new IsSortedAndRotated();

        int[] case1 = {3, 4, 5, 1, 2};
        int[] case2 = {2, 1, 3, 4};
        int[] case3 = {1, 2, 3};

        System.out.println("__TEST 1__");
        System.out.println("M1: " + ob.check_1(case1));
        System.out.println("M2: " + ob.check_2(case1));

        System.out.println("\n__TEST 2__");
        System.out.println("M1: " + ob.check_1(case2));
        System.out.println("M2: " + ob.check_2(case2));

        System.out.println("\n__TEST 3__");
        System.out.println("M1: " + ob.check_1(case3));
        System.out.println("M2: " + ob.check_2(case3));
    }
}
