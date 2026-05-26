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
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        return bfs(node, map);
    }

    public Node dfs(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for(Node nei: node.neighbors) {
            clone.neighbors.add(dfs(nei, map));
        }

        return clone;
    }

    public Node bfs(Node node, HashMap<Node, Node> map) {
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        q.offer(node);
        while(!q.isEmpty()) {
            Node n = q.poll();
            for(Node nei: n.neighbors) {
                if(!map.containsKey(nei)) {
                    Node newClone  = new Node(nei.val);
                    map.put(nei, newClone);
                    q.offer(nei);
                }

                map.get(n).neighbors.add(map.get(nei));
            }
        }
        return clone;
    }
}