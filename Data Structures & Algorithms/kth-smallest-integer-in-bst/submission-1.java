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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = {-1, k};
        kth(root, ans);
        return ans[0];
    }

    public void kth(TreeNode root, int[] ans) {
        if(root == null || ans[1] < 0) return;
        kth(root.left, ans);
        ans[1]--;
        if(ans[1] == 0) {
            ans[0] = root.val;
            return;
        }
        kth(root.right, ans);
    }
}
