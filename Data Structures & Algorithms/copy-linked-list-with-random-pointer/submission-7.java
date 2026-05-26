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
        Node cpHead = new Node(-1);
        Node ptr1 = cpHead;
        while(ptr != null) {
            ptr1.next = ptr.next;
            ptr1 = ptr1.next;
            ptr.next = ptr.next.next;
            ptr = ptr.next;
        }
        return cpHead.next;
    }
}
