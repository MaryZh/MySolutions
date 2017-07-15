// A common method to solve image rotation problem:
// 1. clockwise rotation by 90 degrees: (1) reverse up to down; (2) transpose
// 2. counter clockwise rotation by 90 degrees: (1) reverse left to right; (2) transpose

public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        upToDown(matrix, m, n);
        transpose(matrix, m, n);
    }
    // reverse up to down
    private void upToDown(int[][] matrix, int m, int n){
        for(int i=0; i<m/2; i++){ // row; only need to go through half the rows
            for(int j=0; j<n; j++){ // column
                // swap (i,j) and (m-i-1, j)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = temp;
            }
        }
    }
    // transpose
    private void transpose(int[][] matrix, int m, int n){
        for(int i=0; i<m; i++){ // row
            for(int j=0; j<i; j++){ // column; only need to go through left-bottom triangle
                // swap (i,j) and (j, i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
