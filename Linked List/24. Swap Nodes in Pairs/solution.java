// Same idea as (92. Reverse Linked List II)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next !=null && pre.next.next !=null){
            ListNode start = pre.next, then =  start.next;
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            // reset pre
            pre = start;
        }
        return dummy.next;
    }
}
