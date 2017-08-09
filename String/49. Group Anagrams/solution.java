// convert each string into char[] and then sort, and convert to string again. If two strings are anagrams, they must be same after sort
// use the sorted string as key; and pair up key and all its anagrams.

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length ==0)
            return new ArrayList<>();
        
        int n= strs.length;
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            String s0=strs[i];
            char[] cs= strs[i].toCharArray();
            Arrays.sort(cs);
            String s =new String(cs);
            if(!map.containsKey(s))
                map.put(s, new ArrayList<String>());
            map.get(s).add(s0);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}
