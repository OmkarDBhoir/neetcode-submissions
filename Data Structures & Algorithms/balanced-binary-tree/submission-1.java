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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int left = getHeight(root.left);
        if(left == -1) return left;
        int right = getHeight(root.right);
        if(right == -1) return right;
        if(Math.abs(right - left) > 1) return -1;
        return 1  + Math.max(left, right);
    }
}
