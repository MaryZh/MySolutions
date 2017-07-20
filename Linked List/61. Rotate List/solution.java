// Append tail to head, cut after len-k moves

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
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        k %= len;
        tail.next = head;    // make a cycle
        // find the place to cut
        for(int i=1; i<=len-k; i++){
            tail = tail.next;
        }
        ListNode newhead = tail.next;
        tail.next = null;
        return newhead;
    }
}
