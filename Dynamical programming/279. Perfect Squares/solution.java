public class Solution {
    public int numSquares(int n) {
        if(n<=0)
            return 0;
        int[] count = new int[n+1]; // store the least # of perfect spuare numbers for i
        count[0]=0;
        for(int i=1; i<= n; i++)
            count[i]=Integer.MAX_VALUE;
             
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                count[i] = Math.min(count[i],count[i-j*j]+1);
            }
        }
        
        return count[n];
    }
}
