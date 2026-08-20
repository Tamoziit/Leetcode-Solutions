
import java.util.ArrayList;
import java.util.List;

public class DistributeElesInArray1 {

    /**
     * Two List Simulation
     * Time: O(n)
     * Space: O(n)
     */
    public int[] resultArray_1(int[] nums) {
        int n = nums.length, x = 0;
        int[] res = new int[n];

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < n; i++) {
            int last1 = arr1.get(arr1.size() - 1);
            int last2 = arr2.get(arr2.size() - 1);

            if (last1 > last2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        for (int ele : arr1) {
            res[x++] = ele;
        }

        for (int ele : arr2) {
            res[x++] = ele;
        }

        return res;
    }

    /**
     * Two Pointer
     * Time: O(n)
     * Space: O(1)
     */
    public int[] resultArray_2(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        // arr1 is at arr[0...idx]
        // arr2 is at arr[revIdx...n-1]
        arr[0] = nums[0];
        arr[n - 1] = nums[1];
        int idx = 0, revIdx = n - 1;

        for (int i = 2; i < n; i++) {
            if (arr[idx] > arr[revIdx]) {
                arr[++idx] = nums[i]; // storing arr1 left to right (0 -> idx)
            } else {
                arr[--revIdx] = nums[i]; // storing arr2 right to left (n-1 -> revIdx)
            }
        }

        // reversing arr[n-1...revIdx] -> correct arr[revIdx...n-1]
        for (int l = revIdx, r = n - 1; l < r; l++, r--) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }

        return arr;
    }
}
