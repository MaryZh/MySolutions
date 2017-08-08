public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        
        if(strs.length == 0 || strs[0].length() == 0)
            return "";
        breakpoint:
        for(int i=0; i< strs[0].length(); i++){ // iterate each char in 0th string
            char c = strs[0].charAt(i);
            for(int j=1; j< strs.length; j++){ // iterate through all other strings
                if( (strs[j].length() <= i) || ( ! (strs[j].charAt(i) == c)) ){
                    break breakpoint;
                }
            }
            builder.append(c);    
        }
        return builder.toString();
    }
}
