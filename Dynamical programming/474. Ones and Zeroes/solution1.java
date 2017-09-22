// backtracking. My solution. TLE

class Solution {
    private int maxlen=0;
    
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // save number of 0's and 1's for each string
        int[][] array = new int[len][2];
        for(int i=0; i<len; i++){
            String temp = strs[i];
            int ones = ones(temp);
            int zeros = temp.length()-ones;
            array[i][0]=zeros;
            array[i][1]=ones;
        }
        
        search(strs, array, m, n, 0, 0);
        return maxlen;
    }
    private void search(String[] strs, int[][] array, int m, int n, int len, int start){
        // don't have to use all m 0's and n 1's
        maxlen = Math.max(maxlen, len);
        
        for(int i=start; i<strs.length; i++){
            int zeros = array[i][0], ones = array[i][1];
            
            int m0=m, n0= n;
            if(m>=zeros && n>=ones)
                search(strs, array, m0-zeros, n0-ones, len+1, i+1);
        }
    }
    private int ones(String s){
        int count=0;
        for(char c:s.toCharArray()){
            if(c=='1')
                count++;
        }
        return count;
    }
}
