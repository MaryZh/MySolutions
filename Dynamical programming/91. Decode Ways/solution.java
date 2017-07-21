public class Solution {
    public int numDecodings(String s) {
        int n= s.length();
        if(n==0 )
            return 0;
        
        int[] f = new int[n+1]; // sotre # of decoding for the substring starting at i
        f[n]=1;
        f[n-1]=s.charAt(n-1)=='0'?0:1;
        
        for(int i=n-2; i>=0; i--){
            if(s.charAt(i)=='0')
                continue;
            f[i]=f[i+1]+(Integer.valueOf(s.substring(i,i+2))>26?0:f[i+2] );
        }
        
        return f[0];
    }
}
