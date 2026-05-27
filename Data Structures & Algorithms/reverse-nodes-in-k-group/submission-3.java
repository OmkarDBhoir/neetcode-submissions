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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode ptr = new ListNode(-1);    
        ptr.next = head;
        head = ptr;
        while(ptr !=  null) {
            ListNode curr = ptr;
            for(int i=0; i<k && curr != null; i++) {
                curr = curr.next;
            }
            if(curr == null) break;
            ListNode next = curr.next;
            curr.next = null;
            curr = ptr.next;
            ptr.next = reverse(ptr.next);
            if(curr != null) curr.next = next;
            ptr = curr;
        }
        return head.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
