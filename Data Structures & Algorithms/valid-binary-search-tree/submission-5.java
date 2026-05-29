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
        List<Integer> ans = dfs(root);
        for(int i=1; i<ans.size(); i++) {
            if(ans.get(i) <= ans.get(i-1)) return false;
        }
        return true;   
    }

    public List<Integer> dfs(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans  = new ArrayList<>();
        ans.addAll(dfs(root.left));
        ans.add(root.val);
        ans.addAll(dfs(root.right));
        return ans;
    }
}
