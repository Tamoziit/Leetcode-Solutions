/**
 * Hash Map
 * Time: O(n)
 * Space: O(n)
 */
import java.util.HashMap;
import java.util.Map;

public class MaxBalloons {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        int maxBalloons;

        for (char c : text.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        maxBalloons = Math.min(
                map.getOrDefault('b', 0),
                Math.min(map.getOrDefault('a', 0),
                        Math.min(map.getOrDefault('l', 0) / 2,
                                Math.min(map.getOrDefault('o', 0) / 2,
                                        map.getOrDefault('n', 0)))));

        return maxBalloons;
    }

    public static void main(String[] args) {
        MaxBalloons ob = new MaxBalloons();

        System.out.println("TEST CASE 1:");
        System.out.println("Max balloons = " + ob.maxNumberOfBalloons("nlaebolko"));

        System.out.println("TEST CASE 2:");
        System.out.println("Max balloons = " + ob.maxNumberOfBalloons("loonbalxballpoon"));

        System.out.println("TEST CASE 3:");
        System.out.println("Max balloons = " + ob.maxNumberOfBalloons("leetcode"));
    }
}
