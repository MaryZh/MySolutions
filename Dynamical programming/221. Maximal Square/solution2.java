// use a 2D array dp to store max side(not square) with right bottom corner at (i, j); dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
// Actully use a 1D array for current row is enough

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        if(n==0)
            return 0;
        int maxside = 0, pre=0;
        int[] dp = new int[n+1]; // the 0th row/column is to take care of corner cases
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int temp =dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j] = Math.min( Math.min(dp[j], dp[j-1]), pre)+1;
                    maxside = Math.max(maxside, dp[j]);
                    pre = temp;
                }
                else
                    dp[j]=0;   // we need this line otherwise dp[j] remains to be the result for the previous line
            }
        }
        return maxside*maxside;
    }
}
