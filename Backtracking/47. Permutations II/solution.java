// same idea as (46. Permutations)
// When building templist, if nums[i] is already used, skip since we can only use each element once. (can use the same technique in 46 too)
//
// If nums[i] is not used, check if it is the same as the previous element nums[i-1]. If they are the same, check if nums[i-1] is used or 
// not. If nums[i-1] is used, that means it belong to the candidate list of previous number search, we can use nums[i] in current number 
// search; if nums[i-1] is not used, it belong to current number search, to avoid duplicate, we will skip nums[i].
//
// So the condition to skip nums[i] is: (nums[i] is used), or (nums[i] =nums[i]) && (nums[i-1] is used)

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // sort so that we can avoid duplicates as below
        backtrack(nums, res, new ArrayList<>(), new boolean[nums.length]);
        
        return res;
    }
    // use a boolean array to indicate if each element in nums has been used or not
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, boolean[] used){
        if(templist.size()== nums.length)  // condition to stop current search
            res.add(new ArrayList(templist));
        else{
            for(int i=0; i<nums.length; i++){ 
                if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1]))   // (to use each element only once) || (to avoid duplicates)
                    continue;
                templist.add(nums[i]);
                used[i] = true;
                backtrack(nums, res, templist, used);
                templist.remove(templist.size()-1);
                used[i] =false;
            }
        }
    }
}
