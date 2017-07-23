// use a 2D array dp to store max side(not square) with right bottom corner at (i, j); dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        if(n==0)
            return 0;
        int maxside = 0;
        int[][] dp = new int[m+1][n+1]; // the 0th row/column is to take care of corner cases
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min( Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    maxside = Math.max(maxside, dp[i][j]);
                }
            }
        }
        return maxside*maxside;
    }
}
