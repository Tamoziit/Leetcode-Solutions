/**
 * Two Pointer
 * Time: O(N) + O(N) = O(N)
 * Space: 3 * O(N) = O(N)
 */
public class LeftRightDifference {

    public int[] leftRightDifference(int[] nums) {
        int n = nums.length, leftPtr = 0, rightPtr = n - 1;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n - 1; i++) {
            leftSum[leftPtr + 1] = leftSum[leftPtr] + nums[leftPtr];
            leftPtr++;

            rightSum[rightPtr - 1] = rightSum[rightPtr] + nums[rightPtr];
            rightPtr--;
        }

        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return res;
    }

    private void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LeftRightDifference ob = new LeftRightDifference();

        System.out.println("\nTEST CASE 1:");
        int[] nums1 = {10, 4, 8, 3};
        System.out.print("Input: ");
        ob.display(nums1);
        int[] res1 = ob.leftRightDifference(nums1);
        System.out.print("Output: ");
        ob.display(res1);

        System.out.println("\nTEST CASE 2:");
        int[] nums2 = {1};
        System.out.print("Input: ");
        ob.display(nums2);
        int[] res2 = ob.leftRightDifference(nums2);
        System.out.print("Output: ");
        ob.display(res2);
    }
}
