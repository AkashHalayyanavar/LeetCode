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
    int diameter = 0;

    int computeDiameter(TreeNode root) {
        if (root==null)
            return 0;

        if (root.left==null && root.right==null)
            return 1;

        int leftLen = computeDiameter(root.left);
        int rightLen = computeDiameter(root.right);

        diameter = Math.max(diameter, leftLen + rightLen);

        return Math.max(leftLen, rightLen) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        computeDiameter(root);
        return diameter;
        
    }
}