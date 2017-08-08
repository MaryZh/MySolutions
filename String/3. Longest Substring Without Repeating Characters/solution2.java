// Same idea as solution1, but use an int[] to store index.
//
// Time: O(n). 40ms.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int[] index = new int[128]; // store index of c
        
        int i=0;
        for(int j=0; j<n; j++){
            char c = s.charAt(j);
            // update i to j'+1
            i = Math.max(index[c],i);
            // update result
            res = Math.max(res, j-i+1); // the length of [i,j) is j-i+1
            index[c]= j+1;
        }
        
        return res;
    }
}
