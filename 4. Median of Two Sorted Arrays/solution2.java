// This solution has time complexity O(log(mind(m,n)))
// The idea is that based on the definition of a median of an array of length n: dividing a set into two equal length subset, that  one subset if always greater than the other.
// If we do a random cut at (i-1 / i) with i=0~m, (lenfth of left_part) = i, (lenfth of left_part) = n-i. And a median satisfies: (1) length(left_part) == length(right_part), (2) max(left_part) < min(right_part)

// To satisfy the first condition, if we do a cut in array A at (i-1/ i), the cut at array be has to be at (j-1 / j), with j = (m+n+1)/2-i.

// Here j is calculated from i+j = m-i+n-j(if m+n is even) or i+j = m-i+n-j+1(if m+n is odd), so j = (m+n)/2-i(if m+n is even) or j = (m+n+1)/2-i(if m+n is odd)

// Then find i satisfying the second condition(use binary search).
    
    
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // this is to ensure j is non-negative; if m>n, then (m+n+1)/2 <m
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int m = nums1.length, n =nums2.length;
        // find perfect i(satisfying the second condition) use binary search
        int imin =0, imax =m, mid = (m+n+1)/2, i=0,j=0;
        int left_max = 0, right_min=0;
        while(imin<=imax){
            i = (imax+imin)/2;
            j = mid-i;
            
            if(i<m && nums2[j-1]>nums1[i])  // if i is too small, or j is too large
                imin = i+1;
            else if(i>0 && nums1[i-1]>nums2[j]) // if i is too large, or j is too small
                imax = i-1;
            else{   // if i is perfect  
                break;
            }
        }
        // after finding perfect i, find max of the left part, and min of the right part
        if(i==0)
            left_max = nums2[j-1];
        else if(j==0)
            left_max= nums1[i-1];
        else
            left_max = Math.max(nums1[i-1],nums2[j-1]);
        
        if( (m+n)%2 ==1 )
            return left_max;
        
        if(i==m)
            right_min = nums2[j];
        else if(j==n)
            right_min=nums1[i];
        else
            right_min = Math.min(nums1[i],nums2[j]);
        
        return (left_max+right_min)/2.;
        
    }
}
