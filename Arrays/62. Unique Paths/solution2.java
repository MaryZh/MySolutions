// Suppose # of path to reach (i,j) is p[i][j]. Then p[i][j] = p[i-1][j]+p[i][j-1]. 
// Boundary cases are the 0th row and column, can initialize as 1, i.e. p[0][j]=1, p[i][0]=0
// So we can use a m*n matrix to store the # of path to research each element.
//
// Optimization:  only need to keep the # of path for current row(cur = new int[m]). i.e. initialize cur as 1 for 0th row.
// Then starting from 1st row, cur[i] += cur[i-1]

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur =  new int[n];
        // initialize cur as 1 for 0th row
        for(int i=0; i<n; i++ ) // during the for loop below, the 0th element always stays 1
            cur[i]=1;
        // starting from 1st row, find # of path
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }
}
