// binary search

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if( m ==0)
            return false;
        int n =matrix[0].length;
        if(n==0)
            return false;
        // if( m==1 && n==1)
        //     return matrix[0][0] == target;
        int lo =0, hi = m*n-1;
        while(lo <= hi){
            int mid = lo +(hi -lo)/2;
            int midvalue = matrix[mid/n][mid%n];
            if( midvalue > target)
                hi = mid -1;
            else if(midvalue < target)
                lo = mid+1;
            else
                return true;
        }
        return false;
    }
}
