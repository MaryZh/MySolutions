// solution based on (26. Remove Duplicates from Sorted Array)

public class Solution {
    public int removeDuplicates(int[] nums) {
        // use two points, one point to the where elements haven't been visited; another to where non-duplicate elements inserted
        if(nums.length == 0)
            return 0;
            
        int ncount=1;
        int len =1;
        
        for(int i=1; i<nums.length; i++){
            if( !(nums[i] == nums[i-1])){
                ncount =1;
                nums[len++]=nums[i];
            }
            else{
                ncount++;
                if(ncount <= 2)
                    nums[len++]=nums[i];
            }
        }
        return len;
    }
}
