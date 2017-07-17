public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        
        int lo =0, hi=n-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            // check mid
            if(nums[mid] ==target)
                return true;
            if(nums[mid]>nums[hi]){   // if mid is at the 1st half, left of mid is sorted array, when search left? lo=<target<mid
                if(nums[mid]>target && nums[lo]<=target)  // search left
                else    // in other conditions, search right of mid
                    lo = mid+1; // mid or mid+1?
            }
            else if(nums[mid]<nums[hi]){   // if mid is at the 2nd half, right of mid is sorted array, when search right? mid<target=<hi
                if(nums[mid]<target && target <= nums[hi])  // search right
                    lo  = mid+1;
                else
                    hi = mid-1;
            }
            else    // if mid = hi, since mid != target, hi != target. So hi can be excluded from search, simply do hi--;
                hi -- ;
        }
        return false;
    }
}
