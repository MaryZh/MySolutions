public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for(int i=0; i<9; i++)
            nums[i]=i+1;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<Integer>(), k, n, 0);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, int k, int target, int start){
        if(target == 0 && templist.size() == k)
            res.add(new ArrayList(templist) );
        else if(target > 0 && templist.size()<k){
            for(int i=start; i<nums.length; i++){
                templist.add(nums[i]);
                backtrack(nums, res, templist, k, target - nums[i], i+1);    // start from i+1 since each number can only be used once
                templist.remove(templist.size()-1); 
            }
        }
    }
}
