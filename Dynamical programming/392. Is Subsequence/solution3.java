// Use two pointer, indexS and indexT. Time: O(tlen).

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length(), tlen=t.length();
        if(slen ==0 || s.equals(t))
            return true;
        int indexS=0, indexT=0;
        while(indexT<tlen){
            if(s.charAt(indexS) == t.charAt(indexT) ){
                indexS++;
            }
            
            indexT++;
            
            if( indexS == slen)
                return true;
        }
        return false;
    }
}
