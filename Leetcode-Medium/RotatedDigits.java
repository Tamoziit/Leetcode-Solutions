public class RotatedDigits {
    /**
     * Time: O(nlgn)
     * Space: O(1)
     * Algo: Brute Force
     * 
     * @param n
     * @return good nos. (int)
     */
    public int rotatedDigits(int n) {
        int count = 0;
        int mirrored_nos = 0;

        for (int i = 1; i <= n; i++) { // O(n)
            int num = i;
            int flag = 0;
            int digits = 0;
            int mirror = 0;

            while (num > 0) { // O(lg n)
                int d = num % 10;
                digits++;

                if (d == 3 || d == 4 || d == 7) {
                    flag = 1;
                    break;
                }

                if (d == 1 || d == 8 || d == 0) { // on rotation gives same result --> not good nos.
                    mirror++;
                }

                num /= 10;
            }

            if (flag == 0)
                count++;

            if (mirror == digits)
                mirrored_nos++;
        }

        return count - mirrored_nos;
    }

    public static void main(String[] args) {
        RotatedDigits ob = new RotatedDigits();
        int[] nums = { 10, 1, 2 };

        for (int i = 0; i < nums.length; i++) {
            int res = ob.rotatedDigits(nums[i]);
            System.out.println("For n = " + nums[i] + " Good nos.: " + res);
        }
    }
}