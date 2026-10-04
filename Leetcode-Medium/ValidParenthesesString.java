
import java.util.Arrays;
import java.util.Stack;


public class ValidParenthesesString {
    /**
     * Top-down DP - memoization
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public boolean checkValidString1(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return isValidString(0, 0, s, memo);
    }

    private boolean isValidString(int index, int openCount, String str, int[][] memo) {
        // If reached end of the string, check if all brackets are balanced
        if (index == str.length()) {
            return (openCount == 0);
        }
        // If already computed, return memoized result
        if (memo[index][openCount] != -1) {
            return memo[index][openCount] == 1;
        }
        boolean isValid = false;
        // If encountering '*', try all possibilities
        if (str.charAt(index) == '*') {
            isValid |= isValidString(index + 1, openCount + 1, str, memo); // Treat '*' as '('
            if (openCount > 0) {
                isValid |= isValidString(index + 1, openCount - 1, str, memo); // Treat '*' as ')'
            }
            isValid |= isValidString(index + 1, openCount, str, memo); // Treat '*' as empty
        } else {
            // Handle '(' and ')'
            if (str.charAt(index) == '(') {
                isValid = isValidString(index + 1, openCount + 1, str, memo); // Increment count for '('
            } else if (openCount > 0) {
                isValid = isValidString(index + 1, openCount - 1, str, memo); // Decrement count for ')'
            }
        }
        // Memoize and return the result
        memo[index][openCount] = isValid ? 1 : 0;
        return isValid;
    }

    /**
     * Two Stacks
     * Time: O(n)
     * Space: O(n)
     */
    public boolean checkValidString2(String s) {
        // Stacks to store indices of open brackets and asterisks
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If current character is an open bracket, push its index onto the stack
            if (ch == '(') {
                openBrackets.push(i);
            } // If current character is an asterisk, push its index onto the stack
            else if (ch == '*') {
                asterisks.push(i);
                // current character is a closing bracket ')'
            } else {
                // If there are open brackets available, use them to balance the closing bracket
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                    // If no open brackets are available, use an asterisk to balance the closing bracket
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }
        // Check if there are remaining open brackets and asterisks that can balance them
        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {
            // If an open bracket appears after an asterisk, it cannot be balanced, return false
            if (openBrackets.pop() > asterisks.pop()) {
                return false; // '*' before '(' which cannot be balanced.
            }
        }
        // If all open brackets are matched and there are no unmatched open brackets left, return true
        return openBrackets.isEmpty();
    }

    /**
     * Two Pointer
     * Time: O(n)
     * Space: O(1)
     */
    public boolean checkValidString3(String s) {
        int openCount = 0;
        int closeCount = 0;
        int length = s.length() - 1;

        // Traverse the string from both ends simultaneously
        for (int i = 0; i <= length; i++) {
            // Count open parentheses or asterisks
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }

            // Count close parentheses or asterisks
            if (s.charAt(length - i) == ')' || s.charAt(length - i) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }

            // If at any point open count or close count goes negative, the string is invalid
            if (openCount < 0 || closeCount < 0) {
                return false;
            }
        }

        // If open count and close count are both non-negative, the string is valid
        return true;
    }
}
