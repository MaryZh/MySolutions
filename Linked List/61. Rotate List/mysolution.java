/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k ==0)
            return head;
        // find the length of the list
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        
        // find the end, then append the end to the head
        for(int i=1; i<=k%len; i++){
            ListNode preEnd = head, end = head;
            while(end.next != null){
                preEnd = end;
                end = end.next;
            }
            // append the end to the head
            preEnd.next = null;
            end.next = head;
            // update
            head = end;
        }
        return head;
    }
}
