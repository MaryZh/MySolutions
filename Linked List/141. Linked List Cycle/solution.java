/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // if there is no cycle, head.next.next... will get to null; 
        // if there is cycle, walker will meet with runner at some point, where runnerdistance = walkerdistance + n*lengthofcycle
        if(head == null)
            return false;
        ListNode walker = head, runner = head;
        while(runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner){
                return true;
            }
        }
        
        return false;
        
    }
}
