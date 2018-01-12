// mark all the substrings in s that appears in dict

public class Solution {
	public String boldWords(String s, String[] dict) {
		int n = s.length();
		
		boolean[] marked = new boolean[n];
		// for each word in dict,
		for(String word:dict) {
			int m = word.length();
			// check is substring starting from i matches word or not
			for(int i=0; i+m<=n; i++) {
				if(s.substring(i, i+m).equals(word))
					mark(marked, i, i+m);
			}
		}
		
		// put marked chars in btw <b>, </b>
		StringBuilder sb = new StringBuilder();
		int i=0;
		while(i<n) {
			if(!marked[i]) {
				sb.append(s.charAt(i));
				i++;
			}
			else {
				sb.append("<b>");
				while(i<n && marked[i]) {
					sb.append(s.charAt(i));
					i++;
				}
				sb.append("</b>");
			}
		}
		return sb.toString();
	}
	
	private void mark(boolean[] marked, int i, int j) {
		while(i<j) {
			marked[i] = true;
			i++;
		}
	}
}
