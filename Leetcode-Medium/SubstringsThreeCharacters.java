
public class SubstringsThreeCharacters {

    /**
     * Brute Force (TLE)
     * Time: O(n³)
     * Space: O(n), each substring/temporary string allocation is up to O(n)
     */
    public int numberOfSubstrings_1(String s) {
        int count = 0, n = s.length(), x;

        for (int i = 0; i <= n - 3; i++) { // O(n)
            x = 3;

            while (x <= n - i) { // O(n - i)
                String w = s.substring(i, i + x); // O(x)

                if (w.contains("a") && w.contains("b") && w.contains("c")) { // O(x)
                    count += n - (i + x) + 1;
                    break;
                }

                x++;
            }
        }

        return count;
    }

    /**
     * Sliding Window + Last Seen Tracking
     * Time: O(n)
     * Space: O(1) [const 3-idx array]
     */
    public int numberOfSubstrings_2(String s) {
        int count = 0, n = s.length();
        int[] lastSeen = {-1, -1, -1}; // last seen index of 'a','b','c'

        for (int j = 0; j < n; j++) {
            lastSeen[s.charAt(j) - 'a'] = j;

            // Intuition (general form):
            // For the current right boundary j, let lastA, lastB, lastC be the
            // most recent indices at which 'a', 'b', 'c' were each seen (in s[0..j]).
            // Any window [i, j] with i <= min(lastA, lastB, lastC) is guaranteed to
            // still contain all three characters, since none of their last
            // occurrences get excluded until i moves past them.
            // So the number of valid starting points i (ranging from 0 up to
            // min(lastA, lastB, lastC) inclusive) is: min(lastA, lastB, lastC) + 1.
            // This is exactly the count of valid substrings ending at j.
            int lastMin = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            if (lastMin != -1) {
                count += lastMin + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        SubstringsThreeCharacters ob = new SubstringsThreeCharacters();

        System.out.println("TEST CASE 1:");
        System.out.println("M1: Total Substrings = " + ob.numberOfSubstrings_1("abcabc"));
        System.out.println("M2: Total Substrings = " + ob.numberOfSubstrings_2("abcabc"));

        System.out.println("TEST CASE 2:");
        System.out.println("M1: Total Substrings = " + ob.numberOfSubstrings_1("aaacb"));
        System.out.println("M2: Total Substrings = " + ob.numberOfSubstrings_2("aaacb"));

        System.out.println("TEST CASE 3:");
        System.out.println("M1: Total Substrings = " + ob.numberOfSubstrings_1("abc"));
        System.out.println("M2: Total Substrings = " + ob.numberOfSubstrings_2("abc"));
    }
}
