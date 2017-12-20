public class NumMatrix {

    int[][] tree;
    int[][] nums;
    int m;
    int n;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        // initialize tree, 1-indexed
        nums = new int[m][n];
        tree = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int del = val - nums[row][col];
        nums[row][col] = val;
        row++;  // 1-indexed tree
        col++;
        while(row <= m) {
            while(col <= n) {
                tree[row][col] += del;
                row += (row & -row);
                col += (col & -col);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row1-1, col2) - sum(row2, col1-1) + sum(row1-1, col1-1);
    }
    
    public int sum(int row, int col) {
        int sum = 0;
        row++;  // 1-indexed tree
        col++;
        while(row > 0) {
            while(col > 0) {
                sum += tree[row][col];
                row -= (row & -row);
                col -= (col & -col);
            }
        }
        return sum;
    }
}
