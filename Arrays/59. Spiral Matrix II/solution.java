// same idea as (54. Spiral Matrix)

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0)
            return matrix;
        // define 4 bounary indices
        int rowBegin = 0,rowEnd = n-1, colBegin = 0, colEnd = n-1;
        int k=1;
        
        while( rowBegin <= rowEnd && colBegin <= colEnd){
            // traverse left->right
            for(int i= colBegin; i<= colEnd; i++)
                matrix[rowBegin][i]=k++;
            
            rowBegin++;
            
            // traverse up->down
            for(int i = rowBegin; i <= rowEnd; i++)
                matrix[i][colEnd]=k++;
            
            colEnd--;
            
            // traverse right->left
            if(rowBegin <= rowEnd){ // to avoid duplicates
                for(int i = colEnd; i>=colBegin; i--)
                    matrix[rowEnd][i]=k++;
            }
            
            rowEnd--;
            
            // traverse down->up
            if(colBegin <= colEnd){ // to avoid duplicates
                for(int i = rowEnd; i>=rowBegin; i--)
                    matrix[i][colBegin]=k++;
            }
            
            colBegin++;
        }
        return matrix;
    }
}
