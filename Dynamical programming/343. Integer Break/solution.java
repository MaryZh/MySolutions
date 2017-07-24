public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2; i<=n; i++){
            // i can be split into j, i-j, with each part >=1; further split j gives dp[j], no further split gives j
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[i], Math.max(j, dp[j])*Math.max(i-j,dp[i-j]) );
            }
        }
        return dp[n];
    }
}
