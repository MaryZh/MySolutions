public class Solution {
    int count =0;
    
    public int totalNQueens(int n) {
        
        boolean[] col = new boolean[n];
        boolean[] majDiagonal = new boolean[2*n-1];
        boolean[] minDiagonal = new boolean[2*n-1];
        
        solve(col, majDiagonal, minDiagonal, n, 0);
        
        return count;
    }
    // put queen in a row
    private void solve(boolean[] col, boolean[] majDiagonal, boolean[] minDiagonal, int n, int row){
        if(row == n){
            count++;
        }
        else{    
            for(int j=0; j<n; j++){ // for each row, check each col; j is col index
                if(!col[j] && !majDiagonal[j-row+n-1] && !minDiagonal[row+j] ){
                
                    col[j] = true;
                    majDiagonal[j-row+n-1] = true;
                    minDiagonal[row+j] = true;
                
                    solve(col, majDiagonal, minDiagonal, n, row+1);
                
                    col[j] = false;
                    majDiagonal[j-row+n-1] = false;
                    minDiagonal[row+j] = false;
                }
            }
        }
    }
}
