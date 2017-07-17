// Since nums[-1] = - inf, from -1 ->0, the number increases. The question is equivalent to find the first decreasing number.
// This solution simply do a linear scan. Time complexity: O(N).

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        // if there are less than 1 element
        for(int i=0; i<n-1; i++){
            if(nums[i]>nums[i+1])
                return i;
        }
        return n-1;
    }
}
