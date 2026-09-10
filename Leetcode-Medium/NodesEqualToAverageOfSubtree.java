/**
 * Post order traversal
 * Time: O(n)
 * Space: O(lgn) [where lgn = ht. of Binary tree for stack trace]
 */
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

public class NodesEqualToAverageOfSubtree {

    private int res = 0;

    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return res;
    }

    // returns {sum, count} for the subtree rooted at node
    private int[] postorder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = postorder(node.left);
        int[] right = postorder(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == node.val) {
            res++;
        }

        return new int[]{sum, count};
    }
}
