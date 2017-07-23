public class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        solve(board, n);
    }
    // check if the board is solvable
    private boolean solve(char[][] board, int n){
        // iterate trough each site
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // for each empty site, try 1-9
                if(board[i][j] =='.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, n, i, j, c)){
                            // System.out.println("(i, j) = ("+i+", "+j+"), c valid: " + c);
                            board[i][j] = c;
                    
                            if(solve(board, n) )    // if this soln return true
                                return true;
                            
                            board[i][j] = '.';   // otherwise go back
                        }
                    }
                    // if haven't return true at this point, that means can't solve with any value at (i,j)
                    return false;
                }
            }
        }
        return true;
    }
    // check if c is valid fill for (row,col)
    private boolean isValid(char[][] board, int n, int row, int col, char c){
        for(int i=0; i< n; i++){
            // check row
            if(board[row][i] == c)
                return false;
            // check column
            if(board[i][col] == c)
                return false; 
        }
        // check 3x3 cells; left-top cell: ((row/3)*3, (col/3)*3)
        for(int i=0; i<9; i++){
            if(board[i/3+(row/3)*3][i%3+(col/3)*3] == c)
                return false;
        }
        return true;
    }
}
