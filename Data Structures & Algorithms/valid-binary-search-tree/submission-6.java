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
                if(curr.s().f() != null && curr.s().f().val >= curr.f().val) return false;
                if(curr.s().s() != null && curr.s().s().val <= curr.f().val) return false;
                if(curr.f().left != null) q.offer(new Pair<>(curr.f().left, new Pair<>(curr.s().f(), curr.f())));
                if(curr.f().right != null) q.offer(new Pair<>(curr.f().right, new Pair<>(curr.f(), curr.s().s())));
            }
        }

        return true;
    }

    public record Pair<K, V>(K f, V s) {};
}
