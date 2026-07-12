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
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        map.put(node, new Node(node.val));
        q.offer(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.neighbors != null) {
                for(Node n: curr.neighbors) {
                    if(!map.containsKey(n)) {
                        map.put(n, new Node(n.val));
                        q.offer(n);     
                    }
                }
            }
        }
        for(Map.Entry<Node, Node> entry: map.entrySet()) {
            Node curr = entry.getKey();
            Node clCurr = entry.getValue();
            if(curr.neighbors != null) {
                List<Node> lst = new ArrayList<>();
                for(Node n: curr.neighbors) {
                    lst.add(map.get(n));
                }
                clCurr.neighbors = lst;
            }
        }
        return map.get(node);
    }
}