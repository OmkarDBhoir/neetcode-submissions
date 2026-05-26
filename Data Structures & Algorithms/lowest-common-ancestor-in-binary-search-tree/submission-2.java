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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        map.put(root, null);
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i=0; i<size; i++) {
                TreeNode parent = que.poll();
                if(parent.left != null) {
                    if(parent.left.val == p.val) p = parent.left;
                    else if(parent.left.val == q.val) q = parent.left;
                    map.put(parent.left, parent);
                    que.offer(parent.left);
                }
                if(parent.right != null) {
                    if(parent.right.val == p.val) p = parent.right;
                    else if(parent.right.val == q.val) q = parent.right;
                    map.put(parent.right, parent);
                    que.offer(parent.right);
                }
            }
        }

        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while(p != null) {
            ancestors.add(p);
            p = map.get(p);
        }
        while(q != null && !ancestors.contains(q)) {
            q = map.get(q);
        }

        return q;
    }
}
