// 1. Starting from right, find the first number a[i]<a[i+1]. Eg. 123465987, here a[i=5]=5
// 2. From i+1 to the end, find the number which is just larger than a[i]. Eg. from i=6-8, a[j=8]=7 is just llarger than a[i]=5.
// 3. Swap a[i] and a[j], to maker the number larger.
// 4. To maker the number the smallest larger number, make i+1 to the end as small as possible, which requires make them in ascending order,
// After the swap in step 3, i+1~the end is still in descending order. So we need to reverse the order of them.
//
// Time complexity: O(N). Space complexity: O(1).

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // step 1
        int i = n-2;
        while(i>= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        // step 2: if by the end of step 1, i<0 the means the array is in descending order, then simply reverse the array
        int j = n-1;
        if(i>=0 ){
            while(j>=0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] =nums[j];
        nums[j]= temp;
    }
    
    private void reverse(int[] nums, int low, int high){
        while(low < high){
            swap(nums, low++, high--);
        }
    }
}
