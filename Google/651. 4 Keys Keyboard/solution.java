public class Solution {
	public int maxA(int n) {
		int max = n;  // if no copying
		// use i steps to reach maxA(i), and n-i steps to make n-i-1 copies
		for(int i=1; i<n; i++){
			max = Math.max(max, maxA(i)*(n-i-1));
		}
		return max;
	}
}
