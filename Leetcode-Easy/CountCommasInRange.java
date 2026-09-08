/**
 * Time: O(1)
 * Space: O(1)
 */
public class CountCommasInRange {

    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        } else {
            return n - 999;
        }
    }
}
