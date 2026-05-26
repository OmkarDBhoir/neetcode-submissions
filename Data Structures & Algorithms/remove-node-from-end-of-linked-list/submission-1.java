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
        ListNode ptr = new ListNode(-1);
        ptr.next = head;
        ListNode fast = ptr;
        ListNode slow = ptr;
        for(int i=0; i<n; i++) {
            fast = fast.next;
        }
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return ptr.next;
    }
}
