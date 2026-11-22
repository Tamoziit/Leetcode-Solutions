/**
 * Strings
 * Time: O(n)
 * Space: O(1)
 */
public class AllAbeforeB {
    public boolean checkString(String s) {
        boolean isBSeen = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' && !isBSeen) {
                isBSeen = true;
            }

            if (s.charAt(i) == 'a' && isBSeen) {
                return false;
            }
        }

        return true;
    }
}
