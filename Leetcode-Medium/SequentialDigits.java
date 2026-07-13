/**
 * Sliding Window
 * Time: O(1) — bounded by fixed digit alphabet "123456789" (≤9 digits), independent of (high - low)
 * Space: O(1) auxiliary — excluding output list, which holds at most ~45 elements in the worst case
 */
import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int minD = 0, maxD = 0, lowCpy = low, highCpy = high;

        while (lowCpy > 0) {
            minD++;
            lowCpy /= 10;
        }

        while (highCpy > 0) {
            maxD++;
            highCpy /= 10;
        }

        int size = minD;
        String seq = "123456789";
        while (size <= maxD) {
            for (int i = 0; i <= seq.length() - size; i++) {
                int num = Integer.parseInt(seq.substring(i, i + size));

                if (num >= low && num <= high) {
                    res.add(num);
                } else if (num > high) {
                    break;
                }
            }

            size++;
        }

        return res;
    }

    private void display(List<Integer> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        SequentialDigits ob = new SequentialDigits();

        System.out.println("TEST CASE 1:");
        int low_1 = 100, high_1 = 300;
        List<Integer> res_1 = ob.sequentialDigits(low_1, high_1);
        System.out.println("Range = [" + low_1 + ", " + high_1 + "]");
        ob.display(res_1);

        System.out.println("TEST CASE 2:");
        int low_2 = 1000, high_2 = 13000;
        List<Integer> res_2 = ob.sequentialDigits(low_2, high_2);
        System.out.println("Range = [" + low_2 + ", " + high_2 + "]");
        ob.display(res_2);

        System.out.println("TEST CASE 3:");
        int low_3 = 2000, high_3 = 560009;
        List<Integer> res_3 = ob.sequentialDigits(low_3, high_3);
        System.out.println("Range = [" + low_3 + ", " + high_3 + "]");
        ob.display(res_3);
    }
}
