public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0]=0;
        for(int i=1; i<=num; i++){
            if( isLessPowerOfTwo(i-1)){
                dp[i] = 1;
            }
            else if( ((i-1)&1) == 0){
                dp[i]=dp[i-1] + 1;
            }
            else
                dp[i]=dp[ (i-1 >>1) +1];
        }
        return dp;
    }
    // determine if n is 2^x-1
    private boolean isLessPowerOfTwo(int n){
        while( (n&1) == 1){
            n >>= 1;
        }
        return n ==0;
    }
}
