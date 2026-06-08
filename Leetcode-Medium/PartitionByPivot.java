import java.util.LinkedList;

public class PartitionByPivot {

    /**
     * 2 - Exclusive Lists Approach
     * Time: O(N) + O(k) + O(N - k - pivotCount) + O(pivotCount) = O(N); k = no. of nums[i] < pivot
     * Space: O(k) + O(N - k - pivotCount) = O(N)
     */
    public int[] pivotArray_1(int[] nums, int pivot) {
        LinkedList<Integer> lesser = new LinkedList<>();
        LinkedList<Integer> greater = new LinkedList<>();
        int pivotCount = 0;
        int n = nums.length, x = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                lesser.add(nums[i]);
            } else if (nums[i] > pivot) {
                greater.add(nums[i]);
            } else {
                pivotCount++;
            }
        }

        for (int num : lesser) {
            nums[x++] = num;
        }

        for (int i = 0; i < pivotCount; i++) {
            nums[x++] = pivot;
        }

        for (int num : greater) {
            nums[x++] = num;
        }

        return nums;
    }

    /**
     * 2-Pointer Approach
     * Time: O(N) + O(pivotCount) = O(N)
     * Space: O(N)
     */
    public int[] pivotArray_2(int[] nums, int pivot) {
        int n = nums.length, lesserI = 0, greaterI = n - 1; // 2-pointer
        int[] res = new int[n];

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) { // i -> l-to-r traversal, j -> r-to-l traversal
            if (nums[i] < pivot) {
                res[lesserI] = nums[i];
                lesserI++;
            }

            if (nums[j] > pivot) {
                res[greaterI] = nums[j];
                greaterI--;
            }
        }

        // remaining indices filled with pivot
        while (lesserI <= greaterI) {
            res[lesserI] = pivot;
            lesserI++;
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
        PartitionByPivot ob = new PartitionByPivot();

        System.out.println("TEST CASE 1:");
        int[] nums_1 = {9, 12, 5, 10, 14, 3, 10};
        int pivot_1 = 10;
        System.out.print("Input: ");
        ob.display(nums_1);
        int[] res_1 = ob.pivotArray_1(nums_1, pivot_1);
        System.out.print("M1 - Ouput: ");
        ob.display(res_1);
        res_1 = ob.pivotArray_2(nums_1, pivot_1);
        System.out.print("M2 - Ouput: ");
        ob.display(res_1);

        System.out.println("TEST CASE 2:");
        int[] nums_2 = {-3, 4, 3, 2};
        int pivot_2 = 2;
        System.out.print("Input: ");
        ob.display(nums_2);
        int[] res_2 = ob.pivotArray_1(nums_2, pivot_2);
        System.out.print("M1 - Ouput: ");
        ob.display(res_2);
        res_2 = ob.pivotArray_2(nums_2, pivot_2);
        System.out.print("M2 - Ouput: ");
        ob.display(res_2);
    }
}
