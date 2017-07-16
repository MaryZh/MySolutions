// Time complexity: O(N).

public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n==0 || (n==1 && nums[0]!=target) )
            return false;
        int rot = findMin(nums, n);
        System.out.println("rot = "+rot);
        int index = rotatedbinarySearch(nums, n, rot, target);
        if(index == -1)
            return false;
        return true;
    }
    // find the position of min
    private int findMin(int[] nums, int n){
        int i=1;
        while(i<n && nums[i]>=nums[i-1]){
            i++;
        }
        return i;
    }
    // binary search
    private int rotatedbinarySearch(int[] nums, int n, int rot, int target){
        int start =0, end = n-1;
        while(start <= end){
            int mid = start +(end-start)/2;
            int realmid = (mid + rot)%n;
            if(nums[realmid] < target)
                start = mid+1;
            else if(nums[realmid] > target)
                end = mid-1;
            else
                return realmid;
        }
        return -1;
    }
}
