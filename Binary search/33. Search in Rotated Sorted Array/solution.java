// 1. Find the rotation center, or the min value, by binary search. It's where mid = hi
// 2. Use a rotated binary search to find target. In binary search, low and high are determined by the indices. To start, they are still 
// low =0, high=n-1. But mid needs to be rotated to the right place, the real index in a sorted array is: realindex = (index + rotationcenter)%n.
// 
// Time complexity: O(Log N). No extra space.

public class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int rot = findMin(nums,n);
        return rotatedbinarySearch(nums, n, rot, target);
    }
    // find the rotation center, or the place of min value
    private int findMin(int[] nums, int n){
        int lo = 0, hi = n-1;
        while(lo < hi){
            int mid = lo +(hi -lo)/2;
            if(nums[mid]>nums[hi])  // this means mid is in the 1st sort part; min is in the second part, so start search from lo=mid+1
                lo = mid+1; // the loop will go to here as long as mid is in the 1st part, and mentain hi = n-1.
            else
                 hi = mid;   // by end of "if", mid is in the 2nd part
        }
        return lo;
    }
    // rotated binary search
    private int rotatedbinarySearch(int[] nums, int n, int rot, int target){
        int lo=0, hi = n-1;
        while(lo<=hi){
            int mid = lo +(hi -lo)/2;   // this  is mid in the sorted array
            int realmid= (mid+rot)%n;   // this is mid in the rotated array
            if(nums[realmid]<target)
                lo = mid +1;
            else if(nums[realmid]>target)
                hi=mid -1;
            else
                return realmid;
        }
        return -1;
    }
}
