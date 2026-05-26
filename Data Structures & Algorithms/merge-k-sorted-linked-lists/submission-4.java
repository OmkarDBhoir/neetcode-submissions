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
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode lst: lists) {
            if(lst != null) heap.add(lst);
        }

        ListNode head = heap.poll();
        if(head.next != null) heap.add(head.next);
        ListNode ptr = head;
        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            ptr.next = node;
            ptr = node;
            if(node.next != null) {
                heap.add(node.next);
            }
        }

        return head;
    }
}
