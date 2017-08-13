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
    public List<Integer> postorderTraversal(TreeNode root) {
        // pre-order is; N-left-right; post order is: left-right-N.
        // start from pre-order, get N-right-left first, then reversal the elements order
        List<Integer> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;  // p is the next node to be visited
        
        while( ! stack.isEmpty() || p !=null ){
            // the commented out code works as well
            // if( p != null){
            //     stack.push(p);  // put a node in the stack(so that can visit it's right child latter)
            //     res.add(0,p.val); // visit the node
            //     p = p.right; // vistit the node's right child
            // }
            // else{
            //     TreeNode node = stack.pop();    // visit the left children
            //      p = node.left;
            // }
            while(p!=null){
                stack.push(p);
                res.add(0, p.val);
                p = p.right;
            }
            TreeNode node = stack.pop();
            p = node.left;
        }
        return res;
    }
}
