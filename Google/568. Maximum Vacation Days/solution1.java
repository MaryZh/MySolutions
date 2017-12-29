// dfs
// time: O(N^K)

public class Solution {
    int max = 0, N = 0, K = 0;
    
    public int maxVacationDays(int[][] flights, int[][] days) {
        N = flights.length;
        K = days[0].length;
        dfs(flights, days, 0, 0, 0);
        
        return max;
    }
    // start from curr city in week
    private void dfs(int[][] f, int[][] d, int curr, int week, int sum) {
        if (week == K) {
            max = Math.max(max, sum);
            return;
        }
        // for next week, stay in the same city or go to another city(dest)
        for (int dest = 0; dest < N; dest++) {
            if (curr == dest || f[curr][dest] == 1) {   // curr == dest for staying in the same city; f[][]=1 for going to another city
                dfs(f, d, dest, week + 1, sum + d[dest][week]);
            }
        }
    }
}
