// 4ms

public class Solution {
    public int majorityElement(int[] nums) {
        // method #2
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
