/**
 * HashMap + Dynamic Sliding Window
 * Time: O(n)
 * Space: O(1) [fixed 26 char map]
 */
import java.util.HashMap;
import java.util.Map;

public class MaxLenSubstringWith2Occurences {

    public int maximumLengthSubstring(String s) {
        int start = 0, end = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char ch = s.charAt(end);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);

            while (map.get(ch) > 2) {
                char removedChar = s.charAt(start);
                map.put(removedChar, map.get(removedChar) - 1);
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}
