/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // find the (m-1)-th node
        ListNode pre = dummy;
        for(int i = 1; i<m; i++){
            pre = pre.next;
        }
        // gradually reverse the nodes along the way
        ListNode start = pre.next, then =start.next;
        for(int i=1; i<= n-m; i++ ){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}

// Eg. d -> 1- 2-3-4-5-null. m=2, n=4. 
// First reversing, initialization: d -> 1(pre)- 2(start)-3(then)-4-5-null.
// 1. start.next = then.next; d -> 1(pre)- 2(start)-4-5-null, 3(then)-4-5-null
// 2. then.next = pre.next; d -> 1(pre)- 2(start)-4-5-null, 3(then)- 2(start)-4-5-null
// 3. pre.next = then; d -> 1(pre)-3(then)- 2(start)-4-5-null
// 4. then = start.next; d -> 1(pre)-3- 2(start)-4(then)-5-null
//
// Second reversing: initialization: d -> 1(pre)-3- 2(start)-4(then)-5-null
// 1. start.next = then.next; d -> 1(pre)-3- 2(start)-5-null, 4(then)-5-null
// 2. then.next = pre.next; d -> 1(pre)-3- 2(start)-5-null, 4(then)-3- 2(start)-5-null
// 3. pre.next = then; d -> 1(pre)-4(then)-3- 2(start)-5-null
// 4. then = start.next; d -> 1(pre)-4-3- 2(start)-5(then)-null
