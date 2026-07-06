/**
 * Time: O(nlgn) [sort] + O(n) [interval traversal] = O(nlgn)
 * Space: O(1)
 */
import java.util.Arrays;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0, currMax = 0;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - b[0]);
        // interval[][0] -> starting idx: ascending order
        // interval[][1] -> ending idx: descending order (so that, the interval with max ending interval occurs firts to cover all possible events, which starts with/after the curr. interval and ends before it)

        for (int[] interval : intervals) { // checking current max. ending time which can cover all other intervals
            if (interval[1] > currMax) {
                currMax = interval[1]; // new longest ending time
                res++; // the new max coverage interval cannot be covered by the prev. interval
            }
        }

        return res;
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals ob = new RemoveCoveredIntervals();

        System.out.println("TEST CASE 1:");
        int[][] intervals_1 = {{1,4},{3,6},{2,8}};
        System.out.println("Total intervals = " + ob.removeCoveredIntervals(intervals_1));

        System.out.println("TEST CASE 2:");
        int[][] intervals_2 = {{1,4},{2,3}};
        System.out.println("Total intervals = " + ob.removeCoveredIntervals(intervals_2));
    }
}
