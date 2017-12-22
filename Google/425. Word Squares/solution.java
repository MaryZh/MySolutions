public class Solution {
	// trie
	public class Trie{
		private TrieNode root;
		
		public Trie(){
			root = new TrieNode();
		}
		
		// trie node
		private class TrieNode{
			List<String> startWith;
			TrieNode[] next;
			
			public TrieNode() {
				startWith = new ArrayList<>();
				next = new TrieNode[26];
			}
		}
		// need put method
		public void put(String s) {
			TrieNode cur = root;
			for(char c:s.toCharArray()) {
				int index = c-'a';
				if(cur.next[index] == null)
					cur.next[index] = new TrieNode();
				cur.next[index].startWith.add(s);
				cur = cur.next[index];
			}
		}
		// need a method to find all words start with a prefix
		public List<String> findByPrefix(String prefix){
			TrieNode cur = root;
			for(char c:prefix.toCharArray()) {
				int index = c-'a';
				if(cur.next[index] == null)
					return new ArrayList<>();
				cur = cur.next[index];
			}
			return cur.startWith;
		}
	}
	
	
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<>();
		// build the trie
		Trie trie = new Trie();
		for(String word:words) {
			trie.put(word);
		}
		// build wordSquare starting with each of words
		for(String word:words) {
			List<String> templist = new ArrayList<>();
			templist.add(word);
			build(trie, res, templist, word.length());
		}
		return res;
	}
	// find word squares started with word
	private void build(Trie trie, List<List<String>> res, List<String> templist, int n) {
		if (templist.size() == n) {
			res.add(new ArrayList<>(templist));
			return;
		}
		int index = templist.size();
		// build common prefix
		StringBuilder buildPrefix = new StringBuilder();
		for (String s : templist) {
			buildPrefix.append(s.charAt(index));
		}
		String prefix = buildPrefix.toString();
		// find all words start with prefix
		List<String> startWithPrefix = trie.findByPrefix(prefix);
		// try out all those words
		for (String nextWord : startWithPrefix) {
			if(nextWord.length() != n)
				continue;
			templist.add(nextWord);
			build(trie, res, templist, n);
			templist.remove(templist.size()-1);
	}
}
