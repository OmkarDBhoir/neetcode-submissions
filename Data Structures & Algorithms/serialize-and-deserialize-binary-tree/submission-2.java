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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSer(root, sb);
        return sb.substring(0, sb.length() - 1).toString();   
    }

    public void dfsSer(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null#");
            return;
        }
        sb.append(root.val).append("#"); 
        dfsSer(root.left, sb);
        dfsSer(root.right, sb);
    }

    public TreeNode dfsDes(Queue<String> q) {
        if(q.isEmpty()) return null;
        String val = q.poll();
        if(val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfsDes(q);
        root.right = dfsDes(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split("#")));
        TreeNode root = dfsDes(q);
        return root;
    }
}
