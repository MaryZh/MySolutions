// backtracking

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>());
        
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist){
        if(templist.size()== nums.length)  // condition to stop current search
            res.add(new ArrayList(templist));
        else{
            for(int i=0; i<nums.length; i++){   // i always starts from 0 because the next num to be put in templist can be anyone in nums
                if(templist.contains(nums[i]))  // other than those already in templist
                    continue;
                templist.add(nums[i]);
                backtrack(nums, res, templist);
                templist.remove(templist.size()-1);
            }
        }
    }
}
