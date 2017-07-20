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
        ListNode cur = head; // leave current node alone
        ListNode after = head; // remove node after is same as cur
        
        while(after != null ){
            after = after.next;
            if(after == null){
                cur.next =after;
                break;
            }
            if( after.val != cur.val ){
                cur.next = after;
                cur = after;
            }
        }
        return head;
    }
}
