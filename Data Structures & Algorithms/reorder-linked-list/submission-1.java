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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null; 
        fast = reverse(fast);
        mergeTwoList(head, fast);
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

    public void mergeTwoList(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) return;
        ListNode ptr = list1;
        while(list1 != null && list2 != null) {
            ListNode next = ptr.next;
            ptr.next = list2;
            list2 = list2.next;
            ptr = ptr.next;
            ptr.next = next;
            ptr = next;
        }
    }
}
