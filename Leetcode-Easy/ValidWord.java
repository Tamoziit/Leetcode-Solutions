/*
 * LC - 3136
 * Time = O(N)
 * Space = O(1)
 */
public class ValidWord {

    // Helper method to check if a character is a vowel
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;

        int vowel = 0, consonant = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (isVowel(ch)) {
                    vowel++;
                } else {
                    consonant++;
                }
            } else if (Character.isDigit(ch)) {
                continue;
            } else {
                // Invalid character (not a letter or digit)
                return false;
            }
        }

        System.out.println("Vowels = " + vowel + ", Consonants = " + consonant);

        return vowel > 0 && consonant > 0;
    }

    public static void main(String[] args) {
        ValidWord ob = new ValidWord();
        System.out.println("Result = " + ob.isValid("a3$e")); // false
        System.out.println("Result = " + ob.isValid("a3b")); // true
    }
}