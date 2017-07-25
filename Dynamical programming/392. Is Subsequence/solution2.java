// Iterative, as idea as solution1. 20ms

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length(), tlen=t.length();
        if(slen == 0 || s.equals(t))
            return true;
        int j=0, jstart =0;
        for(int i=0; i<slen; i++){
            char c = s.charAt(i);
            for(j=jstart; j<tlen; j++){
                if(c == t.charAt(j) ){
                    jstart = j+1;
                    break;
                }
            }
            if( j== tlen)
                return false;
        }
        return true;
    }
}
