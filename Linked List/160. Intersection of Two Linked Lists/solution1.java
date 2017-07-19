// Use a HashSet to store nodes in A; For nodes in B, check if it is in A. (TLE)
//
// Time complexity: O(m+n). Space complexity: O(m) or O(n)

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
        HashSet<ListNode> set =  new HashSet<>();
        // put nodes in A in the set
        ListNode temp = headA;
        while(temp != null)
            set.add(temp);
        // check nodes in B is in the set or not
        temp = headB;
        while(temp != null){
            if(set.contains(temp))
                return temp;
        }
        return null;
    }
}
