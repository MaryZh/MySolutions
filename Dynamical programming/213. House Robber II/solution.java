public class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        // if rob 0th, then can't rob n-1. So can either rob (0, n-2), or (1, n-1)
        return Math.max(robRange(nums, 0,n-2), robRange(nums, 1, n-1));
    }
    // this is modified from (198. House Robber)
    public int robRange(int[] nums, int lo, int hi) {
        // Method #2
        int preno = 0, preyes=0; 
        for(int i=lo; i<=hi; i++){
            int temp = preno;
            preno = Math.max(preno, preyes);
            preyes =nums[i]+temp;
        }
        return Math.max(preyes,preno);
    }
}
