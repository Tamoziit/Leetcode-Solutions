
public class SpecialCharacters {

    public int numberOfSpecialChars(String word) {
        int[] uppercase = new int[26];
        int[] lowercase = new int[26];
        int splCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // 1-n indexing
            if (Character.isLowerCase(ch)) {
                lowercase[ch - 'a'] = i + 1; // always updates (last occurrence)
            } else {
                if (uppercase[ch - 'A'] == 0) // only set if not seen yet (first occurrence)
                {
                    uppercase[ch - 'A'] = i + 1;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.println("" + (char) (i + 'A') + ": " + lowercase[i] + ", " + uppercase[i]);
            if (lowercase[i] != 0 && uppercase[i] != 0) {
                if (uppercase[i] > lowercase[i]) {
                    splCount++;
                }
            }
        }

        return splCount;
    }

    public static void main(String[] args) {
        SpecialCharacters ob = new SpecialCharacters();
        String word = "eEb";
        System.out.println("Special Characters = " + ob.numberOfSpecialChars(word) + "\n");

        word = "aaAbcBC";
        System.out.println("Special Characters = " + ob.numberOfSpecialChars(word) + "\n");

        word = "AbBCab";
        System.out.println("Special Characters = " + ob.numberOfSpecialChars(word) + "\n");

        word = "cCceDC";
        System.out.println("Special Characters = " + ob.numberOfSpecialChars(word) + "\n");
    }
}
