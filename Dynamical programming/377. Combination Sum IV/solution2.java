// DP. AC

public class Solution {
    int count=0;
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[] dp = new int[target+1];  // combinationSum for i
        dp[0]=1;
        for(int i=1; i<=target; i++){
            for(int num:nums){
                if(i - num >= 0)
                    dp[i] += dp[i-num];
            }
            // System.out.println("i = "+i+", " +dp[i]);
        }
        return dp[target];
    }
}
