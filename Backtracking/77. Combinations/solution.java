// backtracking

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> templist, int k, int n, int start){
        if(k == 0)
            res.add(new ArrayList(templist));
        else if(k >0){
            for(int i=start; i<n+1; i++){
                templist.add(i);
                backtrack(res, templist,k-1, n, i+1);
                templist.remove(templist.size()-1);
            }
        }
    }
}
