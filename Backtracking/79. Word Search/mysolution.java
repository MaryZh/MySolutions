// this is my own AC but slow soltuion.

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int wordlen = word.length();
        boolean[][] used = new boolean[m][n];
        
        // find list letter
        List<int[]> firstletterlist = find(board, m, n, word.charAt(0));
        
        return findNextLetter(board, m, n, word, wordlen, 0, firstletterlist, used);
    }
    // find ith letter in word from board, find (i+1)th letter
    private boolean findNextLetter(char[][] board, int m, int n, String word, int wordlen, int ith, List<int[]> ithletterlist, boolean[][] used){
        if(ithletterlist.isEmpty())
            return false;
        if(ith == wordlen-1)
            return true;
        // List<int[]> adjacent = new ArrayList<int[]>();
        // for each position in firtletterlist, find adjacent letters
        for(int[] array:ithletterlist){
            int i= array[0], j = array[1];
            used[i][j] = true;
            List<int[]> cur = findAdjacent(board, m, n, i, j, word.charAt(ith+1), used);
            // adjacent.addAll(cur);
            boolean findnext = findNextLetter(board, m, n, word, wordlen, ith+1, cur, used);
            if(findnext)
                return true;
            used[i][j] = false;
        }
        return false;
    }
    // find letter in the (un-used)board
    private List<int[]> find(char[][] board, int m, int n, char letter){
        List<int[]> list = new ArrayList<int[]>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if( board[i][j] == letter)
                    list.add(new int[]{i,j});
            }
        }
        return list;
    }
    // find letters adjacent to (i,j)
    private List<int[]> findAdjacent(char[][] board, int m, int n, int i, int j, char letter, boolean[][] used){
        List<int[]> list = new ArrayList<int[]>();
        if(i>0 && !used[i-1][j] && board[i-1][j] == letter) // top
            list.add(new int[]{i-1,j});
        if(i<m-1 && !used[i+1][j] && board[i+1][j] == letter) // bottom
            list.add(new int[]{i+1,j});
        if(j>0 && !used[i][j-1] && board[i][j-1] == letter) // left
            list.add(new int[]{i,j-1});
        if(j<n-1 && !used[i][j+1] && board[i][j+1] == letter) // right
            list.add(new int[]{i,j+1});
        return list;
    }
}
