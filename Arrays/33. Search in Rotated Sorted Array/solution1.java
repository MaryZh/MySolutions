// This is my own solution.
// Time complexity: O(max(N1,logN1+logN2))
public class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n == 0)
            return -1;
        // find where the array is rotated; i is the last of the first part
        int i=0;
        while(i<n-1 && nums[i+1]>nums[i]){
            i++;
        }
        // use binary search to search target in both parts
        int index1 = search(nums, 0, i, target);
        if(index1 != -1)
            return index1;
        int index2 = search(nums, i+1, n-1, target);
        if(index2 != -1)
            return index2;
        else
            return -1;
    }
    // binary search
    private int search(int[] nums, int lo, int hi, int target){
        while(lo<=hi){
            int mid = lo +(hi -lo)/2;
            if(nums[mid]<target)
                lo++;
            else if(nums[mid]>target)
                hi --;
            else
                return mid;
        }
        return -1;
    }
}
