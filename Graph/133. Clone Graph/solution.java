/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();  // map btw original node and cloned node
        
        return dfs(node, map);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if(node ==null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        
        UndirectedGraphNode cloned =  new UndirectedGraphNode(node.label);
        map.put(node, cloned);
        for(UndirectedGraphNode neighbor:node.neighbors){
            cloned.neighbors.add(dfs(neighbor, map));
        }
        return cloned;
    }
}
