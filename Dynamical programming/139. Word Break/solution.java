public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        
        int n = s.length();
        // use an array where i-th element represent if 0-i(exclusive) in s can be broken into words or not
        boolean[] f =  new boolean[n+1];
        f[0]=true;
        
        for(int i=1; i<=n; i++){ // examine s.substring(0,i)
            for(int j=i-1; j>=0; j--){   // use j to split substring (0,i) into two parts
                if(f[j] && wordDict.contains(s.substring(j,i)))
                    f[i]=true;
            }
        }
        return f[n];
    }
}
