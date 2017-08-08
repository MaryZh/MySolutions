// expand around the center: O(n^2).
// There are totally 2*n-1 centers of palindromes(i.e. n if length is odd; n-1 if length is even).

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end=0;   // stard and end of longest palindrome
        
        for(int i=0; i<n; i++){
            int lenOdd = expandAroundCenter(s, i, i);   // length is odd
            int lenEven = expandAroundCenter(s, i, i+1);    // length is even
            
            int len = Math.max(lenOdd, lenEven);
            if(len> end - start +1){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    private int expandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;    // return the length of longest palindrome centered expanded from left, right; length = right -left+1-2
    }
}
