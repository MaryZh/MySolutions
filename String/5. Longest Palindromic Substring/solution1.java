// brute-force method: O(n^3).

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        String res ="";
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                // System.out.println("i="+i+", j= "+j);
                if(isPalindromic(s, i, j) && j-i+1 > len){
                    len = j-i+1;
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
    private boolean isPalindromic(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
