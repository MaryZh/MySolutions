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
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        
        return Math.max(res[0],res[1]);
    }
    // use a 2D array to store (1) max when don't rob root; (2) max when rob root.
    private int[] robSub(TreeNode root){
        if(root == null)
            return new int[2];
        
        int[] leftRes = robSub(root.left);
        int[] rightRes = robSub(root.right);
        
        int[] res = new int[2];
        res[0] = Math.max(leftRes[0],leftRes[1])+Math.max(rightRes[0],rightRes[1]);
        res[1] = root.val + leftRes[0] + rightRes[0];
        
        return res;
    }
}
