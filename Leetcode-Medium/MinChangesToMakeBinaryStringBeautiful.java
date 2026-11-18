/**
 * Greedy (local optimum is trivially the global optimum here)
 * Time: O(n)
 * Space: O(1)
 */
public class MinChangesToMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        int totalChanges = 0;

        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                totalChanges++;
            }
        }

        return totalChanges;
    }
}
