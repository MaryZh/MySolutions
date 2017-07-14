// backtracking

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i]=i+1;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), k, 0, new boolean[nums.length]);
        
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> templist, int k, int start, boolean[] used){
        if(templist.size() ==k)
            res.add(new ArrayList(templist));
        else if(templist.size() < k){
            for(int i=start; i<nums.length; i++){
                if(used[i]) 
                    continue;
                templist.add(nums[i]);
                used[i]=true;
                backtrack(nums, res, templist,k,i+1, used);
                templist.remove(templist.size()-1);
                used[i]=false;
            }
        }
    }
}
