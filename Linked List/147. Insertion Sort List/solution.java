// use a fresh new list to store the sorted list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);   // head of sorted list
        
        ListNode cur = head;    // node to be inserted
        while( cur != null ){
            ListNode pre = dummy;
            ListNode then = cur.next;   // store the next node to be sorted
            // find the rigth place to insert
            while(pre.next!=null && pre.next.val<cur.val){
                pre = pre.next;
            }
            // insert btw pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            // update cur
            cur = then;
        }
        return dummy.next;
    }
}
