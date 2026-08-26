/**
 * Sliding Window
 * Time: O(n^2)
 * Space: O(n) [for ans & substrings]
 */
public class LexicographicallySmallestBeautifulSubstring {

    public String shortestBeautifulSubstring(String s, int k) {
        int total = 0;

        // base case
        for (int i = 0; i < s.length(); i++) {
            total += s.charAt(i) - '0'; // counting 1s ('1' - '0' = 1)
        }
        if (total < k) {
            return "";
        }

        // sliding window to find smallest s[left:right] such that cnt 1s = k
        String ans = s; // worst case
        int cnt = 0, left = 0;

        // O(n) [sliding window] * O(n) [substring extraction] = O(n^2)
        for (int right = 0; right < s.length(); right++) { // O(n)
            cnt += s.charAt(right) - '0';

            // shrink window till cnt > k, or there are leading 0s left in the substring
            while (cnt > k || s.charAt(left) == '0') {
                cnt -= s.charAt(left) - '0'; // decrease count of 1s
                left++; // shrink window
            }

            if (cnt == k) {
                String t = s.substring(left, right + 1); // O(n)

                // looking for smallest lexicographic substring
                if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
        }

        return ans;
    }
}
