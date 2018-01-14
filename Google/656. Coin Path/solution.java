// The reason to use backward solution rather than forward is to get lexicographically lower solution.
// For example, A=[1,2,3,1,2], B=2. Forward solution returns [1, 3, 5], backward solution returns [1,2,4,5].

public class Solution {
	public List<Integer> cheapestJump(int[] A, int B) {
		int n = A.length;
		List<Integer> res = new ArrayList<>();
		if(A[0]==-1 || A[n-1] == -1)
			return res;
		
		int[] dp = new int[n];	// cost up to A[i]
		int[] pathTo = new int[n];
		// initialize dp with MAX, i.e. unavailable
		for(int i=0; i<n; i++)
			dp[i] = Integer.MAX_VALUE;
		
//		// forward solution
//		dp[0]=A[0];
//		pathTo[0]=-1;
//		for(int i=1; i<n; i++) {
//			if(A[i] == -1)
//				continue;
//			for(int j=Math.min(i, B); j>=1; j--) {
//				if(dp[i-j] == Integer.MAX_VALUE)
//					continue;
//				if(dp[i-j]+A[i] < dp[i]) {
//					dp[i] = dp[i-j]+A[i];
//					pathTo[i] = i-j;
//				}
//			}
//		}
//		// build up the answer
//		if(dp[n-1] == Integer.MAX_VALUE)
//			return res;
//		for(int i=n-1; i != -1; i = pathTo[i]) {
//			res.add(0, i+1);
//		}
//		return res;
		
		// backward solution
		dp[n-1] = A[n-1];
		pathTo[n-1] = -1;
		for(int i=n-2; i>=0; i--) {
			if(A[i] == -1)
				continue;
			for(int j=i+1; j<=Math.min(n-1, i+B); j++) {
				if(dp[j] == Integer.MAX_VALUE)
					continue;
				if(dp[j]+A[i] < dp[i]) {
					dp[i] = dp[j]+A[i];
					pathTo[i] = j;
				}
			}
		}
		// build up the answer
		if(dp[0] == Integer.MAX_VALUE)
			return res;
		for(int i=0; i != -1; i = pathTo[i]) {
			res.add(i+1);
		}
		return res;
    }
}
