/**
 * Time: O(N)
 * Memory: O(N + 1)
 *
 */
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] bitmask = new int[n + 1];
        int[] res = new int[2];

        for (int i = 1; i < n + 1; i++) {
            bitmask[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            bitmask[nums[i]]++;
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(bitmask[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < n + 1; i++) {
            if (bitmask[i] == 0) {
                res[1] = i;
            }
            if (bitmask[i] > 1) {
                res[0] = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        SetMismatch ob = new SetMismatch();
        int[] res = ob.findErrorNums(nums);

        for (int i = 0; i < 2; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
