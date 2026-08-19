
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {

    /**
     * Simulation
     * Time: O(n)
     * Space: O(n) [(n + 1) x 11 array]
     */
    public int maxNumberOfFamilies_1(int n, int[][] reservedSeats) {
        int[][] seats = new int[n + 1][11];
        int totalGroups = 0;

        for (int[] reservedSeat : reservedSeats) {
            seats[reservedSeat[0]][reservedSeat[1]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            int f = 0;
            for (int j = 2; j <= 5; j++) {
                if (seats[i][j] == 1) {
                    f = 1;
                    break;
                }
            }
            totalGroups += f == 0 ? 1 : 0;

            if (f == 0) {
                for (int j = 2; j <= 5; j++) {
                    seats[i][j] = 1;
                }
            }

            f = 0;
            for (int j = 4; j <= 7; j++) {
                if (seats[i][j] == 1) {
                    f = 1;
                    break;
                }
            }
            totalGroups += f == 0 ? 1 : 0;

            if (f == 0) {
                for (int j = 4; j <= 7; j++) {
                    seats[i][j] = 1;
                }
            }

            f = 0;
            for (int j = 6; j <= 9; j++) {
                if (seats[i][j] == 1) {
                    f = 1;
                    break;
                }
            }
            totalGroups += f == 0 ? 1 : 0;

            if (f == 0) {
                for (int j = 6; j <= 9; j++) {
                    seats[i][j] = 1;
                }
            }
        }

        return totalGroups;
    }

    /**
     * HashMap + Greedy
     * Time: O(reservedSeats.length)
     * Space: O(reservedSeats.length)
     */
    public int maxNumberOfFamilies_2(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reservedByRow = new HashMap<>();
        for (int rs[] : reservedSeats) {
            reservedByRow.computeIfAbsent(rs[0], k -> new HashSet<>()).add(rs[1]);
        }

        int totalGroups = 0;

        for (Map.Entry<Integer, Set<Integer>> entry : reservedByRow.entrySet()) {
            Set<Integer> row = entry.getValue();
            boolean left = isFree(row, 2, 5);
            boolean middle = isFree(row, 4, 7);
            boolean right = isFree(row, 6, 9);

            // greedy choice
            if (left && right) {
                totalGroups += 2;
            } else if (left || middle || right) {
                totalGroups += 1;
            }
        }

        // rows with no reservations at all: fully free, so 2 families each
        totalGroups += (n - reservedByRow.size()) * 2;

        return totalGroups;
    }

    private boolean isFree(Set<Integer> row, int start, int end) {
        for (int j = start; j <= end; j++) {
            if (row.contains(j)) {
                return false;
            }
        }

        return true;
    }
}
