/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int carry=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        if(l1 != null || l2 != null || carry != 0){
            node = new ListNode(0);
            int sum = carry;
            if(l1 != null)
                sum += l1.val;
            if(l2 != null)
                sum += l2.val;
            node.val = sum%10;
            carry = sum/10;
            node.next = addTwoNumbers(l1==null? null:l1.next,l2==null?null:l2.next);
        }
        return node;
    }
}
