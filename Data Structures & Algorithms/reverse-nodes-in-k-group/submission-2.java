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
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        ListNode ptr = head;
        while(ptr != null) {
            ListNode start = ptr;
            int count = 1;
            while(count < k && ptr.next != null) {
                ptr = ptr.next;
                count++;
            }

            if(count < k) {
                tail.next = start;
                break;
            }

            ListNode next = ptr.next;
            ptr.next = null;
            ListNode rev = reverse(start);
            tail.next = rev;
            tail = start;
            ptr = next;
        }
        return newHead.next;
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
