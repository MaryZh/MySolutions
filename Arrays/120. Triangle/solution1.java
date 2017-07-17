// top-down solution. slow.
// Use two HashMap/ArrayList's to store minPath for cur and next row.

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // min path sum for current row (index, minpath)
        HashMap<Integer, Integer> res =  new HashMap<>();
        // initialize for 0th row
        res.put(0,triangle.get(0).get(0));
        
        for(int i =1; i<triangle.size(); i++){
            // current row
            List<Integer> cur = triangle.get(i);
            HashMap<Integer, Integer> newres =  new HashMap<>();
            for(int j=0; j<cur.size(); j++){
                newres.put(j, Math.min(res.getOrDefault(j-1,Integer.MAX_VALUE), res.getOrDefault(j,Integer.MAX_VALUE) ) + cur.get(j) );
            }
            res = newres;
        }
        int minPath = Integer.MAX_VALUE;
        for(int k:res.values()){
            minPath = Math.min(minPath, k);
        }
        return minPath;
    }
}

// Use ArrayList
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // min path sum for current row (index, minpath)
        ArrayList<Integer> res =  new ArrayList<>();
        // initialize for 0th row
        res.add(triangle.get(0).get(0));
        
        for(int i =1; i<triangle.size(); i++){
            // current row
            List<Integer> cur = triangle.get(i);
            ArrayList<Integer> newres =  new ArrayList<>();
            for(int j=0; j<cur.size(); j++){
                newres.add(Math.min( j-1>=0?res.get(j-1):Integer.MAX_VALUE, j<res.size()?res.get(j):Integer.MAX_VALUE ) + cur.get(j) );
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
