/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        return dfs(node, new HashMap<>());
    }

    public Node dfs(Node root, Map<Node, Node> map) {
        if(root == null || map.containsKey(root)) return map.get(root);
        Node curr = new Node(root.val);
        map.put(root, curr);
        if(root.neighbors != null) {
            for(Node n: root.neighbors) {
                dfs(n, map);
                if(!map.containsKey(root)) {
                    map.put(n, new Node(n.val));
                }
                curr.neighbors.add(map.get(n));
            }
        }
        return curr;
    }
}