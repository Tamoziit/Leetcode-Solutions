
public class EarliestFinishTime {

    /**
     * BRUTE FORCE
     * Time: O(n * m)
     * Space: O(1)
     */
    public int earliestFinishTime_1(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int i, j;
        int min = Integer.MAX_VALUE;
        int n = landStartTime.length, m = waterStartTime.length;

        for (i = 0; i < n; i++) {
            int landStartCase = 0, waterStartCase = 0;
            for (j = 0; j < m; j++) {
                landStartCase = landStartTime[i] + landDuration[i];
                if (landStartCase >= waterStartTime[j]) {
                    waterStartCase = landStartCase + waterDuration[j];
                } else {
                    waterStartCase = waterStartTime[j] + waterDuration[j];
                }
                min = Math.min(min, waterStartCase);
                waterStartCase = waterStartTime[j] + waterDuration[j];
                if (waterStartCase >= landStartTime[i]) {
                    landStartCase = waterStartCase + landDuration[i];
                } else {
                    landStartCase = landStartTime[i] + landDuration[i];
                }
                min = Math.min(min, landStartCase);
            }
        }
        return min;
    }


    /**
     * GREEDY APPROACH
     * Computes the minimum completion time when all activities of type1 must be
     * performed before an activity of type2.
     *
     * Observation: For any chosen first activity:
     *
     * finish1 = start1[i] + duration1[i]
     *
     * If we then choose activity j from type2, its start time will be:
     *
     * actualStart2 = max(start2[j], finish1)
     *
     * because: - If activity2 is already available when activity1 finishes, we
     * can start immediately at finish1. - Otherwise, we must wait until
     * activity2 opens at start2[j].
     *
     * Therefore the final completion time becomes:
     *
     * finish = max(start2[j], finish1) + duration2[j]
     *
     * Notice that:
     *
     * f(finish1) = max(start2[j], finish1) + duration2[j]
     *
     * is a non-decreasing function of finish1.
     *
     * Hence, among all possible choices for the first activity, only the
     * EARLIEST finishing activity matters.
     *
     * Let:
     *
     * earliestFinish1 = min(start1[i] + duration1[i])
     *
     * Then the optimal answer for the ordering:
     *
     * type1 -> type2
     *
     * can be found by simply trying every type2 activity using earliestFinish1
     * as the completion time of the first activity.
     *
     * Time : O(n + m)
     * Space : O(1)
     */
    private int solve(
            int[] start1,
            int[] duration1,
            int[] start2,
            int[] duration2) {
        // Earliest possible completion time among all activities
        // chosen as the FIRST activity.
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]); // minimizing 1st event finish time
        }

        // Try every activity as the SECOND activity and compute:
        //
        //      max(start2[i], finish1) + duration2[i]
        //
        // Keep the minimum overall completion time.
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(finish2, Math.max(start2[i], finish1) + duration2[i]);
        }

        return finish2;
    }

    public int earliestFinishTime_2(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Land -> Water
        int land_water = solve(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);

        // Water -> Land
        int water_land = solve(
                waterStartTime,
                waterDuration,
                landStartTime,
                landDuration);

        return Math.min(land_water, water_land);
    }

    public static void main(String[] args) {
        EarliestFinishTime ob = new EarliestFinishTime();

        System.out.println("CASE 1:");
        int[] landStartTime_1 = {2, 8};
        int[] landDuration_1 = {4, 1};
        int[] waterStartTime_1 = {6};
        int[] waterDuration_1 = {3};
        System.out.println("M1: Earliest Finish Time = " + ob.earliestFinishTime_1(landStartTime_1, landDuration_1, waterStartTime_1, waterDuration_1));
        System.out.println("M2: Earliest Finish Time = " + ob.earliestFinishTime_2(landStartTime_1, landDuration_1, waterStartTime_1, waterDuration_1));

        System.out.println("CASE 2:");
        int[] landStartTime_2 = {5};
        int[] landDuration_2 = {3};
        int[] waterStartTime_2 = {1};
        int[] waterDuration_2 = {10};
        System.out.println("M1: Earliest Finish Time = " + ob.earliestFinishTime_1(landStartTime_2, landDuration_2, waterStartTime_2, waterDuration_2));
        System.out.println("M2: Earliest Finish Time = " + ob.earliestFinishTime_2(landStartTime_2, landDuration_2, waterStartTime_2, waterDuration_2));
    }
}
