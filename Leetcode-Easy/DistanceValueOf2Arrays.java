/**
 * Binary Search + Sorting
 * Time: O((n+m)log m)
 * Space: O(log m)
 * where, n = len(arr1), m = len(arr2)
 */
import java.util.Arrays;

public class DistanceValueOf2Arrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int cnt = 0;
        for (int x : arr1) {
            int p = binarySearch(arr2, x);
            boolean ok = true;

            if (p < arr2.length) {
                ok &= arr2[p] - x > d;
            }

            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= x - arr2[p - 1] > d;
            }

            cnt += ok ? 1 : 0;
        }

        return cnt;
    }

    private int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        if (arr[high] < target) {
            return high + 1;
        }

        while (low < high) {
            int mid = (high - low) / 2 + low;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
