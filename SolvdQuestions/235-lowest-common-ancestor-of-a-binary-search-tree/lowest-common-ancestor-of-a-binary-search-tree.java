/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // since p and q will exist in the BST, no need for null check

        // if we reached till a point where root is same as p or q, then it will be LCA in BST
        if (root.val == p.val || root.val == q.val)
            return root;

        // if p and q are moving in opposite direction from curr root node, then curr root node is the LCA in BST
        // NOTE: All node values are unique
        if ( (p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
            return root;

        // Now both will be moving in same direction, i.e., either to left subtree or to right subtree
        if (p.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        return lowestCommonAncestor(root.right, p, q);
    }
}