// dp. dp[N][K] with dp[i][j] = max vacation days in week i, city j. d[i][j] = max(dp[i-1][k] + days[j][i]) for k = 0, ..., N-1
// since dp[i][j] is only related to do[i-1][k], only need a 1D dp array.
// time: O(N^2*K)

public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        // for week i, city j 
        for (int i = 0; i < K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {
                // update dp[i] with dp[i-1][k], with k=0-N 
                for(int k = 0; k < N; k++) {
                    if (j == k || flights[k][j] == 1) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }
        
        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        
        return max;
    }
}
