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
        if(node.neighbors == null || node.neighbors.isEmpty()) return new Node(node.val);
        HashMap<Node, Node> map = new HashMap<>();
        genMap(node, map);
        return map.get(node);
    }

    public void genMap(Node node, Map<Node, Node> map) {
        if(node == null || map.containsKey(node)) return;
        Node n = new Node(node.val);
        map.put(node, n);
        for(Node nei: node.neighbors) {
            genMap(nei, map);
            if(!map.containsKey(nei)) {
                map.put(nei, new Node(nei.val));
            }
            n.neighbors.add(map.get(nei));
        }
    }
}