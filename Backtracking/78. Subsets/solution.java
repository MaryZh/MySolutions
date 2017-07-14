public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0, new boolean[nums.length]);
        
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, int start, boolean[] used){
        res.add(new ArrayList(templist));
        
        for(int i=start; i<nums.length; i++){
            if(used[i]) 
                continue;
            // if(templist.contains(nums[i]) )  // either use this or boolean array used to determine if an elment in nums has been used or not
            //    continue;
            templist.add(nums[i]);
            used[i]=true;
            backtrack(nums, res, templist,i+1, used);
            templist.remove(templist.size()-1);
            used[i]=false;
        }
        
    }
}
