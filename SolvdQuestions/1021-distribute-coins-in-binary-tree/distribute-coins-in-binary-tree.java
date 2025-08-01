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
    int moves = 0;
    int findMinMoves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = findMinMoves(node.left);
        int right = findMinMoves(node.right);

        moves += Math.abs(left) + Math.abs(right);

        return left + right + node.val - 1;

    }

    public int distributeCoins(TreeNode root) {

        findMinMoves(root);
        return moves;
    }
}