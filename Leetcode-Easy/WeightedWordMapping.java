/**
 * Simulation
 * Time: O(n * m); n = no. of words, m = avg. word length
 * Space: O(n); n = no. of words
 */
public class WeightedWordMapping {

    public String mapWordWeights(String[] words, int[] weights) {
        int sum;
        StringBuilder res = new StringBuilder(words.length);

        for (String word : words) {
            sum = 0;
            for (int j = 0; j < word.length(); j++) {
                sum += weights[word.charAt(j) - 'a'];
            }
            res.append((char) ('z' - (sum % 26)));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        WeightedWordMapping ob = new WeightedWordMapping();

        System.out.println("TEST CASE: 1");
        String[] words_1 = {"abcd", "def", "xyz"};
        int[] weights_1 = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        System.out.println("Res = " + ob.mapWordWeights(words_1, weights_1));

        System.out.println("TEST CASE: 2");
        String[] words_2 = {"a", "b", "c"};
        int[] weights_2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Res = " + ob.mapWordWeights(words_2, weights_2));

        System.out.println("TEST CASE: 3");
        String[] words_3 = {"abcd"};
        int[] weights_3 = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
        System.out.println("Res = " + ob.mapWordWeights(words_3, weights_3));
    }
}
