// TLE

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backtrack(s, wordDict, res, "", 0);
        return res;
    }
    private void backtrack(String s, List<String> wordDict, List<String> res, String temp, int start){
        if(start == s.length()){
            res.add(temp);
        }
        else{
            for(int i=start+1; i<=s.length(); i++){    // i is the end of substring(exclusive)
                String sub = s.substring(start,i);
                if(wordDict.contains(sub)){
                    if(temp.length() >0 && temp.charAt(temp.length()-1) != ' ')
                        temp +=" ";
                    temp += sub;
                    backtrack(s, wordDict, res, temp, i);
                    // remove the last added word in temp
                    while(temp.length()>0 && temp.charAt(temp.length()-1) != ' ')
                        temp = temp.substring(0,temp.length()-1);
                }
            }
        }
    }
}
