// sliding window method: for [i,j), extend j until j is alreay contained in the range; then we are done with i, and increase i.
// Say j is the same as j' which is in [i,j), then increase i to i=j'+1.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        
        Map<Character, Integer> map = new HashMap<>();  // store (c, index) pair to quickly find repeated c's index j'
        
        int i=0;
        for(int j=0; j<n; j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){ // when we get repeated c
                // update i to j'+1
                i = Math.max(map.get(c),i); // use max because we didn't remove i to j' -th elements
                // don't update res here(see explanation below)
            }
            // update result; only need to update res when there's repeated c, or reach end of s(put this here to take of this later case)
            res = Math.max(res, j-i+1); // the length of [i,j) is j-i+1
            // either j is repeated or not
            map.put(c, j+1);
        }
        
        return res;
    }
}
