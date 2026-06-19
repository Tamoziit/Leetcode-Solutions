/**
 * Prefix Sum
 * Time: O(N)
 * Space: O(1)
 */
public class HighestAltitude {

    public int largestAltitude(int[] gain) {
        int currentAltitude = 0, maxAltitude = currentAltitude;

        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        HighestAltitude ob = new HighestAltitude();

        System.out.println("TEST CASE 1:");
        int[] gain_1 = {-5, 1, 5, 0, -7};
        System.out.println("Max Altitude = " + ob.largestAltitude(gain_1));

        System.out.println("TEST CASE 2:");
        int[] gain_2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Max Altitude = " + ob.largestAltitude(gain_2));
    }
}
