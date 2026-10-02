/**
 * DFS + Recursive Backtracking
 * Time: O(4^n/(root(n)))
 * Space: O(n.4^n/(root(n)))
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n-- == 1) {
            return List.of("()");
        }

        dfs(n, n, "(");

        return res;
    }

    // O = no. of remaining opening braces
    // C = no. of remaining closing braces
    private void dfs(int O, int C, String s) {
        if (O == 0 && C == 0) {
            res.add(s + ")");
            return;
        }

        if (O > 0) {
            dfs(O - 1, C, s + "(");
        }

        if (C >= 0) {
            dfs(O, C - 1, s + ")");
        }
    }
}
