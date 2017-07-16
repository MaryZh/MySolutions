public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        int[] cur =  new int[n];
        // initialize cur at (0,0)
        cur[0]=1;
        // starting from 1st row, find # of path
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1)
                    cur[j]=0;
                else if(j>0)
                    cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }
}
