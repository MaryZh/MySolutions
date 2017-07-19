// Recursive method

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
        // find the (k+1)-th node
        ListNode end = head;
        int count = 1;
        while(end != null && count <= k){
            end = end.next;
            count++;
        }
        // if there are k nodes
        if(count == k+1){
            // reverse the nodes starting with end
            end = reverseKGroup(end, k);
            // reverse nodes from head to k; starting from head, gradually attach the next node to end
            while(count-- >1){
                ListNode temp = head.next;
                head.next = end;
                // reset head and end
                end = head;
                head = temp;
            }
            // after the above reverse process, end becomes head
            head = end;
        }
        return head;
    }
}
