public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] !='.'){
                    if(!isValid(board, n, i, j,board[i][j]))
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
            if(i !=col && board[row][i] == c)
                return false;
            // check column
            if( i !=row && board[i][col] == c)
                return false; 
        }
        // check 3x3 cells; left-top cell: ((row/3)*3, (col/3)*3)
        for(int i=0; i<9; i++){
            int ro = i/3+(row/3)*3, co = i%3+(col/3)*3;
            if(ro != row && co != col && board[ro][co] == c)
                return false;
        }
        return true;
    }
}
