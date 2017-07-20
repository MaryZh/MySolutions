// First reverse the second half, the insert the second half into the first half one by one


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        // to reverse the second half, find the middle of the list
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is now the node before the second half(i.e. before mid, so that the name preMid); now reverse the 2nd half
        ListNode pre = slow, start = pre.next;  // pre remains the same in the while loop
        while(start.next != null){
            ListNode then = start.next;
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
        }
        // insert the 2nd half(start from pre.next) into 1st half one by one
        ListNode firsthead = head, cur = pre.next;  // cur is the current we want to insert, insert btw firsthead and firsthead.next
        while(cur != null){
            ListNode then = cur.next;   // store the node needed to be inserted next
            pre.next = then;    // remove cur from the 2nd half
            cur.next = firsthead.next;  // insert cur before firsthead.next
            firsthead.next = cur;   // insert cur after firsthead
            // update
            firsthead = cur.next;
            cur = then;
        }
    }
}
