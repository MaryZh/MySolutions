// backtracking: for each num = 0~n-1, add the num to a templist  and search for (target-num)=0~n-1. There are three cases. 
// If (target-num<0), stop seaching; (target-num=0), add templist to res; if (target - num > 0), continue search.

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(candidates); // not necessary
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
                templist.add(nums[i]);
                backtrack(nums, res, templist, target - nums[i], i);    // start from i since each number is reusable
                templist.remove(templist.size()-1); // after exhaust search for current num, remove it and try the next num
            }
        }
    }
}
