// top-down solution. 7ms (85.71%).
// Use two int[]'s to store minPath for cur and next row. (Note: use ArrayList/HashMap would be mush slower.)

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // min path sum for current row (index, minpath)
        int[] res =  new int[1];
        // initialize for 0th row
        res[0]=triangle.get(0).get(0);
        
        for(int i =1; i<triangle.size(); i++){
            // current row
            List<Integer> cur = triangle.get(i);
            int n=cur.size();
            int[] newres =  new int[n];
            for(int j=0; j<n; j++){
                newres[j]=Math.min( j-1>=0?res[j-1]:Integer.MAX_VALUE, j<i?res[j]:Integer.MAX_VALUE ) + cur.get(j) ;
            }
            res = newres;
        }
        int minPath = Integer.MAX_VALUE;
        for(int k:res){
            minPath = Math.min(minPath, k);
        }
        return minPath;
    }
}
