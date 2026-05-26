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
        if(root == null) return 0;
        int[] ans = {k, 0};
        bfs(root, ans);
        return ans[1];   
    }

    public void bfs(TreeNode root, int[] ans) {
        if(root == null) return;
        bfs(root.left, ans);
        if(ans[0] == 0) return;
        ans[0]--;
        ans[1] = root.val;
        bfs(root.right, ans);
    }
}
