import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] result = new int[n][2];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sorting according to lower bound - O(nlgn)

        // Merging --> O(n) --> each interval visited exactly once [since intervals are
        // sorted]
        int k = 0, currIdx = 0, i;
        while (currIdx < n) {
            for (i = currIdx + 1; i < n; i++) {
                if (intervals[i][0] <= intervals[currIdx][1]) {
                    if (intervals[i][1] > intervals[currIdx][1]) {
                        intervals[currIdx][1] = intervals[i][1];
                    }
                } else {
                    break;
                }
            }

            result[k][0] = intervals[currIdx][0];
            result[k][1] = intervals[currIdx][1];
            k++;
            currIdx = i;
        }

        return Arrays.copyOfRange(result, 0, k);
    }

    private void display(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;
        int i, j;

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(intervals[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        MergeIntervals ob = new MergeIntervals();

        System.out.println("TEST CASE 1\n---------------");
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println("Original intervals:");
        ob.display(intervals1);
        System.out.println("Updated intervals:");
        intervals1 = ob.merge(intervals1);
        ob.display(intervals1);

        System.out.println("TEST CASE 2\n---------------");
        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        System.out.println("Original intervals:");
        ob.display(intervals2);
        System.out.println("Updated intervals:");
        intervals2 = ob.merge(intervals2);
        ob.display(intervals2);

        System.out.println("TEST CASE 3\n---------------");
        int[][] intervals3 = { { 4, 7 }, { 1, 4 } };
        System.out.println("Original intervals:");
        ob.display(intervals3);
        System.out.println("Updated intervals:");
        intervals3 = ob.merge(intervals3);
        ob.display(intervals3);
    }
}
