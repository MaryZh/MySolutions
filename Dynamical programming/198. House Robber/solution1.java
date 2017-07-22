public class Solution {
    public int rob(int[] nums) {
        // go to alternative houses, either start from 0, or 1, index with 2n+0, or 2n+1
        int oddsum = 0, evensum=0; // oddsum=maxsofar_endingatoddindex, evensum = maxsofar_endingatevenindex
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0){
                evensum = Math.max(evensum+nums[i],oddsum);
            }
            else{
                oddsum =Math.max(oddsum+ nums[i], evensum);
            }
        }
        return Math.max(evensum,oddsum);
    }
}
