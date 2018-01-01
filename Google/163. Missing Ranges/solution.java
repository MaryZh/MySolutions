public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		int next = lower;	// next expected number
		
		for(int num:nums) {
			if(num<next)	// not within the range yet
				continue;
			
			if(num == lower)
				next++;
			else {
				if(num == next+1)
					res.add(next+"");	// only next is missing
				else {
					// [next, num-1] is missing
					res.add(next+"->"+ (num-1));
				}
				next = num+1;
			}
		}
		
		if(next == upper)
			res.add(upper+"");
		else if(next<upper)
			res.add(next+"->"+upper);
			
		return res;
	}
}
