// Can also use the technique in (63. Unique Paths II). So that only need to initialize cur[0] instead of the whole array

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur =  new int[n];
        // initialize cur at (0,0)
        cur[0]=1;
        // starting from 1st row, find # of path
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(j>0)
                    cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }
}
