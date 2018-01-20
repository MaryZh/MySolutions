public class StringIterator {
	private String s;
	private int curIndex;
	private int len;
	private char cur;
	private int count;
	public StringIterator(String s){
		this.s=s;
		this.len=s.length();
	}
	public char next(){
		if( !hasNext())
			return ' ';
		// if char at curIndex is a number, return previous char
		if(count == 0) {	// in this case, next cur has to be a letter
			cur = s.charAt(curIndex);
			curIndex++;
			// reset count
			while(curIndex<len && Character.isDigit(s.charAt(curIndex))) {
				count = 10*count+(s.charAt(curIndex)-'0');
				curIndex++;
			}
		}
		count--;
		return cur;
	}
	public boolean hasNext(){
		if(curIndex == len && count==0)
			return false;
		return true;
	}
}
