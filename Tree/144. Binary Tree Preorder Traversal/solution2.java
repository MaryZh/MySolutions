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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;  // p is the next node to be visited
        
        while( ! stack.isEmpty() || p !=null ){
            // if( p != null){  // this works as well
            //     stack.push(p);  // put a node in the stack(so that can visit it's right child latter)
            //     res.add(p.val); // visit the node
            //     p = p.left; // vistit the node's left child
            // }
            // else{
            //     TreeNode node = stack.pop();    // visit the right children
            //      p = node.right;
            // }
            while(p!=null){
                stack.push(p);
                res.add(p.val); // visit the node
                p = p.left;
            }
            TreeNode node = stack.pop();
            p = node.right;
        }
        return res;
    }
}
