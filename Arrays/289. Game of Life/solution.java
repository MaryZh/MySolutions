// use two digits to represent (state after update)(state before update). Initialize (state after update) with 0.
// (1, 3) 01 -> 00; (2) 01 -> 11; (4) 00->10. The 2nd bit changes only for (2,4), so only need to implement these two.
// (state before update) = board &1. (state after update) = board >> 1; 

public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m==0)
            return;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int lives = liveNeighbors(board, m, n, i,j);
                if( board[i][j] == 1 && lives>=2 && lives<= 3) // (2)
                    board[i][j] =3;
                if( board[i][j] == 0 && lives == 3) // (4)
                    board[i][j] = 2;
            }
        }
        // restore the board to 2nd bit
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] >>= 1;
            }
        }
    }
    // find # of live neighbors
    private int liveNeighbors(int[][] board, int m, int n, int i, int j){
        int sum = 0;
        for(int x = Math.max(i-1,0); x<= Math.min(i+1,m-1); x++){
            for(int y = Math.max(j-1,0); y<= Math.min(j+1,n-1); y++){
                sum += (board[x][y] & 1 );
            }
        }
        return sum - (board[i][j] & 1);
    }
}
