/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // create a dummy node; iterate through the list, if less than x, remove it and append it to dummy
        ListNode dummy =  new ListNode(0);
        // check head
        ListNode pre = dummy;    // pre is the tail of already examined
        ListNode newhead = head;    // newhead is the head of leftover list
        while(newhead!=null && newhead.val < x){
            pre.next = newhead;
            // update
            pre = newhead;
            newhead = newhead.next;
        }
        pre.next = null;
        // check the rest
        if(newhead == null)
            return dummy.next;
        
        ListNode precur =  newhead, cur = newhead.next;
        while(cur != null){
            ListNode then = cur.next;   // store the next node needed to be examined
            if(cur.val < x){
                precur.next = cur.next; // remove cur
                pre.next = cur; // append cur to pre
                // update
                pre = cur;
                pre.next=null;
            }
            else
                precur = cur;
            cur = then;
        }
        pre.next = newhead;
        return dummy.next;
    }
}
