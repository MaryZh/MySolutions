// Bottom-up merge sort. Space complexity: O(1).

/**
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
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // find the length of the list
        ListNode node = head;
        int len =0;
        while(node != null){
            len++;
            node = node.next;
        }
        // first sort the list by pairs; then sort by each 4 nodes, then by 8 nodes,...
        for(int step=1; step<= len; step <<= 1){ // mutiply step by 2 each iteration
            ListNode cur=dummy.next, tail = dummy;  // cur is the head of unsorted part
            while(cur != null){
                ListNode left = cur;    // left and right is the head of two lists we want to sort
                ListNode right = split(left, step);
                cur = split(right, step);
                // merge left and right, and update tail
                tail = merge(left, right, tail);
            }
        }
        
        return dummy.next;
    }
    // split a list, the first part has the first n nodes; return the head of the second part
    private ListNode split(ListNode head, int n){
        ListNode cur = head;
        for(int i=1; i<n && cur != null; i++){
            cur = cur.next;
        }
        // now cur is the tail of the first part; cur.next is the head of second part
        // if cur is null, then head of second part is null as well
        if(cur == null)
            return null;
        // if cur is not null, then head of second part is cur.next
        ListNode temp = cur.next;
        cur.next = null;    // end the first part with null
        return temp;
    }
    // merge two sorted list, and append it to tail; return the tail of merged list
    private ListNode merge(ListNode l1, ListNode l2, ListNode tail){
        // merge the two lists
        ListNode cur = tail;
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
        // find the tail of the merged list
        while(cur.next != null)
            cur = cur.next;
        return cur;
    }
}
