// Time complexity: O(N^2)
// For each number in the array, use bi-directional search to find the sum: nums[lo]+nums[hi] = sum-nums[i]
// Note avoid duplicates

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n<3 || (n == 3 && nums[0]+nums[1] != - nums[2]))
            return res;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {    // this also avoid duplicates in the solution
                int lo = i+1, hi = n-1;
                while(lo<hi){
                    if(nums[lo]+nums[hi]> - nums[i]){
                        // this skip duplicate elements and thus improve performance; note: has to put it before hi--
                        while(lo<hi && nums[hi-1] == nums[hi])
                            hi --;
                        hi--;
                    }
                    else if(nums[lo]+nums[hi]< - nums[i]){
                        // this skip duplicate elements and thus improve performance; note: has to put it before lo++
                        while(lo<hi && nums[lo+1] == nums[lo])
                            lo++;
                        lo ++;
                    }
                    else{
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        // this is to avoid duplicates in the solutions; note: has to put it before lo++,hi--
                        while(lo<hi && nums[lo+1] == nums[lo])
                            lo++;
                        while(lo<hi && nums[hi-1] == nums[hi])
                            hi --;
                        lo++;
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
