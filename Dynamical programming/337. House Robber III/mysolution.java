// 1179 ms

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
        int robroot = 0, noroot =0;
        if(root == null)
            return 0;
        TreeNode leftnode = root.left, rightnode = root.right;
        robroot = root.val+ (leftnode ==null?0: rob(leftnode.left)+rob(leftnode.right) )+(rightnode ==null?0: rob(rightnode.left)+rob(rightnode.right) );
        noroot = rob(leftnode)+rob(rightnode);
        
        return Math.max(robroot, noroot);
    }
}
