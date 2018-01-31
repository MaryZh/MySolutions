// iterative

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while( !stack.isEmpty() || p != null){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            p = node.right;
        }
        return res;
    }
}
