/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = Integer.MIN_VALUE;

    int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        sum = Math.max(sum, root.val + left + right);

        // Make sure that the return value is >= 0
        return Math.max(0, Math.max(0, Math.max(left, right)) + root.val);
    }

    public int maxPathSum(TreeNode root) {

        helper(root);
        return sum;
    }
}