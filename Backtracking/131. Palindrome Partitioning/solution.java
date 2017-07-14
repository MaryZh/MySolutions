public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        
        return res;
    }
    // start is the place of cut
    private void backtrack(List<List<String>> res, List<String> templist, String s, int start){
        if(start == s.length() )
            res.add(new ArrayList(templist) );
        else {
            for(int i=start; i<s.length(); i++){
                if( isPalindrome(s, start, i)){ // continue the search only if the current part is palindrome
                    templist.add(s.substring(start, i+1));
                    backtrack(res, templist, s, i+1);
                    templist.remove(templist.size()-1); 
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
