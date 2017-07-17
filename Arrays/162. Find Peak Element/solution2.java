// Since nums[-1] = - inf, from -1 ->0, the number increases. The question is equivalent to find the first decreasing number.
// This solution simply do a binary search. Time complexity: O(Log N).

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int lo = 0, hi=n-1;
        while(lo < hi){
            int mid = lo +(hi-lo)/2;
            if(nums[mid] > nums[mid+1]) // if mid is decreasing, there must be a decreasing number to the left
                hi = mid;
            else    // if mid is increasing, there must be a decreasing number to the right
                lo = mid+1;
        }
        return lo;
    }
}
