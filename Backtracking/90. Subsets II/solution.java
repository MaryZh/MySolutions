public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), 0);
        
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, int start){
        // ArrayList<Integer> cur = new ArrayList(templist);
        // if(! res.contains(cur))
        //     res.add(cur);
        res.add(new ArrayList(templist));
        
        for(int i=start; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]) 
                continue;
            templist.add(nums[i]);
            backtrack(nums, res, templist,i+1);
            templist.remove(templist.size()-1);
        }
    }
}
