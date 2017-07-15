// Greedy: gradually update the leftmost good index. The last index is a trial good index. Then we traversal from right to left. 
// If an index can reach the leftmost good index(index+nums[index] >= leftmost), then it becomes the the new leftmost good index.
//
// Time complexity: O(N). Space complexity: O(1).

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int leftmost = n - 1;
        for(int i= n-1; i>= 0; i-- ){
            if(i+nums[i] >= leftmost)
                leftmost = i;
        }
        return leftmost == 0;
    }
}
