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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] ans = {0};
        getHeight(root, ans);
        return ans[0];
    }

    public int getHeight(TreeNode root, int[] ans) {
        if(root == null) return 0;
        int left = getHeight(root.left, ans);
        int right = getHeight(root.right, ans);
        ans[0] = Math.max(ans[0], left + right);
        return 1 + Math.max(left, right);
    }
}
