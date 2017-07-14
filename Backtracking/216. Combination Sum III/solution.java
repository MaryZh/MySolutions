public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> templist, int k, int target, int start){
        if(target == 0 && templist.size() == k)
            res.add(new ArrayList(templist) );
        else if(target > 0 && templist.size() < k){
            for(int i=start; i<=9; i++){
                templist.add(i);
                backtrack(res, templist, k, target - i, i+1);    // start from i+1 since each number can only be used once
                templist.remove(templist.size()-1); 
            }
        }
    }
}
