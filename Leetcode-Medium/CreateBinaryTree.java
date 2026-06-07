/**
 * Binary Tree + HashMap
 * Time: O(n)
 * Space: O(n)
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CreateBinaryTree {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parentVal = desc[0], childVal = desc[1], isLeft = desc[2];

            // get or create both nodes
            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                return map.get(val);
            }
        }

        return null;
    }

    private void displayTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);

        displayTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        displayTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    public static void main(String[] args) {
        CreateBinaryTree ob = new CreateBinaryTree();

        System.out.println("TEST CASE 1:");
        int[][] descriptions1 = {
            {20, 15, 1},
            {20, 17, 0},
            {50, 20, 1},
            {50, 80, 0},
            {80, 19, 1}
        };
        TreeNode tree1 = ob.createBinaryTree(descriptions1);
        ob.displayTree(tree1, "", false);

        System.out.println("TEST CASE 2:");
        int[][] descriptions2 = {
            {1, 2, 1},
            {2, 3, 0},
            {3, 4, 1}
        };
        TreeNode tree2 = ob.createBinaryTree(descriptions2);
        ob.displayTree(tree2, "", false);
    }
}
