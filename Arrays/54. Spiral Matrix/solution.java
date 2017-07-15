// After we traverse a row/column, the un-traversed matrix gets smaller and smaller. And as we traverse from different direction, 
// i.e. left->right, up->down, right->left, down->up, different "boundary" of the un-traversed matrix changes
// So we define 4 boundary indices: rowBegin, rowEnd, colBegin, colEnd, increase or decrease one of them as traverse in differetn directions

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;
        // define 4 bounary indices
        int rowBegin = 0,rowEnd = matrix.length-1, colBegin = 0, colEnd = matrix[0].length-1;
        
        while( rowBegin <= rowEnd && colBegin <= colEnd){
            // traverse left->right
            for(int i= colBegin; i<= colEnd; i++)
                res.add(matrix[rowBegin][i]);
            
            rowBegin++;
            
            // traverse up->down
            for(int i = rowBegin; i <= rowEnd; i++)
                res.add(matrix[i][colEnd]);
            
            colEnd--;
            
            // traverse right->left
            if(rowBegin <= rowEnd){ // to avoid duplicates
                for(int i = colEnd; i>=colBegin; i--)
                    res.add(matrix[rowEnd][i]);
            }
            
            rowEnd--;
            
            // traverse down->up
            if(colBegin <= colEnd){ // to avoid duplicates
                for(int i = rowEnd; i>=rowBegin; i--)
                    res.add(matrix[i][colBegin]);
            }
            
            colBegin++;
        }
        return res;
    }
}
