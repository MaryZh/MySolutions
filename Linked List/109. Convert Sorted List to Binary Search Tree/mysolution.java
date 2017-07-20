/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        // divide the list into two halves
        ListNode preMid = null, slow = head, fast = head;
        while(fast.next != null && fast.next.next !=null){
            preMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // now, slow is mid; second is head of second half
        ListNode second = slow.next;
        if(preMid != null)
            preMid.next = null;   // end the first half
        TreeNode treehead = new TreeNode(slow.val);
        treehead.left = sortedListToBST(preMid == null?null:head);
        treehead.right = sortedListToBST(second);
            
        return treehead;
    }
}
