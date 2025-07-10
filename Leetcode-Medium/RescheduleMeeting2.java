/*
 * Greedy Choice --> Find Non-adjacent free slots to reschedule meeting
 * Time = O(N)
 * Space = O(1)
 */
import java.util.*;

public class RescheduleMeeting2 {
    static class Pair {
        int duration, idx;

        Pair(int f, int s) {
            duration = f;
            idx = s;
        }
    }

    private int getFreeTimeByRescheduling(int i, Pair[] top3, int[] startTime, int[] endTime) {
        int lastEnd = (i == 0) ? 0 : endTime[i - 1];
        int eventDuration = endTime[i] - startTime[i];

        for (int j = 0; j < 3; j++) { // O(const.)
            Pair p = top3[j];
            if (p.duration >= eventDuration && p.idx != i && p.idx != i + 1) { // finding compatible non-adjacent max. gap
                return startTime[i + 1] - lastEnd;
            }
        }

        return (startTime[i + 1] - lastEnd) - eventDuration; // adjacent gap
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length + 1;
        int[] newStart = new int[n];
        int[] newEnd = new int[n];

        System.arraycopy(startTime, 0, newStart, 0, startTime.length);
        System.arraycopy(endTime, 0, newEnd, 0, endTime.length);

        newStart[n - 1] = eventTime;
        newEnd[n - 1] = eventTime;

        // Precomputing top 3 gaps
        Pair[] top3 = new Pair[3];
        for (int i = 0; i < 3; i++)
            top3[i] = new Pair(-1, -1);

        top3[0] = new Pair(newStart[0], 0);

        // S1 --> O(N) - Finding top 3 free slots
        for (int i = 1; i < n; i++) {
            int gapVal = newStart[i] - newEnd[i - 1];
            Pair gap = new Pair(gapVal, i);

            if (gap.duration > top3[2].duration)
                top3[2] = gap;
            if (top3[2].duration > top3[1].duration)
                swap(top3, 1, 2);
            if (top3[1].duration > top3[0].duration)
                swap(top3, 0, 1);
        }

        for(int i = 0; i < 3; i++) {
            System.out.println("(" + top3[i].duration + ", " + top3[i].idx + ")");
        }

        int maxFreeTime = 0;
        for (int i = 0; i < n - 1; i++) { // S2 --> O(N) - Greedy Searching non-adjacent gaps for each meeting being rescheduled
            int freeTime = getFreeTimeByRescheduling(i, top3, newStart, newEnd);
            maxFreeTime = Math.max(maxFreeTime, freeTime);
        }

        return maxFreeTime;
    }

    private void swap(Pair[] arr, int i, int j) {
        Pair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        RescheduleMeeting2 ob = new RescheduleMeeting2();
        int eventTime = 30;
        int[] startTime = { 3, 8, 13, 17 };
        int[] endTime = { 5, 9, 15, 23 };

        System.out.println("Max Free Space = " + ob.maxFreeTime(eventTime, startTime, endTime));
    }
}
