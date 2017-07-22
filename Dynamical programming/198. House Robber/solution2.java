public class Solution {
    public int rob(int[] nums) {
        // Method #2
        int preno = 0, preyes=0; 
        for(int n:nums){
            int temp = preno;
            preno = Math.max(preno, preyes);
            preyes =n+temp;
        }
        return Math.max(preyes,preno);
    }
}
