// Problem 298 is top-down, where we search increasing sequence from root. When we 
// encounter a non-increasing node, we restart searching from that node.
// Here we need a bottom-up method(like in 124), so that we can need to the left/right subtrees of a root first. 
// So like 124, and unlike 298, the helper function will only take root as argument.
// The idea is to find the longest increasing and decreasing sequence starting from root. The solution is sum of the two.

class Solution {
	private int maxLen=0;
	
	public int longestConsecutive(TreeNode root) {
 		if(root == null)
			return 0;
		longestPath(root);
		return maxLen;
	}
	
	private int[] longestPath(TreeNode root){
		if(root == null ){
			return new int[]{0,0};
		}
		
		int incLen=0, decLen=0;
		if(root.left != null){
			int[] leftRes = longestPath(root.left);
			if(root.val == root.left.val+1){	
				incLen = leftRes[0]+1;
			}
			else if(root.val == root.left.val-1){
				decLen = leftRes[1] +1;
			}
		}
		if(root.right != null){
			int[] rightRes = longestPath(root.right);
			if(root.val == root.right.val+1){	
				incLen = Math.max(incLen, rightRes[0]+1);
			}
			else if(root.val == root.left.val-1){
				decLen = Math.max(decLen, rightRes[1] +1);
			}
		}
		
		maxLen= Math.max(maxLen, incLen+decLen-1);
		return new int[] {incLen, decLen};
	}
}
