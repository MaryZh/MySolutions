// Optimization based on solution1: since sum always increases, sum is an sorted array. So we can use binary search for j loop.
// We want to find smallest j satisfy: sum[j]-sum[i-1] >= s
//
// Time complexity: O(n Log n).

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
            int j = minSubarrayEnd(nums, n, s, sum, i);
            if(sum[j] - sum[i-1]>=s){   // note: need to to do this check in case no j is found
                res = Math.min(res, j-i+1);
            }
        }
        return res == Integer.MAX_VALUE? 0:res;
    }
    // binary search for j loop
    private int minSubarrayEnd(int[] nums, int n, int s, int[] sum, int i){
        int lo = i, hi = n;
        while(lo<hi){
            int mid = lo +(hi-lo)/2;
            if(sum[mid] - sum[i-1] >= s)
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }
}
