public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, int start){
        res.add(new ArrayList(templist));
        
        for(int i=start; i<nums.length; i++){
            templist.add(nums[i]);
            backtrack(nums, res, templist,i+1, used);
            templist.remove(templist.size()-1);
        }
        
    }
}
