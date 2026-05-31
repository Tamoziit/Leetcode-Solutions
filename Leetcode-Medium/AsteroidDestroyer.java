import java.util.Arrays;

public class AsteroidDestroyer {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        boolean allAsteroidsDestroyed = true;
        long currMass = mass;

        for (int i = 0; i < asteroids.length; i++) {
            if (currMass >= asteroids[i]) {
                currMass += asteroids[i];
            } else {
                allAsteroidsDestroyed = false; // planet destroyed
                break;
            }
        }

        return allAsteroidsDestroyed;
    }

    public static void main(String[] args) {
        AsteroidDestroyer ob = new AsteroidDestroyer();

        System.out.println("CASE 1:");
        int mass_1 = 10;
        int[] asteroids_1 = {3, 9, 19, 5, 21};
        System.out.println("Result = " + ob.asteroidsDestroyed(mass_1, asteroids_1));

        System.out.println("CASE 2:");
        int mass_2 = 5;
        int[] asteroids_2 = {4, 9, 23, 4};
        System.out.println("Result = " + ob.asteroidsDestroyed(mass_2, asteroids_2));
    }
}
