// Time complexity: O(N^2)
// For each element in the array, bi-drectionally search 2sum in the rest of the array. Update res if 2sum is closer to the target
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n == 3 )
            return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        int sum=0, res = nums[0]+nums[1]+nums[2];
        for(int i=0; i<n; i++){
            int lo = i+1, hi = n-1;
            while(lo<hi){
                sum = nums[i]+ nums[lo]+nums[hi];
                if(Math.abs(target-sum) < Math.abs(target-res ) ){
                    res = sum;
                    if(res == target)
                        return res;
                }
                if(sum>target)
                    hi--;
                else
                    lo++;
            }
        }
        return res;
    }
}
