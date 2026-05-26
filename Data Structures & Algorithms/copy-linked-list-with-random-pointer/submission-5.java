/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node ptr = head;
        while(ptr != null) {
            map.put(ptr, new Node(ptr.val));
            if(ptr.random != null) {
                map.put(ptr.random, map.getOrDefault(ptr.random, new Node(ptr.random.val)));
            }
            ptr = ptr.next;
        }
        Node cpHead = map.get(head);
        if(head.random != null) cpHead.random = map.get(head.random);
        ptr = head.next;
        Node ptr2 = cpHead;
        while(ptr != null) {
            ptr2.next = map.get(ptr);
            ptr2 = ptr2.next;
            if(ptr.random != null) ptr2.random = map.get(ptr.random);
            ptr = ptr.next;
        }
        return cpHead;
    }
}
