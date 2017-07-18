// one pass solution. 
// To move the n-th from the end, we need to find the node before it(target node). The target node is (n+1) nodes away from null. 
// Use two pointers, first pointer to the beginning, second pointer is (n+1) nodes away. Move both until second =null,
// then first is now pointing to the target node.

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
        ListNode first = dummy, second = dummy;
        // find second pointer
        for(int i=1; i <= n+1; i++){
            second = second.next;
        }
        // move both pointers until second = null
        while(second != null){
            first = first.next;
            second = second.next;
        }
        // first is now pointing to the target node
        first.next = first.next.next;
        return dummy.next;
    }
}
