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
        StringBuilder s = new StringBuilder();
        bfs(root, s);
        String s1 = s.toString();
        s.setLength(0);
        bfs(subRoot, s);
        String s2 = s.toString();
        return s1.contains(s2);
    }

    public void bfs(TreeNode root, StringBuilder p) {
        if(root == null) {
            p.append("null");
            return;
        }
        p.append(root.val);
        bfs(root.left, p);
        bfs(root.right, p);
    }
}
