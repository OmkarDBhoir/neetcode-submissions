/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        int size = 0;
        ListNode ptr = head;
        while(ptr != null) {
            ptr = ptr.next;
            size++;
        }

        if(size == n) return head.next;
        n = n % size;
        ptr = head;
        for(int i=0; i<size - n - 1; i++) {
            ptr = ptr.next;
        }
        if(ptr != null && ptr.next != null) {
            ptr.next = ptr.next.next;
        }
        return head;
    }
}
