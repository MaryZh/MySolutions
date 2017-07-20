/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;    // cur is the current examined node
        while(cur != null){
            ListNode then = cur.next;
            if(then != null && then.val == cur.val){
                while(then!=null && then.val == cur.val)
                    then =then.next;
                pre.next = then; // remove cur
            }
            else{
                pre = cur;  // update pre
            }
            // update cur
            cur = then;
        }
        return dummy.next;
    }
}
