// First sort the arrays based on the start of interval. This way, once an interval(cur) has no overlap with 
// ith interval(cur.end < interval.start), it won't have overlap with the intervals to the right.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals;
        
        // sort the arrays based on the start of interval
        intervals.sort( (a, b) -> a.start -b.start);
        
        List<Interval> res = new ArrayList<>();
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval:intervals){
            // if it has overlap with the current examined interval
            if(interval.start <= end)
                end = Math.max(end, interval.end);
            else{   // if there is no overlap, save the extended interval; and examine the next interval
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        // save the last interval
        res.add(new Interval(start, end));
        
        return res;
    }
}
