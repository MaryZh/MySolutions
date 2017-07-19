// Merge-sort. Since this is a recursive method, the space complexity is actually O(log n), not O(1).

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==null)
            return head;
        // split the list into two equal parts
        ListNode pre=null, slow = head, fast = head;
        while(fast != null && fast.next !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;   // end the first part with null
        // sort each of them
        ListNode l1= sortList(head);
        ListNode l2= sortList(slow);
        // then merge them together
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null)
            cur.next = l1;
        if(l2 != null)
            cur.next = l2;
        return dummy.next;
    }
}
