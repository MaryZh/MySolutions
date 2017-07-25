// backtracking. TLE

public class Solution {
    int count=0;
    public int combinationSum4(int[] nums, int target) {
        backtrack(nums, target);
        return count;
    }
    private void backtrack(int[] nums, int target){
        if(target < 0)
            return;
        else if(target == 0)
            count++;
        else{
            for(int i=0; i<nums.length; i++){
                backtrack(nums, target - nums[i]);    // start from i since each number is reusable
            }
        }
    }
}
