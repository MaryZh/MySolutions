/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       // use recursive call to find ordered node one by one
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
       ListNode ordered;
       if(l1.val < l2.val){
           ordered = l1;
           ordered.next = mergeTwoLists(l1.next, l2);
       }
       else{
           ordered = l2;
           ordered.next = mergeTwoLists(l1, l2.next);
       }
       return ordered;
    }
}
