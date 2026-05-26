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
        if(root == null) return "null";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder s = new StringBuilder();
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if(curr == null) {
                s.append("null#");
                continue;
            }
            s.append(curr.val).append("#");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return s.substring(0, s.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String[] arr = data.split("#");
        System.out.println(Arrays.toString(arr));
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            if(!arr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }   
        return root;
    }
}
