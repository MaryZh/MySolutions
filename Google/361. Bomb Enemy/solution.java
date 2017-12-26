// idea is iterate through the grid, count enemies for each row and column before hitting
// a wall. 
// Note: 1. Need to redo the counting after hitting a wall.
// 2. can save the counts in two arrays array, rowEn, colEn
// 3. since we iterate along rows, after done with a row, # of enemies in this row 
// is no longer needed, so only need to use one variable to save this data
// 
// Time: O(3mn), one for iteration, one for row scan, one for col scan.


public class Solution {
	public int maxKilledEnemies(char[][] grid) {
		int m = grid.length;
		if(m==0)
			return 0;
		int n = grid[0].length;
		
		int res = 0;
		int rowEn=0;
		int[] colEn = new int[n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				// after starting a new row(j=0), or after a wall, count enemies in the row
				if(j==0 || grid[i][j-1] == 'W') {
					rowEn = 0;	// reset the variable to 0
					// count enemies in the row
					for(int k=j; k<n && grid[i][k] != 'W'; k++) {
						if(grid[i][k] == 'E')
							rowEn++;
					}
				}
				// at the very beginning(i=0), or after a wall, count enemies in the col
				if(i==0 || grid[i-1][j] == 'W') {
					colEn[j] = 0;	// reset the col data
					for(int k=i; k<m && grid[k][j] != 'W'; k++) {
						if(grid[k][j] == 'E')
							colEn[j]++;
					}
				}
				// update the result only at an empty cell
				if(grid[i][j] == '0')
					res = Math.max(res, rowEn+colEn[j]);
			}
		}
		return res;
}
