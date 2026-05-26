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

        return helper(head, k);
    }

    public ListNode helper(ListNode head, int k) {
        if(head == null) return head;
        ListNode ptr = head;
        for(int i=1; i<k; i++) {
            if(ptr.next == null) return head;
            ptr = ptr.next;
        }
        ListNode next = helper(ptr.next, k);
        ptr.next = null;
        ListNode rev = reverse(head);
        head.next = next;
        return rev;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
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
