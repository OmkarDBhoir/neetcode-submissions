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
        Queue<TreeNode> que = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        que.offer(root);
        while(!que.isEmpty() && (!map.containsKey(p) || !map.containsKey(q))) {
            TreeNode curr = que.poll();
            if(curr.left != null) {
                if(curr.left.val == p.val) p = curr.left;
                else if(curr.left.val  == q.val) q = curr.left;
                que.offer(curr.left);
                map.put(curr.left, curr);
            }
            if(curr.right != null) {
                if(curr.right.val == p.val) p = curr.right;
                else if(curr.right.val  == q.val) q = curr.right;
                que.offer(curr.right);
                map.put(curr.right, curr);
            }
        }

        Set<TreeNode> ancesotrs = new HashSet<>();
        while(p != null) {
            ancesotrs.add(p);
            p = map.get(p);
        }
        while(q != null && !ancesotrs.contains(q)) {
            q = map.get(q);
        }
        return q;
    }
}
