/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if( k <= 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
            
        breakpoint:
        while(true){
            if(pre == null)
                break;
            ListNode end = pre;
            for(int i=1; i<=k; i++){
                end = end.next;
                if(end == null)
                    break breakpoint;
            }
            // reverse pre.next->end
            ListNode start = pre.next;
            for(int i=1; i<k; i++){
                ListNode then =start.next;
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
            }
            // reset pre
            pre = start;
        }
        return dummy.next;
    }
}
