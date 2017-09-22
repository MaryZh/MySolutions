// knapsack problem, refer to: http://www.geeksforgeeks.org/knapsack-problem/
// Here weights are 0's and 1's in a string, value is 1, m and n are the limits of knapsack
// Recursive. TLE

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // save number of 0's and 1's for each string
        int[][] weight = new int[len][2];
        int sum0=0, sum1=0;
        for(int i=0; i<len; i++){
            String temp = strs[i];
            int ones = ones(temp);
            int zeros = temp.length()-ones;
            weight[i][0]=zeros;
            weight[i][1]=ones;
            sum0 += zeros;
            sum1 += ones;
        }
        if(sum0<=m && sum1<=n)
            return len;
        
        return findMax(weight, m, n, len);
    }
    // maxlen up to end
    public int findMax(int[][] weight, int m, int n, int len) {
        // base case
        if(len == 0 || (m == 0 && n==0) )
            return 0;
        // can't use end
        if(weight[len-1][0]>m || weight[len-1][1]>n)
            return findMax(weight, m, n, len-1);
        // can use end
        return Math.max(findMax(weight, m, n, len-1), 1+findMax(weight, m-weight[len-1][0], n-weight[len-1][1], len-1) );
    }
    
    private int ones(String s){
        int count=0;
        for(char c:s.toCharArray()){
            if(c=='1')
                count++;
        }
        return count;
    }
}
