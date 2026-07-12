
import java.util.Arrays;
import java.util.HashMap;

public class RankTransformationOfArray {
    /**
     * Sorting + Binary Search
     * Time: O(NlgN)
     * Space: O(N + lgN) [lg N = auxiliary space for sorting]
     */
    public int[] arrayRankTransform1(int[] arr) {
        int[] cpy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cpy);

        int[] distinct = Arrays.stream(cpy)
                .distinct()
                .toArray(); // deduping for rank

        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRank(distinct, arr[i]);
        }

        return arr;
    }

    private int getRank(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid + 1; // rank = idx + 1
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Sorting + Hash Map
     * Time: O(NlgN)
     * Space: O(N + lgN) [lg N = auxiliary space for sorting]
     */
    public int[] arrayRankTransform2(int[] arr) {
        // Store the rank for each number in arr
        HashMap<Integer, Integer> numToRank = new HashMap<>();
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int rank = 1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (i > 0 && sortedArr[i] > sortedArr[i - 1]) {
                rank++;
            }

            numToRank.put(sortedArr[i], rank);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = numToRank.get(arr[i]);
        }

        return arr;
    }
}
