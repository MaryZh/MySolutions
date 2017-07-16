public class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end =nums.length-1;
        for(int i=0; i<= end; i++){
            // send 2's to the end
            while(nums[i] == 2 && i <= end)
                swap(nums, i, end--);
            // send 0's to the beginning
            while(nums[i] == 0 && i >= start)
                swap(nums, i, start++);
        }
    }
    // swap two indices in nums
    private void swap(int[] nums, int i, int j){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
