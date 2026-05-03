public class RotateString {
    /**
     * Time: O(n) * O(n) = O(n^2) [Worst, Average]
     * Space: O(n)
     */
    public boolean rotateString1(String s, String goal) {
        int len = s.length();
        String rotated = s;

        for (int i = 0; i < len; i++) { // O(n)
            rotated = rotated.substring(1, len) + rotated.charAt(0); // O(n)

            if (rotated.equals(goal)) // O(n)
                return true;
        }

        return false;
    }

    /**
     * Time: O(n) + O(n^2) = O(n^2) [Worst]; O(n) + O(n) = O(n) [Average]
     * Space: O(n) + O(n) = O(2n) ~ O(n)
     */
    public boolean rotateString2(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        String rotated = s + s; // O(n) time concatenation
        if (rotated.contains(goal))
            return true; // ~O(n) avg, O(n^2) worst

        return false;
    }

    public static void main(String[] args) {
        RotateString ob = new RotateString();

        String s = "abcde", goal = "cdeab";
        System.out.println("Method 1: Test case 1 - " + ob.rotateString1(s, goal));
        System.out.println("Method 1: Test case 2 - " + ob.rotateString1(s, goal));

        goal = "abced";
        System.out.println("Method 2: Test case 1 - " + ob.rotateString1(s, goal));
        System.out.println("Method 2: Test case 2 - " + ob.rotateString1(s, goal));
    }
}
