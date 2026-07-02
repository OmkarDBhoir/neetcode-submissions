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
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    public void dfs(Node node, Map<Node, Node> map) {
        if(node == null || map.containsKey(node)) return;
        Node n = new Node(node.val);
        map.put(node, n);
        if(node.neighbors !=  null && !node.neighbors.isEmpty()) {
            for(Node nei: node.neighbors) {
                dfs(nei, map);
                if(!map.containsKey(nei)) {
                    map.put(n, new Node(nei.val));
                }
                n.neighbors.add(map.get(nei));
            }
        }
    }
}