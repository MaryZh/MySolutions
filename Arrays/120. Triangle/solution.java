// bottom -up solution. Use only one extra array.

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // min path sum for current row; initialize for last row
        int size = triangle.size();
        List<Integer> lastrow = triangle.get(size-1);
        int[] res = new int[lastrow.size()];
        for(int i=0; i<lastrow.size(); i++)
            res[i] = lastrow.get(i);
        
        for(int i =size-2; i>=0; i--){
            // current row
            List<Integer> cur = triangle.get(i);
            int n=cur.size();
            for(int j=0; j<n; j++){
                res[j]=Math.min( res[j],res[j+1] ) + cur.get(j) ;
            }
        }
        return res[0];
    }
}
