import java.util.Arrays;

public class LongestCommonSuffixQueries {

    /**
     * Brute Force
     * Time = O(C * Q * L),
        where L =  avg length of each query in wordsQuery[],
        Q = len(wordsQuery[])
        C = len(wordsContainer[])
     * Space = O(1)
     */
    public int[] stringIndices_1(String[] wordsContainer, String[] wordsQuery) {
        int[] res = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            int longestSuffix = -1, idx = 0, bestLen = Integer.MAX_VALUE;
            for (int j = 0; j < wordsContainer.length; j++) {
                String q = wordsQuery[i];
                String c = wordsContainer[j];
                int qi = q.length() - 1; // tail pointer for query
                int ci = c.length() - 1; // tail pointer for container
                int matched = 0;
                // Walking both strings backwards from their own tails
                while (qi >= 0 && ci >= 0 && q.charAt(qi) == c.charAt(ci)) {
                    matched++;
                    qi--;
                    ci--;
                }
                if (matched > longestSuffix
                        || (matched == longestSuffix && c.length() < bestLen)) {
                    longestSuffix = matched;
                    idx = j;
                    bestLen = c.length();
                }
            }
            res[i] = idx; // stores best match index
        }
        return res;
    }

    /**
     * Trie Algorithm & Memoization
     * Time = O((C + Q) × L),
        where L =  avg length of each query in wordsQuery[],
        Q = len(wordsQuery[])
        C = len(wordsContainer[])
     * O(C × L × 26)
     */
    static class TrieNode {

        TrieNode[] children = new TrieNode[26];
        int bestIdx = -1;
        int bestLen = Integer.MAX_VALUE;
    }

    public int[] stringIndices_2(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            TrieNode node = root;

            // Every word passes through root (0-char suffix match fallback)
            root = updateBest(root, i, word.length());

            for (int k = word.length() - 1; k >= 0; k--) {
                int c = word.charAt(k) - 'a';
                if (node.children[c] == null) {
                    node.children[c] = new TrieNode();
                }
                node = node.children[c];
                updateBest(node, i, word.length());
            }
        }

        int[] res = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            TrieNode node = root;

            for (int k = query.length() - 1; k >= 0; k--) {
                int c = query.charAt(k) - 'a';
                if (node.children[c] == null) {
                    break;
                }
                node = node.children[c];
            }

            res[i] = node.bestIdx;
        }

        return res;
    }

    private TrieNode updateBest(TrieNode node, int idx, int len) {
        if (len < node.bestLen || (len == node.bestLen && idx < node.bestIdx)) {
            node.bestIdx = idx;
            node.bestLen = len;
        }
        return node;
    }

    public static void main(String[] args) {
        LongestCommonSuffixQueries ob = new LongestCommonSuffixQueries();

        System.out.println("TEST CASE 1:");
        String[] wordsContainer_1 = {"abcd", "bcd", "xbcd"};
        String[] wordsQuery_1 = {"cd", "bcd", "xyz"};
        int[] res_1 = ob.stringIndices_1(wordsContainer_1, wordsQuery_1);
        System.out.println("M1: " + Arrays.toString(res_1));
        int[] res_2 = ob.stringIndices_2(wordsContainer_1, wordsQuery_1);
        System.out.println("M2: " + Arrays.toString(res_2));

        System.out.println("TEST CASE 2:");
        String[] wordsContainer_2 = {"abcdefgh", "poiuygh", "ghghgh"};
        String[] wordsQuery_2 = {"gh", "acbfgh", "acbfegh"};
        int[] res_3 = ob.stringIndices_1(wordsContainer_2, wordsQuery_2);
        System.out.println("M1: " + Arrays.toString(res_3));
        int[] res_4 = ob.stringIndices_2(wordsContainer_2, wordsQuery_2);
        System.out.println("M2: " + Arrays.toString(res_4));
    }
}
