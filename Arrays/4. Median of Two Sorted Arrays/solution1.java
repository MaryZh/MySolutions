public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // this has time complexity O(m+n)
        int m = nums1.length, n=nums2.length;
        int[] merge = new int[m+n];
        int i=0, j=0, k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j])
                merge[k++] = nums1[i++];
            else
                merge[k++] = nums2[j++];
        }
        while(i<m){
            merge[k++] = nums1[i++];
        }
        while(j<n){
            merge[k++] = nums2[j++];
        }
        for(int num:merge)
            System.out.println(num);
        if((m+n)%2==0)
            return (merge[(m+n)/2]+merge[(m+n)/2-1])/2.;
        return merge[(m+n)/2];
    }
}
