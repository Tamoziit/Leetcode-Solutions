/**
 * Backtracing
 * Time: O(n)
 * Space: O(1)
 */
public class StringSpecialOps2 {

    public char processStr(String s, long k) {
        long len = 0;

        // Pass 1:
        // Compute the final length without actually building the string.
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // Delete last character if present.
                if (len > 0) {
                    len--;
                }
            } else if (ch == '#') {
                // Duplicate the current string.
                len *= 2;
            } else if (ch == '%') {
                continue; // reverse doesn't change length
            } else {
                // Append a normal character.
                len++;
            }
        }

        // k is outside the final string.
        if (k >= len) {
            return '.';
        }

        // Pass 2:
        // Walk backwards through the operations.
        // At each step, map index k from the current string
        // to the corresponding index in the previous string.
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                /*
                 * Forward:
                 * prev + ch
                 *
                 * The appended character occupies index len - 1.
                 */
                if (k == len - 1) {
                    return ch;
                }

                // Otherwise the target index lies in the previous string.
                len--;
            } else if (ch == '%') {
                /*
                 * Forward:
                 * reverse(current)
                 *
                 * If an index is k after reversal,
                 * before reversal it was at:
                 * len - 1 - k
                 */
                k = len - 1 - k;
            } else if (ch == '#') {
                /*
                 * Forward:
                 * prev -> prev + prev
                 *
                 * Example:
                 * abc -> abcabc
                 *
                 * Length doubles.
                 * Any position in the second half maps
                 * back to the same position in the first half.
                 */
                long prevlen = len / 2;

                k %= prevlen;
                len = prevlen;
            } else { // '*'
                /*
                 * Forward:
                 * delete last character if present
                 *
                 * If current length is len,
                 * before deletion length was len + 1.
                 *
                 * We simply restore the length.
                 * The deleted character never survives to
                 * the final string, so we never need to know it.
                 */
                len++;
            }
        }

        return '.';
    }

    public static void main(String[] args) {
        StringSpecialOps2 ob = new StringSpecialOps2();

        System.out.println("TEST CASE 1:");
        String s = "a#b%*";
        System.out.println("Res = " + ob.processStr(s, 1));

        System.out.println("TEST CASE 2:");
        s = "cd%#*#";
        System.out.println("Res = " + ob.processStr(s, 3));

        System.out.println("TEST CASE 3:");
        s = "z*#";
        System.out.println("Res = " + ob.processStr(s, 0));

        System.out.println("TEST CASE 4:");
        s = "%#bz%xum##i##vzo#pwc*#dkwbh####%uf%s*%cgppqhqa%h#l##o%ij%%cz%iga##e###u%#e####jfwx##%%*x%m*%#";
        System.out.println("Res = " + ob.processStr(s, 6523));
    }
}
