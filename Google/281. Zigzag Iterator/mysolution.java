// initialization: time: O(total elements),space: O(n)
// next: time O(n) because of while loop
// hasNext: time O(1)

public class ZigZagIterator {
	private List<List<Integer>> vecs;
	private int n;	// #  of vectors
	private int total;	// total # of elements
	private int nextVector;	// nextVector= # of visited elements; %n=index of next vector in vecs
	private int[] state;	// the next index for each vector
	
	public ZigZagIterator(List<List<Integer>> vecs) {
		this.vecs = vecs;
		n = vecs.size();
		for(List<Integer> s:vecs) {
			total += s.size();
		}
		// nextVector=0;
		state = new int[n];	// initialized to 0
	}
	
	public int next() {
		if(!hasNext())
			throw new NoSuchElementException();
		// nextVector %= n;
		while(state[nextVector%n] == vecs.get(nextVector%n).size())
			nextVector++;
		int res = vecs.get(nextVector%n).get(state[nextVector%n]);
		// increase current vector's state by 1
		state[nextVector%n]++;
		// update nextVector
		nextVector++;
		return res;
	}
	
	public boolean hasNext() {
		return nextVector<total;
	}
}
