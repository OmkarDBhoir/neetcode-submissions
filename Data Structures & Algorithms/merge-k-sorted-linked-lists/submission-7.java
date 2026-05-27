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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode lst: lists) {
            if(lst != null) q.offer(lst);
        }
        ListNode head = q.poll();
        if(head.next != null) q.offer(head.next);
        ListNode ptr = head;
        while(!q.isEmpty()) {
            ptr.next = q.poll();
            ptr = ptr.next;
            if(ptr.next != null) q.offer(ptr.next);
        }
        return head;
    }
}
