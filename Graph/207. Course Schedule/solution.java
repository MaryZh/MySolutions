public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            if(!marked[v] && dfs(adj, marked, onstack, v)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adj, boolean[] marked, boolean[] onstack, int v){
    	if(marked[v])
    		return false;
    	
    	marked[v]=true;
        onstack[v]=true;
        for(int w:adj.get(v) ){
            if(onstack[w] || dfs(adj, marked, onstack, w))
                return true;
        }
        onstack[v]=false;
        return false;
    }
}
