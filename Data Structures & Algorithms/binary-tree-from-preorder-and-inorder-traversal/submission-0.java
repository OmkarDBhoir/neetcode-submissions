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
        if(preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inInd = map.get(preOrder[preStart]);
        int totalLeft = inInd - inStart;
        TreeNode left = buildTree(preOrder, preStart+1, preStart+totalLeft, inOrder, inStart, inInd - 1, map);
        TreeNode right = buildTree(preOrder, preStart + totalLeft + 1, preEnd, inOrder, inInd + 1, inEnd, map);
        root.left = left;
        root.right = right;
        return root;
    }
}
