/**
 * Enumeration
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseDegreeOfString {

    public int reverseDegree(String s) {
        int reverseDegree = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            reverseDegree += ('z' - ch + 1) * (i + 1);
        }

        return reverseDegree;
    }
}
