// backtracking
// go row by row; use 3 boolean arrays to indicate if each col, major and minor diagonal is filled or not; gradually kick out filled sites
// There are 2*n -1 major/minor diagonals; major can be indexed by col-row+n-1; minor can be indexed by col+row

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        // initialize the board with .
        char[][] board =  new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        
        boolean[] col = new boolean[n];
        boolean[] majDiagonal = new boolean[2*n-1];
        boolean[] minDiagonal = new boolean[2*n-1];
        
        solve(board, res, new ArrayList<String>(), col, majDiagonal, minDiagonal, n, 0);
        
        return res;
    }
    // put queen in a row
    private void solve(char[][] board, List<List<String>> res, List<String> temp, boolean[] col, boolean[] majDiagonal, boolean[] minDiagonal, int n, int row){
        if(row == n){
            res.add( new ArrayList(temp) );
        }
        else{    
            for(int j=0; j<n; j++){ // for each row, check each col; j is col index
                if(!col[j] && !majDiagonal[j-row+n-1] && !minDiagonal[row+j] ){
                    board[row][j]='Q';
                
                    temp.add(String.valueOf(board[row]));
                    col[j] = true;
                    majDiagonal[j-row+n-1] = true;
                    minDiagonal[row+j] = true;
                
                    solve(board, res, temp, col, majDiagonal, minDiagonal, n, row+1);
                
                    board[row][j] = '.';
                    temp.remove(temp.size() -1);
                    col[j] = false;
                    majDiagonal[j-row+n-1] = false;
                    minDiagonal[row+j] = false;
                }
            }
        }
    }
}
