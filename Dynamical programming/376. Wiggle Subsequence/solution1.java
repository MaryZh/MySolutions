// Time: O(n). Space: O(n).

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        int[] up = new int[n];  // # of wiggles ending at i, and ending with up/down wiggles
        int[] down =  new int[n];
        
        up[0]=1;
        down[0]=1;
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]){
                up[i] = down[i-1]+1;
                down[i]=down[i-1];
            }
            else if(nums[i]<nums[i-1]){
                down[i]=up[i-1]+1;
                up[i]=up[i-1];
            }
            else{
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }
}
