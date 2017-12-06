// Morris traversal - preorder

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root, pre;
        while( cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }
            else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur)    // find precedence node of cur
                    pre = pre.right;
                
                if(pre.right == null){
                    res.add(cur.val);   // only this line is different from inorder traversal
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    pre.right = null;  // recover the tree
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
