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
    public boolean isValidBST(TreeNode root) {
        return checkBst(root, null, null);
    }

    public boolean checkBst(TreeNode root, TreeNode prev, TreeNode next) {
        if(root == null) return true;
        if(prev != null && prev.val >= root.val) return false;
        if(next != null && next.val <= root.val) return false;
        return checkBst(root.left, prev, root) && checkBst(root.right, root, next);
    }
}
