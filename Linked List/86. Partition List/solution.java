// create two lists to store smaller and larger nodes

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // create a dummy node; iterate through the list, if less than x, remove it and append it to dummy
        ListNode smallerHead =  new ListNode(0), largerHead =  new ListNode(0);
        ListNode smaller = smallerHead, larger = largerHead;
        while(head != null){
            if(head.val < x){
                smaller.next = head;
                smaller = head;
            }
            else{
                larger.next =head;
                larger = head;
            }
            head = head.next;
        }
        smaller.next = larger.next;
        return smallerHead.next;
    }
}
