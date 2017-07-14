// This problem is to find the maxArea of a square: with width abs(j-i), and height min(A[i], A[j])
// brute force method. Time complexity O(N^2). TLE.
// This is two-point method: one pointer at the beginning, the other at the end. If (left pointer length)<(right pointer legnth), the height // of the container is limited by (left pointer length), decreasing right pointer is not possible to increase the area; increasing 
// left pointeris potentially beneficial, so increasing left pointer. Update maxarea for each iteration.
//
// Time complexity: O(N). Space complexity: O(1).

public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left =0, right = n-1;
        int max = 0;
        while(left < right){
            max = Math.max(max, Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
