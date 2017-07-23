public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // sudoku's dimension is 9 for sure, so no need to calculate the dimension of board
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] !='.'){
                    if(!isValid(board, i, j,board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
    // check if c is valid fill for (row,col)
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0; i< 9; i++){
            // check row
            if(i !=col && board[row][i] == c)
                return false;
            // check column
            if( i !=row && board[i][col] == c)
                return false;
            // check 3x3 sub-boxes; left-top cell: ((row/3)*3, (col/3)*3)
            int ro = i/3+(row/3)*3, co = i%3+(col/3)*3;
            if(ro != row && co != col && board[ro][co] == c)
                return false;
        }
        return true;
    }
}
