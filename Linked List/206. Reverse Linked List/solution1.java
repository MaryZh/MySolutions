/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // recursively
        return reverseTwoNodes(head,null);
    }
    private ListNode reverseTwoNodes(ListNode head, ListNode pre){
        if(head == null)
            return pre;
        ListNode temp = head.next;
        head.next=pre;
        return reverseTwoNodes(temp,head);
    }
}
