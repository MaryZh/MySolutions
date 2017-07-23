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
    HashMap<TreeNode, Integer> map = new HashMap<>();  // store (root, result) for substree starting with root
    
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        TreeNode leftnode = root.left, rightnode = root.right;
        int robroot = root.val+ (leftnode ==null?0: rob(leftnode.left)+rob(leftnode.right) )+(rightnode ==null?0: rob(rightnode.left)+rob(rightnode.right) );
        int noroot = rob(leftnode)+rob(rightnode);
        
        int max = Math.max(robroot, noroot);
        
        map.put(root, max);
        
        return max;
    }
}
