public class Solution {
    HashMap<String, List<String>> map =  new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        
        if(map.containsKey(s))
            return map.get(s);
        
        if(wordDict.contains(s))
            res.add(s);
        
        for(int i=1; i< s.length(); i++){   // i is the end of current exmained subtring(exclusive)
            String cur = s.substring(0, i);
            if(wordDict.contains(cur)){
                List<String> sublist = wordBreak(s.substring(i), wordDict);
                if(!sublist.isEmpty()){
                    for(String sub:sublist){
                        res.add(cur+" "+sub);
                    }
                }
            }
        }
        
        map.put(s, res);
        
        return res;
    }
}
