// for each i, mark the number at nums[i-1] to be negative, if it's alreay negative, that means the ith number alreay appears

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0){
                res.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
