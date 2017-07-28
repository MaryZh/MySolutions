public class Solution {
    boolean hasCycle = false;
    Stack<Integer> res = new Stack<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj =  new ArrayList<>();
        boolean[] marked =  new boolean[numCourses];
        boolean[] onstack = new boolean[numCourses];
        
         for(int v=0; v<numCourses; v++)
             adj.add( new ArrayList<Integer>() );
        
        int n=prerequisites.length;
        for(int i=0; i<n; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int v=0; v<numCourses; v++){
            if(!marked[v] ){
                dfs(adj, marked, onstack, v);
            }
        }
        // move results into int[]
        if(hasCycle)
            return new int[0];
            
        int[] result = new int[numCourses];
        for(int j=0; j<numCourses; j++)
            result[j]=res.pop();
        return result;
    }
    private void dfs(List<List<Integer>> adj, boolean[] marked, boolean[] onstack, int v){
        onstack[v]=true;
    	marked[v]=true;
        for(int w:adj.get(v) ){
            if(hasCycle)  // this test saves a lot of recursions
                return;
            else if(!marked[w])
                dfs(adj, marked, onstack, w);
            else if(onstack[w]){ // if w is marked and is onstack, that means we find a cycle
                hasCycle =true;
                return;
            }
        }
        res.push(v);    // after exmine all v's neighbors, push v in
        onstack[v]=false;
    }
}
