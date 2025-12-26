import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinPenalty {

    // Time: O(N^2), Mem: O(Min Timestamps) --> Gives TLE
    public int bestClosingTime1(String customers) {
        int min = Integer.MAX_VALUE, idx, sum;
        List<Integer> ts = new ArrayList<>();

        for (int i = 0; i <= customers.length(); i++) {
            idx = i;
            sum = 0;
            for (int j = 0; j < customers.length(); j++) {
                if (j < idx) {
                    if (customers.charAt(j) == 'Y') {
                        sum += 0;
                    } else {
                        sum += 1;
                    }
                } else {
                    if (customers.charAt(j) == 'Y') {
                        sum += 1;
                    } else {
                        sum += 0;
                    }
                }
            }

            if (sum < min) {
                min = sum;
                ts.clear(); // new smaller min → reset
                ts.add(idx);
            } else if (sum == min) {
                ts.add(idx); // same min → keeping both
            }
        }

        for (int i = 0; i < ts.size(); i++) {
            System.out.print(ts.get(i) + " ");
        }
        System.out.println();

        return Collections.min(ts);
    }

    // Time: O(N), Mem: O(1) --> Optimizing by max score instead of min. penalty
    public int bestClosingTime2(String customers) {
        int max_score = 0, score = 0, best_hour = -1;
        for (int i = 0; i < customers.length(); i++) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if (score > max_score) {
                max_score = score;
                best_hour = i;
            }
        }
        return best_hour + 1;
    }

    public static void main(String[] args) {
        MinPenalty ob = new MinPenalty();

        String customers = "YYNY";
        int min = ob.bestClosingTime1(customers);
        System.out.println("O(N^2) approach: " + min);

        min = ob.bestClosingTime2(customers);
        System.out.println("O(N) - One-pass approach: " + min);
    }
}
