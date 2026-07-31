/**
 * Greedy + Hashing
 * Time: O(nlgn)
 * Space: O(1) [const. 26 alphabets]
 */
import java.util.Arrays;

public class MinPushesToTypeWord2 {

    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Integer[] idx = new Integer[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = i;
        }

        // Greedy choice: most used keys are assigned smaller group
        Arrays.sort(idx, (a, b) -> freq[b] - freq[a]); // descending by frequency

        int totalPushes = 0;
        for (int i = 0; i < 26; i++) {
            int f = freq[idx[i]];
            if (f == 0) {
                break; // no more chars used
            }

            int group = i / 8 + 1; // 1-indexed group/cost
            totalPushes += group * f;
        }

        return totalPushes;
    }
}
