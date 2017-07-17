// Optimization based on solution2. Two-point solution. The two points are start and end of subarray
//
// Time complexity: O(n).

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        
        int sum=0;
        int start =0;
        // for any subarray: start=i, end=j, check is the sum>=s or not
        int res = Integer.MAX_VALUE;
        for(int i =0; i<n; i++){  // i= end of subarray
            sum += nums[i];
            if(sum >= s){ // if sum>=s, we can do nothing better with subarray start with start, then we can change start
                while(sum >= s){
                    sum -= nums[start++];
                }
                res = Math.min(res, i-start+2); // start-1 is the min subarray satisfy sum>=s, it has length i-(start-1)+1 = i- start+2
            }
        }
        return res == Integer.MAX_VALUE? 0:res;
    }
}
