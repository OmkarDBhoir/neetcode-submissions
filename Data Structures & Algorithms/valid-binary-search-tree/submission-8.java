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
        if(root == null) return true;
        Queue<Pair<TreeNode, Pair<TreeNode, TreeNode>>> q = new LinkedList<>();
        q.offer(new Pair<>(root, new Pair<>(null, null)));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Pair<TreeNode, Pair<TreeNode, TreeNode>> curr = q.poll();
                TreeNode p = curr.f();
                TreeNode min = curr.s().f();
                TreeNode max = curr.s().s();
                if(min != null && min.val >= p.val) return false;
                if(max != null && max.val <= p.val) return false;
                if(p.left != null) q.offer(new Pair<>(p.left, new Pair<>(min, p)));
                if(p.right != null) q.offer(new Pair<>(p.right, new Pair<>(p, max)));
            }
        }

        return true;
    }

    public record Pair<K, V>(K f, V s) {};
}
