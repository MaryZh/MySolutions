public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), 0, new boolean[nums.length]);
        
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, int start, boolean[] used){
        // ArrayList<Integer> cur = new ArrayList(templist);
        // if(! res.contains(cur))
        //     res.add(cur);
        res.add(new ArrayList(templist));
        
        for(int i=start; i<nums.length; i++){
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) 
                continue;
            templist.add(nums[i]);
            used[i]=true;
            backtrack(nums, res, templist,i+1, used);
            templist.remove(templist.size()-1);
            used[i]=false;
        }
    }
}
