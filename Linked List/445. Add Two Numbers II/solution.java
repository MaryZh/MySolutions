/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // use a stack to store the values in each list
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // add number in stack2 to stack1
        ListNode cur = null, head= null;
        int sum =0;
        while( !stack1.isEmpty() || !stack2.isEmpty() ){
            if(!stack1.isEmpty()){
                sum += stack1.pop();
            }
            if(!stack2.isEmpty()){
                sum += stack2.pop();
            }
            head = new ListNode(sum%10);
            head.next = cur;
            sum /= 10;
            cur = head;
        }
        
        if(sum == 1){
            head = new ListNode(sum);
            head.next = cur;
        }
        return head;
    }
}
