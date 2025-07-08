/*
 * Time --> O(NlgN + maxDay)
 * Space --> O(N)
 * Algo: Greedy + Priority Queue(Min-Heap)
 */
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {
    public int maxEvents(int[][] events) {
        // Sorting by start day
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to track event end days
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0, n = events.length, day = 1, attended = 0;
        int maxDay = 0;
        for (int[] e : events) { // Finding the maximum day we may need to consider
            maxDay = Math.max(maxDay, e[1]);
        }

        while (day <= maxDay) {
            // Adding all events to minHeap, that start today
            while (i < n && events[i][0] == day) {
                minHeap.add(events[i][1]);
                i++;
            }

            // Removing expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attending the event with the earliest end day (maintained by minHeap)
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }

            day++;
        }

        return attended;
    }

    public static void main(String[] args) {
        MaxEvents ob = new MaxEvents();
        int[][] events = {
                { 1, 4 },
                { 4, 4 },
                { 2, 2 },
                { 3, 4 },
                { 1, 1 }
        };

        System.out.println("Max Events = " + ob.maxEvents(events));
    }
}
