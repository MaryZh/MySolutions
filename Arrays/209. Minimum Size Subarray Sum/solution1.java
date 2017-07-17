// brute force method: search any subarray
//
// Time complexity: O(n^2).

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        // use an array to store sum up to i; sum[i] is sum up to nums[i-1]
        int[] sum =  new int[n+1];
        for(int i=1; i<n+1; i++)
            sum[i] = sum[i-1]+nums[i-1];
        // for any subarray: start=i, end=j, check is the sum>=s or not
        int res = Integer.MAX_VALUE;
        for(int i =1; i<n+1; i++){
            for(int j=i; j<n+1; j++){ // j>=i
                if(sum[j] - sum[i-1] >= s){
                    res = Math.min(res, j-i+1);
                    break;  // min subarray start=i found, so break j loop
                }
            }
        }
        return res == Integer.MAX_VALUE? 0:res;
    }
}
