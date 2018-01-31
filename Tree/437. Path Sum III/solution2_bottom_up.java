// prefix sum, similar as Two Sum
// bottom-up solution, time: O(n)

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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> presum =  new HashMap<>();
        presum.put(0,1);
        return helper(root, 0, sum, presum);
    }
    // search starting from subtree rooted at root
    private int helper(TreeNode root, int cursum, int target, Map<Integer, Integer> presum){
        if(root == null)
            return 0;
        // add root value to cursum
        cursum += root.val;
        // in presum, we search cursum-target
        int res = presum.getOrDefault(cursum-target, 0);
        
        presum.put(cursum, presum.getOrDefault(cursum,0)+1);
        
        res += helper(root.left, cursum, target, presum)+helper(root.right, cursum, target, presum);
        
        presum.put(cursum, presum.get(cursum)-1);
        
        return res;
    }
}
