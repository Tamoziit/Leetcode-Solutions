/**
 * Time: O(N)
 * Memory: O(N)
 */
import java.util.ArrayList;
import java.util.List;

class BuildStackOps {

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int stream = 1;

        for (int i = 0; i < target.length; i++) {
            while (stream < target[i]) { // Read-only stream --> always increasing & never resets --> i.e, stream <= target[target.length - 2] <= n
                res.add("Push");
                res.add("Pop");
                stream++;
            }

            // stream == target[i]
            res.add("Push");
            stream++;
        }

        return res;
    }

    public static void main(String[] args) {
        BuildStackOps ob = new BuildStackOps();
        int[] target = {1, 3};
        int n = 3;
        List<String> res = ob.buildArray(target, n);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }
}
