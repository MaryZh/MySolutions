// This is my solution: find the position of one target by binary search, then search it's left and right sides.
//
// Time complexity: O(Log N + #ofTargets). If #ofTargets if is O(N), then this is actually an O(N) algorithm instead of O(Log N).

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        int lo = 0, hi = n-1, mid=0;
        boolean found =false;
        while(lo <= hi){
            mid = lo +(hi-lo)/2;
            if(nums[mid]<target)
                lo = mid +1;
            else if(nums[mid]> target)
                hi = mid -1;
            else{
                found = true;
                break;
            }
        }
        if(found == false)
            return new int[]{-1,-1};
        
        int start =mid, end = mid;
        if(mid >0){
            int k =mid;
            while(k>0 && nums[--k] == target)
                ;
            if( k == 0 && nums[k] == target)
                start =k;
            else
                start = k+1;
        }
        if(mid<n-1){
            int j=mid;
            while(j<n-1 && nums[++j] == target)
                ;
            if( j == n-1 && nums[j] == target)
                end = j; 
            else
                end =j-1;
        }
        res[0] = start;
        res[1] = end;
    
        return res;
    }
    
}
