/*
 * LC - 1233
 * Time = O(NlgN) [sorting] + O(N * k) [for each iteration during String comparison to remove sub-folders]
 *      = O(NlgN + Nk)
 * Space = O(N)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolders {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // O(NlgN)
        List<String> res = new ArrayList<>();

        String anchor = folder[0];
        res.add(anchor);

        for (int i = 1; i < folder.length; i++) { // O(N)
            if (folder[i].startsWith(anchor + "/")) { // O(k) [length of anchor = k]
                continue;
            } else {
                anchor = folder[i];
                res.add(anchor);
            }
        }

        return res;
    }

    public void displayList(List<String> list) {
        for (String item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveSubFolders ob = new RemoveSubFolders();
        List<String> res = new ArrayList<>();

        res = ob.removeSubfolders(new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" });
        ob.displayList(res);
        res = ob.removeSubfolders(new String[] { "/a/b/c", "/a/b/ca", "/a/b/d" });
        ob.displayList(res);
    }
}
