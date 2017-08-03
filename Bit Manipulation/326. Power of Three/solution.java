public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        double power = Math.log10(n)/Math.log10(3);
        // determine if the power is an int
        return power%1 ==0;
    }
}
