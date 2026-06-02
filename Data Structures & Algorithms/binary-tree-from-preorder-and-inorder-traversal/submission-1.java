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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();   
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inInd = map.get(root.val);
        int totalLeft = inInd - inStart;
        TreeNode left = buildTree(preorder, preStart+1, preStart + totalLeft, inorder, inStart, inInd-1, map);
        TreeNode right = buildTree(preorder, preStart + totalLeft + 1, preEnd, inorder, inInd + 1, inEnd, map);

        root.left = left;
        root.right = right;
        return root;
    }
}
