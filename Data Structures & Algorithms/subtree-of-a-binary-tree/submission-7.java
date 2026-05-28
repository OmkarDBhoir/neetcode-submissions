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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String s1 = bfs(root);
        String s2 = bfs(subRoot);
        return s1.contains(s2);
    }

    public String bfs(TreeNode root) {
        if(root == null) {
            return "null#";
        }
        return root.val + "#" + bfs(root.left) + bfs(root.right); 
    }
}
