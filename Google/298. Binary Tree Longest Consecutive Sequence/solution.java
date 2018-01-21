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
	private int maxLen;
  
	public int longestConsecutive(TreeNode root) {
		if(root == null)
			return 0;
		search(root, root.val, 0);
		return maxLen;
	}
	// search target starting from root
	private void search(TreeNode root, int target, int len){
		if(root == null ){
			return;
		}
		if(root.val == target){	// initialize len=0 since search starts from root
			len++;
		}
		else
			len=1;	// reset len=1 since below we start search from subtree of root
		maxLen = Math.max(maxLen, len);
		search(root.left, root.val+1, len);
		search(root.right, root.val+1, len);
	}
}
