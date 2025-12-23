import java.util.ArrayList;
import java.util.List;

class DisappearedNumbers {

    // Time: O(N), Memory: O(N)
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        int[] bitmask = new int[n];
        List<Integer> res = new ArrayList<>();
        int i;

        for (i = 0; i < n; i++) {
            bitmask[i] = 0;
        }

        for (i = 0; i < n; i++) {
            bitmask[nums[i] - 1] = 1;
        }

        for (i = 0; i < n; i++) {
            System.out.print(bitmask[i] + " ");
        }
        System.out.println();

        for (i = 0; i < n; i++) {
            if (bitmask[i] == 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    // Time: O(N), Memory: O(1)
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int i;

        for (i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        for (i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        for (i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        DisappearedNumbers ob = new DisappearedNumbers();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> res = ob.findDisappearedNumbers1(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();

        res = ob.findDisappearedNumbers2(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }
}
