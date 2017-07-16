// Use the 1st row and the 1st column as markers. If A[i][j]=0, mark the 1st elment in that row and column as 0.
//
// Note: If there is a 0 elment in the 1st row/column, we don't know if it is a 0 element or marker. So I need two extra makers to mark 
// if 1st row/column has 0 element or not.

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if( m ==0)
            return;
        int n = matrix[0].length;
        
        // set the markers
        boolean firstrow =false, firstcol = false;  // markers for 1st row/column
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    if( i == 0)  firstrow = true;
                    if( j == 0)  firstcol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // start from the 2nd row and column, if the row/column marker is 0, set the element to be 0.
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // if firstrow has 0
        if(firstrow){
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }
        // if column has 0
        if(firstcol){
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
    }
}
