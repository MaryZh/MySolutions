// Time complexity: O(N^3)
// This is based on threeSum method
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n<4 || (n == 4 && nums[0]+nums[1] != target- (nums[2]+nums[3] )))
            return res;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {    // this also avoid duplicates in the solution
                for(int j=i+1; j<n; j++){
                    if (j == i+1 || (j > 0 && nums[j] != nums[j-1])) {
                        int lo = j+1, hi = n-1;
                        while(lo<hi){
                            if(nums[lo]+nums[hi]> target- (nums[i]+nums[j]) ) {
                                // this skip duplicate elements and thus improve performance; note: has to put it before hi--
                                while(lo<hi && nums[hi-1] == nums[hi])
                                    hi --;
                                hi--;
                            }
                            else if(nums[lo]+nums[hi]< target- (nums[i]+nums[j])){
                                // this skip duplicate elements and thus improve performance; note: has to put it before low++
                                while(lo<hi && nums[lo+1] == nums[lo])
                                    lo++;
                                lo ++;
                            }
                            else{
                                res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                                // this is to avoid duplicates in the solutions
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
            }
        }
        return res;
    }
}
