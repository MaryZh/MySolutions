// Since the number of the array is from 1-n, we can consider them to be the indices of the array.
// Eg. A=[1,2,3,4,3] -> B=[A[1], A[2], A[3], A[4], A[3]].
// So if there is duplicate in A, there will be a cycle in B, in btw the duplicate indices. 
// Then we can use the same method to find begin of cycle in a linked list to find the duplicate number.

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // find the begin of the cycle
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
