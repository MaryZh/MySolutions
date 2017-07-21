/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if( n== 0)
            return new ArrayList<>();
        return generate(1,n);
    }
    
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i=start; i<=end; i++){
            // TreeNode head = new TreeNode(i); // it's wrong to put this line here
            List<TreeNode> leftRes = generate(start,i-1);
            List<TreeNode> rightRes = generate(i+1,end);
            for(TreeNode leftnode:leftRes){
                for(TreeNode rightnode:rightRes){
                    TreeNode head = new TreeNode(i);    // has to put this line here, so that each time it creates a new tree
                    head.left = leftnode;
                    head.right = rightnode;
                    res.add(head);
                }
            }
        }
        return res;
    }
}
