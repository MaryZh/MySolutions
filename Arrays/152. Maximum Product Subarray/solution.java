// same idea as (53. Maximum Subarray)

public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxsofar=nums[0], maxEndingHere = nums[0], minEndingHere = nums[0];
        for(int i=1; i<nums.length; i++){
            // negative number makes min ->max, and max->min; so swap maxEndingHere and MinEndingHere
            if(nums[i]<0){
                int temp = maxEndingHere;
                maxEndingHere=minEndingHere;
                minEndingHere=temp;
            }
            
            maxEndingHere = Math.max(maxEndingHere*nums[i], nums[i]);
            minEndingHere = Math.min(minEndingHere*nums[i], nums[i]);
                
            maxsofar = Math.max(maxEndingHere, maxsofar);
        }
        return maxsofar;
    }
}
