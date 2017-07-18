// Use two pass. First past find the length of linkedlist L. Then the n-th node from the end is L-n+1 -th node from the beginning.
// Second pass do the removing from the beginning.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy =  new ListNode(0);
        dummy.next = head;
        // find the length of the linkedlist
        ListNode node = head;
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        // remove the (len-n+1)-th node from the beginning
        // find the node pre to this node, i.e. (len-n)-th node
        node = dummy;
        while(len > n){
            node = node.next;
            len --;
        }
        node.next = node.next.next;
        return dummy.next;
    }
}
