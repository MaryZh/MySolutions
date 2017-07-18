// The logic to find the begin of cycle is here: 
// https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything

public class Solution {
    public ListNode detectCycle(ListNode head) {
        // first determine if there is cycle or not
        if(head == null)
            return null;
        
        boolean isCycle = false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        // if there is no cycle
        if( !isCycle)
            return null;
        
        // if there is cycle, find the begin of the cycle
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
