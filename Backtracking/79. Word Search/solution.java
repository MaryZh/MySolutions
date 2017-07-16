// The 0th letter can be anywhere in the board. So for 0th letter at each position in the board, check if it is the first letter,
// and gradually check if the first letter's adjacent letter is the next letter in the word

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // searh word starting from 0th letter at (i,j)
                if(exist(board, m, n, i, j, word,0))
                    return true;
            }
        }
        return false;
    }
    // check if letter at (i, j) in the board, the same as index-th letter in the word; ( searh 0th letter starting from (i,j))
    // if the same, check if (i, j)'s adjacent the same as (index+1)-th letter in the word
    private boolean exist(char[][] board, int m, int n, int i, int j, String word, int index){
        // if tindex is the last letter in the word, the word already found, return true.
        if( index == word.length())
            return true;
        
        // if out of bound, or not the same
        if(i<0 || j <0 || i>= m || j>=n || board[i][j] != word.charAt(index) )
            return false;
        
        // if index is not the last letter, mark(i,j) as used, and check (i,j)'s adjacent for (index+1)-th letter
        board[i][j]='*';
        boolean result = exist(board, m, n, i+1, j, word, index+1) || exist(board, m, n, i-1, j, word, index+1) 
            || exist(board, m, n, i, j-1, word, index+1) || exist(board, m, n, i, j+1, word, index+1);
        // recover (i,j) to its original letter, for search 0th letter starting from other position
        board[i][j] = word.charAt(index);
        return result;
    }
}
