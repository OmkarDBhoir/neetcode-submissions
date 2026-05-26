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
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node newHead = new Node(-1);
        Node ptr1 = head;
        Node ptr2 = newHead;
        while(ptr1 != null) {
            ptr2.next = new Node(ptr1.val);
            ptr2 = ptr2.next;
            map.put(ptr1, ptr2);
            ptr1 = ptr1.next;
        }

        ptr1 = head;
        ptr2 = newHead.next;
        while(ptr1 != null) {
            if(ptr1.random != null) {
                ptr2.random = map.get(ptr1.random);
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return newHead.next;
    }
}
