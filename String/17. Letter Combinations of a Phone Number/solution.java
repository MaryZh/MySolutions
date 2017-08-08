public class Solution {  
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> res = new ArrayList<String>();
        if(digits.length()==0)
            return res;
        
        backtrack(res, "", digits, 0, map);
        
        return res;
    }
    
    private void backtrack(List<String> res, String temp, String digits, int start, Map<Character, String> map){
        if(start == digits.length()){
            res.add(temp);
        }
        else{
            String cur = map.get(digits.charAt(start));
            for(int i=0; i<cur.length(); i++){
                temp += cur.charAt(i);
                backtrack(res, temp, digits, start+1, map);
                temp = temp.substring(0,temp.length()-1);
            }
        }
    }
}
