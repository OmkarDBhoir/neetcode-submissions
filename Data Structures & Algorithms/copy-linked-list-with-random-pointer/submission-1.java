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
        Node ptr = head;
        while(ptr != null) {
            Node n = new Node(ptr.val);
            n.next = ptr.next;
            ptr.next = n;
            ptr = n.next;
        }

        ptr = head;
        while(ptr != null) {
            if(ptr.random != null) {
                ptr.next.random = ptr.random.next;
            }
            ptr = ptr.next.next;
        }

        ptr = head;
        Node h = new Node(-1);
        Node ptr2 = h;

        while(ptr != null) {
            ptr2.next = ptr.next;
            ptr2 = ptr2.next;
            ptr.next = ptr.next.next;
            ptr = ptr.next;
        }
        
        return h.next;
    }
}
