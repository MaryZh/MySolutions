public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0)
            return false;
        String s = Integer.toBinaryString(n);
        int sum=0;
        for(int i=0; i<s.length(); i++){
            sum += s.charAt(i)-'0';
        }
        return sum == 1;
    }
}
