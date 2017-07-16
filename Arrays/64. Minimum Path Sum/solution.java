// same idea as (62. Unique Paths)

public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        if(m==0)
            return 0;
        int n = grid[0].length;
        if(n==0)
            return 0;
        if(m==1 && n==1)
            return grid[0][0];
        // the minPathSum for current row
        int[] cur = new int[n];
        // initialize 0th row
        cur[0] = grid[0][0];
        for(int j=1; j<n; j++)
            cur[j] =cur[j-1]+grid[0][j];
        
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(j==0)
                    cur[0] += grid[i][0];  
                else
                    cur[j] = Math.min(cur[j], cur[j-1])+grid[i][j];
            }
        }
        return cur[n-1];
    }
}
