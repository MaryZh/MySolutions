// same idea as (39. combinaionSum)

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // this is necessary because sort put same elements together, so that we can skip duplicates like belew
        backtrack(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, int target, int start){
        if(target < 0)
            return;
        else if(target == 0)
            res.add(new ArrayList(templist) );
        else{
            for(int i=start; i<nums.length; i++){
                if(i>start && nums[i]==nums[i-1])   // skip duplicates; this is done for each possible num can be in the reult list
                    continue;
                templist.add(nums[i]);
                backtrack(nums, res, templist, target - nums[i], i+1);    // start from i+1 since each number can only be used once
                templist.remove(templist.size()-1); // after exhaust search for current num, remove it and try the next num
            }
        }
    }
}
