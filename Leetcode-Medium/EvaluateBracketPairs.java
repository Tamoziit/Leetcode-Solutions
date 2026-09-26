/**
 * Hahmap + Stack
 * Time: O(N + M); n = len(s), M = no. of <key, value> pairs in knowledge map
 * Space: O(N + M); N = length of result string, M = knowledge Hashmap
 */
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class EvaluateBracketPairs {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = knowledge.stream()
                .collect(Collectors.toMap(
                        list -> list.get(0),
                        list -> list.get(1),
                        (existing, replacement) -> existing));

        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder key = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
                continue;
            }

            if (ch == ')' && !st.isEmpty()) {
                st.pop();
                res.append(knowledgeMap.getOrDefault(key.toString(), "?"));
                key.setLength(0);
                continue;
            }

            if (!st.isEmpty()) {
                key.append(ch);
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
