
public class PatternSubstrings {

    /**
     * Brute Force
     * Time: O(P · W · L), where
     * - P = number of patterns
     * - W = word.length()
     * - L = average pattern length
     * Space: O(1)
     */
    public int numOfStrings_1(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (pattern.length() > word.length()) {
                continue;
            }

            boolean found = false;
            for (int j = 0; j <= word.length() - pattern.length(); j++) {
                boolean match = true;
                for (int k = 0; k < pattern.length(); k++) {
                    if (pattern.charAt(k) != word.charAt(j + k)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    found = true;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }

        return count;
    }

    /**
     * KMP string matcher [.contains() method internal]
     * Time: O(P · (W + L))
     * Space: O(1)
     */
    public int numOfStrings_2(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PatternSubstrings ob = new PatternSubstrings();

        System.out.println("TEST CASE 1:");
        String[] patterns_1 = {"a", "abc", "bc", "d"};
        String word_1 = "abc";
        System.out.println("M1: Count = " + ob.numOfStrings_1(patterns_1, word_1));
        System.out.println("M2: Count = " + ob.numOfStrings_2(patterns_1, word_1));

        System.out.println("TEST CASE 2:");
        String[] patterns_2 = {"a", "b", "c"};
        String word_2 = "aaaaabbbbb";
        System.out.println("M1: Count = " + ob.numOfStrings_1(patterns_2, word_2));
        System.out.println("M2: Count = " + ob.numOfStrings_2(patterns_2, word_2));

        System.out.println("TEST CASE 3:");
        String[] patterns_3 = {"a", "a", "a"};
        String word_3 = "ab";
        System.out.println("M1: Count = " + ob.numOfStrings_1(patterns_3, word_3));
        System.out.println("M2: Count = " + ob.numOfStrings_2(patterns_3, word_3));
    }
}
