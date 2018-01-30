// Note how to: 
// 1. use dfs to return result
// 2. use symmetry to reduce duplicate calculation

public class Solution {
    // cur: the current position
    // remain: the steps remaining
    int DFS(boolean marked[], int[][] skip, int cur, int steps) {
        if(steps < 0) 
            return 0;
        if(steps == 0) 
            return 1;
        marked[cur] = true;
        int res = 0;
        // neighbor can be any site except for itself
        for(int i = 1; i <= 9; ++i) {
            // If marked[i] is not visited and (two numbers are adjacent or skip number is already visited)
            if(!marked[i] && (skip[cur][i] == 0 || (marked[skip[cur][i]]))) {
                res += DFS(marked, skip, i, steps - 1);
            }
        }
        marked[cur] = false;
        return res;
    }
    
    public int numberOfPatterns(int m, int n) {
        // Skip array represents number to skip between two pairs
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean marked[] = new boolean[10];
        int rst = 0;
        // DFS search each length from m to n
        for(int i = m; i <= n; ++i) {
            rst += DFS(marked, skip, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
            rst += DFS(markeds, skip, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
            rst += DFS(marked, skip, 5, i - 1);        // 5
        }
        return rst;
    }
}
