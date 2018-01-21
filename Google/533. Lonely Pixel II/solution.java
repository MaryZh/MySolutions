// The key observation here is that # of rows that contain valid B's must also be N.

public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        if (m == 0) 
            return 0;
        int n = picture[0].length;
        if (n == 0) 
            return 0;
        
        Map<String, Integer> map = new HashMap<>(); // used to record (row_patten, # of such rows); only save rows that contain N B's
        int[] colCount = new int[n];
        
        for (int i = 0; i < m; i++) {
            scanRow(picture, i, N, colCount, map);
        }
        
        int result = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {    // if there are N such rows
                // find columns that have N B's as well
                for (int j = 0; j < n; j++) {
                    if (key.charAt(j) == 'B' && colCount[j] == N) {
                        result += N;
                    }
                }
            }
        }
        
        return result;
    }
    
    private void scanRow(char[][] picture, int row, int target, int[] colCount, Map<String, Integer> map) {
        int n = picture[0].length;
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
            sb.append(picture[row][j]);
        }
        
        String rowPatten = sb.toString();
        if (rowCount == target) 
            map.put(rowPatten, map.getOrDefault(rowPatten,0)+1);
    }
}
