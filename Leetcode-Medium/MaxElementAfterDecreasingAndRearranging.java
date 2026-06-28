import java.util.Arrays;

public class MaxElementAfterDecreasingAndRearranging {

    /**
     * Greedy
     * Time: O(n⋅logn)
     * Space: O(logn) [For Quick Sort]
     */
    public int maximumElementAfterDecrementingAndRearranging_1(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= ans + 1) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * Capped Frequency Map
     * Time: O(n)
     * Space: O(n)
     */
    public int maximumElementAfterDecrementingAndRearranging_2(int[] arr) {
        int n = arr.length, result = 0;
        int[] freq = new int[n + 1];

        for (int x : arr) {
            freq[Math.min(x, n)]++; // cap at n; (since according to the conditions, the max achievable element = n)
        }

        for (int i = 1; i <= n; i++) {
            // result = no. of positions in [1..i] we can fill
            // Adding freq[i] new elements, but can't exceed i total
            result = Math.min(result + freq[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxElementAfterDecreasingAndRearranging ob = new MaxElementAfterDecreasingAndRearranging();

        System.out.println("TEST CASE 1:");
        int[] num_1 = {2, 2, 1, 2, 1};
        System.out.println("M1: Max ele = " + ob.maximumElementAfterDecrementingAndRearranging_1(num_1));
        System.out.println("M2: Max ele = " + ob.maximumElementAfterDecrementingAndRearranging_2(num_1));

        System.out.println("TEST CASE 2:");
        int[] num_2 = {100, 1, 1000};
        System.out.println("M1: Max ele = " + ob.maximumElementAfterDecrementingAndRearranging_1(num_2));
        System.out.println("M2: Max ele = " + ob.maximumElementAfterDecrementingAndRearranging_2(num_2));

        System.out.println("TEST CASE 3:");
        int[] num_3 = {1, 2, 3, 4, 5};
        System.out.println("M1: Max ele = " + ob.maximumElementAfterDecrementingAndRearranging_1(num_3));
        System.out.println("M2: Max ele = " + ob.maximumElementAfterDecrementingAndRearranging_2(num_3));
    }
}
