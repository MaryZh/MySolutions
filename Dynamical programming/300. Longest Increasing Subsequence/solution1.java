public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        if(n == 0)
            return 0;
        int max=1;
        int[] dp = new int[n];  // lengthOfLIS ending as i
        dp[0]=1;
        for(int i=1; i<n; i++){
            dp[i]=1;
            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // System.out.println("i="+i+", "+dp[i]);
            max= Math.max(max, dp[i]);
        }
        return max;
    }
}
