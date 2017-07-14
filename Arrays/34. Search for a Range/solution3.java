// Search for the left end of the range of (target) use binary search,  and that of (target +1).
// firstGreaterEqual finds the left end of the range if the target exists, and the first number greater than the target if it doesn't exist. 
// Basically, high = n (not n-1) is important.
//
// Time complexity: O(Log N)
 
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if( n==0)
            return new int[] {-1,-1};
        // search for left end
        int leftEnd = firstGreaterEqual(nums, n, target);
        // if leftEnd is not the target, that means the target doesn't exist
        if(leftEnd == n || nums[leftEnd] != target) // hi can be n; n if out of index range, so need to test if leftEnd == n or not.
            return new int[] {-1,-1};
             
        int rightEnd = firstGreaterEqual(nums, n, target+1)-1;
        
        return new int[] {leftEnd,rightEnd};
    }
    // search for left end
    private static int firstGreaterEqual(int[] nums, int n, int target){
        int lo = 0, hi = n; // note: hi= n, not (n-1)
        while(lo < hi){
            int mid = lo +(hi-lo)/2;
            if(nums[mid]<target)
                lo = mid +1;
            else
                hi = mid;
        }
        return lo;
    }
}
