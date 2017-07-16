// still two-pointer solution. This is more readable.

public class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end =nums.length-1;
        for(int i=0; i<= end;){
            // send 0's to the frond
            if(nums[i] == 0)
                swap(nums, i++, start++);
            // send 2's to the end
            else if(nums[i] == 2 )  // after swap 2 with the end, we don't know what is now in ith position, so need to check i again
                swap(nums, i, end--);   // so don't increase i
            else
                i++;
        }
    }
    // swap two indices in nums
    private void swap(int[] nums, int i, int j){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
