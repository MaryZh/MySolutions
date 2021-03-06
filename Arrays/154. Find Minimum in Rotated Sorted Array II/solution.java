// This can find the correct min value, but the index might be wrong/
// Eg. [1,1,1,2,1,1], the index this algorithms returns is 0.

public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo =0, hi=n-1;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]>nums[hi])
                lo = mid+1;
            else if(nums[mid]<nums[hi])
                hi = mid;
            else
                hi--;
        }
        return nums[lo];
    }
}
