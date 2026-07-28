/**
 * Counting Sort Approach
 * Time: O(n)
 * Space: O(1) [const 26 chars]
 */
public class SmallestPalindromicRearrangement1 {

    public String smallestPalindrome(String s) {
        int partition = s.length() / 2; // mid of string
        int[] bucket = new int[26]; // to store the freq.of chars in lexicographically sorted order by default

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 'a']++;
        }

        // building lexicographically smallest left half of palindrome
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (bucket[i] > 0) {
                left.append(String.valueOf((char) (i + 'a')).repeat(bucket[i]));
            }
        }

        String mid = s.length() % 2 != 0 ? String.valueOf(s.charAt(partition)) : ""; // for odd length mid exists (freq = 1), for even length, mid = ""
        String right = new StringBuilder(left).reverse().toString(); // right half is reverse of the left in palindrome

        return left.toString() + mid + right;
    }
}
