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
        if(lists.length == 1) return lists[0];
        ListNode head = helper(lists, 0, lists.length-1);
        return head;
    }

    public ListNode helper(ListNode[] lists, int start, int end) {
        if(start < end) {
            int mid = start + (end - start) / 2;
            ListNode left = helper(lists, start, mid);
            ListNode right = helper(lists, mid+1, end);
            return merge(left, right);
        }
        return lists[start];
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode temp = new ListNode(-1);
        ListNode ptr = temp;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        if(list1 != null) ptr.next = list1;
        else ptr.next = list2;

        return temp.next;
    }
}
