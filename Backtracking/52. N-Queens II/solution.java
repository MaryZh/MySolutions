public class Solution {
    public int totalNQueens(int n) {
        // initialize the board with .
        char[][] board =  new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        
        boolean[] col = new boolean[n];
        boolean[] majDiagonal = new boolean[2*n-1];
        boolean[] minDiagonal = new boolean[2*n-1];
        
        return solve(board, 0, col, majDiagonal, minDiagonal, n, 0);
    }
    // put queen in a row
    private int solve(char[][] board, int count, boolean[] col, boolean[] majDiagonal, boolean[] minDiagonal, int n, int row){
        if(row == n){
            count++;
        }
        else{    
            for(int j=0; j<n; j++){ // for each row, check each col; j is col index
                if(!col[j] && !majDiagonal[j-row+n-1] && !minDiagonal[row+j] ){
                    board[row][j]='Q';
                
                    col[j] = true;
                    majDiagonal[j-row+n-1] = true;
                    minDiagonal[row+j] = true;
                
                    count = solve(board, count, col, majDiagonal, minDiagonal, n, row+1);
                
                    board[row][j] = '.';
                    
                    col[j] = false;
                    majDiagonal[j-row+n-1] = false;
                    minDiagonal[row+j] = false;
                }
            }
        }
        return count;
    }
}
