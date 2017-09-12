// Search for the left and right end of the range use binary search. 
// To search for the left end(leftEnd), use the same method to search in (33. Search in Rotated Sorted Array).
// The way to search for the right end is similary. Now the search range is from leftEnd(inclusive) to n-1, and biase mid to the right half
// so that if there are two target elements left by the end, you will get the right one for right end.
//
// Time complexity: O(Log N)
 
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if( n==0)
            return new int[] {-1,-1};
        // search for left end
        int lo = 0, hi = n-1, mid=0;
        while(lo < hi){
            mid = lo +(hi-lo)/2;
            if(nums[mid]<target)
                lo = mid +1;
            else
                hi = mid;
        } 
        int leftEnd = lo;
        // if leftEnd is not the target, that means the target doesn't exist
        if(nums[leftEnd] != target)
            return new int[] {-1,-1};
        
        // search for the right end
        hi = n-1;   // no need to reset lo
        while(lo < hi){
            mid = lo +(hi-lo)/2+1;  // biase mid to the right half
            if(nums[mid]>target)
                hi = mid -1;
            else
                lo = mid;
        }
        int rightEnd = hi;
        return new int[] {leftEnd,rightEnd};
    }
    
}
