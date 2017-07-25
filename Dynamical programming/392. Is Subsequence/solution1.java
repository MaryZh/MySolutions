// Recursive. Time: O(slen*tlen).

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        if(slen == 0 || s.equals(t))
            return true;
        for(int i=0; i<t.length(); i++){
            if(s.charAt(0) == t.charAt(i) )
                return isSubsequence(s.substring(1), t.substring(i+1));
        }
        return false;
    }
}
