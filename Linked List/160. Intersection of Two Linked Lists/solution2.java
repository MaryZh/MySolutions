// Use two pointers. pA, pB, each goes by one step each time. After pA goes to the end of A, redirecto to B; 
// after pB goes to the end of B, redirect it to A. Where they meet is the intersection.
// Suppose the length of A is n1+n, the length of B is n2+n, where n the length of common list. pA takes steps n1+n+n2; pB: n2+n+n1.
// 
//
// Time complexity: O(m+n). Space complexity: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA ==null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null? headB:pA.next;
            pB = pB == null? headA:pB.next;
        }
        // if there is no intersection, pA and pB both goes through lenA+lenB, should both be null
        return pA;
    }
}
