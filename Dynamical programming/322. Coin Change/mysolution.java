public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];   // store the fewest number of coins need for i
        dp[0]=0;
        
        for(int i=1; i<= amount; i++){
            int count = Integer.MAX_VALUE;
            for(int j:coins){
                if(i>=j && dp[i-j] != Integer.MAX_VALUE){
                    count = Math.min(count, dp[i-j]+1);
                }
            }
            dp[i]=count;
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
