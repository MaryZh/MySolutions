// Time: O(n Log n). Space: O(n).

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        if(n == 0)
            return 0;
        
        int[] dp = new int[n];  // store the increasing sequence encountered by inserting the currenet number
        int len=0;
        for(int num:nums){
            int insertionPoint = Arrays.binarySearch(dp, 0, len, num);
            if(insertionPoint<0)    // if num doesn't exist in dp, binarySearch return -intertionPoint-1,
                insertionPoint = - (insertionPoint+1);   // where insertionPoint is index of 1st element greater than the target
            dp[insertionPoint] = num;
            if(insertionPoint == len)
                len++;
        }
        return len; // the resulting dp is not the longest increasing subsequence, but the length is the same
    }
}
