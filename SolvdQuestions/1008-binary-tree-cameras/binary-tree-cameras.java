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

    // 0 => No camera and not being watched
    // 1 => No camera but being watched
    // 2 => Camera and being watched

    int count = 0;

    int solve(TreeNode root) {
        
        // Base case for leaf node we don't want any camera, for which case we should return 1 from null
        // So, that left will return 0
        if (root == null)
            return 1;

        int left = solve(root.left);
        int right = solve(root.right);

        // if any of the child is not monitored, then we need to add camera 
        if (left == 0 || right == 0) {
            count++;
            return 2;
        }

        // if any of the child has the camera, then we don't need camera as root is being watched
        if (left == 2 || right == 2)
            return 1;

        // now only left case is left=1 and right=1, for which case we return 0
        return 0;

    }

    public int minCameraCover(TreeNode root) {
        // if root gives 0, then we have to monitor at root too, so increase the count in that case
        if (solve(root) == 0)
            count++;
        return count;
    }
}