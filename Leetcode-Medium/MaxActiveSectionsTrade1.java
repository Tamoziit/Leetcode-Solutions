/**
 * Enumeration
 * Time: O(N)
 * Space: O(N) [augment space copy]
 */
public class MaxActiveSectionsTrade1 {

    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++; // counting initial ones
            }
        }

        int activeSessions = ones; // eventually activeSessions = initial 1s + max gain

        s = "1" + s + "1"; // augment step
        int n = s.length(), i = 0;

        // skipping initial 1s
        while (i < n && s.charAt(i) == '1') {
            i++;
        }

        // counting 1st block of left 0s
        int left = 0;
        while (i < n && s.charAt(i) == '0') {
            left++;
            i++;
        }

        // evaluating 0-1-0 pattern trades
        while (i < n) {
            // counting middle 1s
            int middle = 0;
            while (i < n && s.charAt(i) == '1') {
                middle++;
                i++;
            }

            if (middle == 0) {
                break; // no 1s-block in the string
            }
            // counting right 0s
            int right = 0;
            while (i < n && s.charAt(i) == '0') {
                right++;
                i++;
            }

            if (right == 0) {
                break; // no right 0s-block in the string
            }
            activeSessions = Math.max(activeSessions, ones + left + right); // maximizing gain

            // sliding left to the curr right to make it the left 0s block of next 0-1-0 pattern block
            left = right;
        }

        return activeSessions;
    }
}
