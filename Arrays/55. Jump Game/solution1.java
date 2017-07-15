// backtracking. Stack overflow.

public class Solution {
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }
    private boolean jump(int[] nums, int start){
        if(start == nums.length-1)
            return true;
        // if(nums[start] == 0 && start != nums.length-1)   // can be combined into (return false) by the end
        //     return false;
        for(int i=start+1; i<= Math.min(start+nums[start], nums.length-1); i++){
            if(jump(nums, i))
                return true;
        }
        return false;
    }
}
