// brute force method

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // use an array to store sum up to i; sum[i] is sum up to nums[i-1]
        int[] sum =  new int[n+1];
        for(int i=1; i<n+1; i++)
            sum[i] = sum[i-1]+nums[i-1];
        // for any subarray: start=i, end=j, check is the sum>=s or not
        int res = 0;
        for(int i =1; i<n+1; i++){
            for(int j=i; j<n+1; j++){ // j>=i
                if(sum[j] - sum[i-1] == k){
                    res ++;
                }
            }
        }
        return res;
    }
}
