/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode oddHead = head, oddtail = head, evenHead = head.next, eventail = evenHead;
        while(eventail !=null && eventail.next != null){
            // update oddtail
            oddtail.next = eventail.next;
            oddtail = oddtail.next;
            // update eventail
            eventail.next = oddtail.next;
            eventail = eventail.next;
        }
        oddtail.next = evenHead;
        return head;
    }
}
