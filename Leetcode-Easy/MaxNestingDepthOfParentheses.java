/**
 * Stack
 * Time: O(n)
 * Space: O(1)
 */
public class MaxNestingDepthOfParentheses {

    public int maxDepth(String s) {
        int currDepth = 0, max = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currDepth++;
                max = Math.max(max, currDepth);
            } else if (ch == ')') {
                currDepth--;
            }
        }

        return max;
    }
}
